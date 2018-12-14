package com.sibo.email.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @description: 邮箱配置
 * @author: panwz
 * @create: 2018-11-21 14:43
 **/
@Configuration
public class EmailConfig {
    public static final String system_title = "深圳市思博智创科技有限公司系统";
    public static final String service_title = "深圳市思博智创科技有限公司服务系统";
    public static final String person_title = "个人邮件";
    public static final String default_from = "深圳市思博智创科技有限公司";

    public static String system_host;
    public static String system_username;
    public static String system_password;
    public static int system_port;
    public static String system_protocol;

    public static String service_host;
    public static String service_username;
    public static String service_password;
    public static int service_port;
    public static String service_protocol;

    public static String person_host;
    public static String person_username;
    public static String person_password;
    public static int person_port;
    public static String person_protocol;

    /*@Value("${sibomail.system.host}")
    public void setSystem_host(String system_host) {
        this.system_host = system_host;
    }

    @Value("${sibomail.system.username}")
    public void setSystem_username(String system_username) {
        this.system_username = system_username;
    }

    @Value("${sibomail.system.password}")
    public void setSystem_password(String system_password) {
        this.system_password = system_password;
    }

    @Value("${sibomail.system.port}")
    public void setSystem_port(int system_port) {
        this.system_port = system_port;
    }

    @Value("${sibomail.system.protocol}")
    public static void setSystem_protocol(String system_protocol) {
        EmailConfig.system_protocol = system_protocol;
    }

    @Value("${sibomail.service.host}")
    public void setService_host(String service_host) {
        this.service_host = service_host;
    }

    @Value("${sibomail.service.username}")
    public  void setService_username(String service_username) {
        this.service_username = service_username;
    }

    @Value("${sibomail.service.password}")
    public void setService_password(String service_password) {
        this.service_password = service_password;
    }

    @Value("${sibomail.service.port}")
    public void setService_port(int service_port) {
        this.service_port = service_port;
    }

    @Value("${sibomail.service.protocol}")
    public void setService_protocol(String service_protocol) {
        this.service_protocol = service_protocol;
    }

    @Value("${sibomail.person.host}")
    public void setPerson_host(String person_host) {
        this.person_host = person_host;
    }

    @Value("${sibomail.person.username}")
    public void setPerson_username(String person_username) {
        this.person_username = person_username;
    }

    @Value("${sibomail.person.password}")
    public void setPerson_password(String person_password) {
        this.person_password = person_password;
    }

    @Value("${sibomail.person.port}")
    public void setPerson_port(int person_port) {
        this.person_port = person_port;
    }

    @Value("${sibomail.person.protocol}")
    public void setPerson_protocol(String person_protocol) {
        this.person_protocol = person_protocol;
    }*/
}
