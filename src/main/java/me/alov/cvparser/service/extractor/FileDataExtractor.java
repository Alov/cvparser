package me.alov.cvparser.service.extractor;

import java.io.File;
import java.io.IOException;

public interface FileDataExtractor {

    String extract(File file) throws IOException;
}
