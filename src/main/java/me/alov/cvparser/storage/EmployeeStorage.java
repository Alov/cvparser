package me.alov.cvparser.storage;

import me.alov.cvparser.model.Employee;

public class EmployeeStorage implements Storage<Employee, Long> {

    public Employee save(Employee entity) {
        return entity;
    }
}
