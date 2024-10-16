package com.project.personal_budget_manager.enums;


public enum Roles {
    USER, OWNER;

    // Method to validate the role
    public static boolean isValidRole(String role) {
        // Check if the role matches any of the enum values, ignoring case
        for (Roles r : Roles.values()) {
            if (r.name().equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }
}