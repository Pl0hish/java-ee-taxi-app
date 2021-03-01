package com.example.taxiAppEE.model;

public enum Role {
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String toString() {
        return this.name().replace("ROLE_", "");
    }

    public static Role getRole(String role) {
        if ("ADMIN".equals(role)) {
            return ROLE_ADMIN;
        }
        return ROLE_USER;

    }
}
