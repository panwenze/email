package com.sibo.email.service;

public interface EmailService {

    /**
     * 发送邮件
     *
     * @return
     */
    Object sendEmail(String to, String body, String title, String emailType, String username, String sendHost);

    /**
     * 发送服务邮件
     *
     * @return
     */
    Object sendServiceEmail(String to, String body, String title, String sendHost);

    /**
     * 发送系统邮件
     *
     * @return
     */
    Object sendSystemEmail(String to, String body, String title, String sendHost);

}
