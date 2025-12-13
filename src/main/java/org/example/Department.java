package org.example;

public class Department {
    private String departmentId;
    private String departmentName;
    public static int nextId = 1;

    public Department(String departmentName) {
        if (!isDepartmentNameValid(departmentName)) {
            this.departmentId = null;
            this.departmentName = null;
        } else {
            this.departmentId = String.format("D%02d", nextId++);
            this.departmentName = departmentName;
        }
    }

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
}
