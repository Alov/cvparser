package me.alov.cvparser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String generalInfo;
    private String experience;
    private String skills;
    private String education;
    private String about;

}
