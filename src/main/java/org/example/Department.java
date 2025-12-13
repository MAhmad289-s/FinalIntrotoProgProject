package org.example;

import jdk.jshell.execution.Util;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Department {
    private String departmentId;
   @Setter private String departmentName;
    public static int nextId = 1;
    /**
     * checks if a department name is valid or not,
     * a department name should only contain letters or space
     * @param departmentName The department name input.
     * @return true or false
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null) {
            return false;
        }
        for (int i = 0; i < departmentName.length(); i++) {
            char c = departmentName.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }
    public Department(String departmentName) {
        if (!isDepartmentNameValid(departmentName)) {
            this.departmentId = null;
            this.departmentName = null;
            return;
        }
        this.departmentId = "D" + String.format("%02d", nextId++);
        this.departmentName = departmentName;
    }
}
