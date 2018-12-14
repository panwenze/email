package com.sibo.email.constant;

public enum EmailType {
    SERVICE("service"),//业务
    SYSTEM("system"),//系统
    PERSON("person");//个人

    private String emailType;

    EmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getEmailType() {
        return this.emailType;
    }

    public class EmailTypeConstant {
        public static final String SERVICE = "service";
        public static final String SYSTEM = "system";
        public static final String PERSON = "person";
    }
}
