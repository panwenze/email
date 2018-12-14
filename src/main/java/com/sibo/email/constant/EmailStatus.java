package com.sibo.email.constant;

public enum EmailStatus {
    SUCCESS("SUCCESS"),
    FAIL("FAIL"),
    TIMEOUT("TIMEOUT");

    private String emailStatus;

    EmailStatus(String emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getEmailStatus() {
        return this.emailStatus;
    }
}
