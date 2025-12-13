package org.example;

public class Department {
    private String departmentId;      // D01, D02, ...
    private String departmentName;
    public static int nextId = 1;




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
