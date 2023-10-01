package me.alov.cvparser.service;

import me.alov.cvparser.model.Employee;
import me.alov.cvparser.model.SupportedType;
import me.alov.cvparser.service.extractor.DocXExtractor;
import me.alov.cvparser.service.extractor.FileDataExtractor;
import me.alov.cvparser.service.extractor.PdfExtractor;
import me.alov.cvparser.service.extractor.RtfExtractor;
import me.alov.cvparser.service.filler.DataFiller;
import me.alov.cvparser.service.filler.HhDataFiller;
import me.alov.cvparser.storage.EmployeeStorage;
import me.alov.cvparser.storage.Storage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class EmployeeService {

    private final Storage employeeStorage;
    private final DataFiller dataFiller;
    public EmployeeService() {
        dataFiller = new HhDataFiller();
        employeeStorage = new EmployeeStorage();
    }

    public void createEmployee(File file) throws IOException {
        //парсим
        FileDataExtractor extractor = this.obtainExtractor(file);
        String text = extractor.extract(file);

        Employee employee = dataFiller.fillData(text);

        employeeStorage.save(employee);
    }


    private FileDataExtractor obtainExtractor(File file) {
        String fileName = file.getName();
        String extension = file.getName().substring(fileName.lastIndexOf("."), fileName.length());
        SupportedType type = SupportedType.getByString(extension);

        switch (type) {
            case PDF:
                return new PdfExtractor();
            case RTF:
                return new RtfExtractor();
            case DOCX:
                return new DocXExtractor();
        }
        throw new RuntimeException("Can't obtain extractor for file " + fileName);
    }

}
