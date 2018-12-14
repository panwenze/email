package com.sibo.email.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sibo.email.constant.EmailStatus;
import com.sibo.email.constant.EmailType;
import com.sibo.email.constant.SystemCode;
import com.sibo.email.domain.EmailEntity;
import com.sibo.email.domain.EmailRecord;
import com.sibo.email.service.EmailEntityService;
import com.sibo.email.service.EmailRecordService;
import com.sibo.email.service.EmailService;
import com.sibo.email.util.Base64Utils;
import com.sibo.email.util.ControllerResult;
import com.sibo.email.util.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @description:
 * @author: panwz
 * @create: 2018-11-21 11:26
 **/
@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    /**
     * 默认使用system帐号
     */
    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;

    @Autowired
    private EmailRecordService emailRecordService;

    @Autowired
    private EmailEntityService emailEntityService;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * 发送邮件
     *
     * @param to
     * @param body
     * @param title
     * @param emailType
     * @return
     */
    @Override
    public Object sendEmail(String to, String body, String title, String emailType, String username, String sendHost) {
        if (StringUtils.isEmpty(to)) {
            return ControllerResult.error(SystemCode.para_error, "接收邮件为空");
        }
        if (!EmailUtil.isEmail(to)) {
            return ControllerResult.error(SystemCode.para_error, "邮箱格式不正确");
        }
        if (StringUtils.isEmpty(body)) {
            return ControllerResult.error(SystemCode.para_error, "发送内容为空");
        }

        if (StringUtils.isEmpty(title)) {
            return ControllerResult.error(SystemCode.para_error, "邮件标题为空");
        }
        EmailEntity email = null;
        EntityWrapper ew = new EntityWrapper();

        //使用默认
        if (StringUtils.isEmpty(emailType) && StringUtils.isEmpty(username)) {
            ew.eq("email_type", EmailType.SYSTEM.getEmailType());
            email = emailEntityService.selectOne(ew);
        }

        if (!StringUtils.isEmpty(emailType) && StringUtils.isEmpty(username)) {
            ew.eq("email_type", emailType);
            email = emailEntityService.selectOne(ew);
        }

        if (StringUtils.isEmpty(emailType) && !StringUtils.isEmpty(username)) {
            ew.eq("user_name", username);
            email = emailEntityService.selectOne(ew);
        }

        if (null == email) {
            return ControllerResult.error(SystemCode.notFound, "未找到该类型的邮件发送服务");
        }

        setMailSender(email);
        send(to, body, title, sendHost);
        return ControllerResult.success("发送成功");
    }

    /**
     * 发送服务邮件
     *
     * @param to
     * @param body
     * @param title
     * @return
     */
    public Object sendServiceEmail(String to, String body, String title, String sendHost) {
        if (StringUtils.isEmpty(to)) {
            return ControllerResult.error(SystemCode.para_error, "接收邮件为空");
        }
        if (!EmailUtil.isEmail(to)) {
            return ControllerResult.error(SystemCode.para_error, "邮箱格式不正确");
        }
        if (StringUtils.isEmpty(body)) {
            return ControllerResult.error(SystemCode.para_error, "发送内容为空");
        }
        if (StringUtils.isEmpty(title)) {
            return ControllerResult.error(SystemCode.para_error, "邮件标题为空");
        }

        EmailEntity email = null;
        EntityWrapper ew = new EntityWrapper();
        ew.eq("email_type", EmailType.SERVICE.getEmailType());
        email = emailEntityService.selectOne(ew);

        if (null == email) {
            return ControllerResult.error(SystemCode.notFound, "未找到该类型的邮件发送服务");
        }
        setMailSender(email);
        send(to, body, title, sendHost);
        return ControllerResult.success("发送成功");
    }

    /**
     * 发送系统邮件
     *
     * @param to
     * @param body
     * @param title
     * @return
     */
    @Override
    public Object sendSystemEmail(String to, String body, String title, String sendHost) {
        if (StringUtils.isEmpty(to)) {
            return ControllerResult.error(SystemCode.para_error, "接收邮件为空");
        }
        if (!EmailUtil.isEmail(to)) {
            return ControllerResult.error(SystemCode.para_error, "邮箱格式不正确");
        }
        if (StringUtils.isEmpty(body)) {
            return ControllerResult.error(SystemCode.para_error, "发送内容为空");
        }
        if (StringUtils.isEmpty(title)) {
            return ControllerResult.error(SystemCode.para_error, "邮件标题为空");
        }

        EmailEntity email = null;
        EntityWrapper ew = new EntityWrapper();
        ew.eq("email_type", EmailType.SYSTEM.getEmailType());
        email = emailEntityService.selectOne(ew);

        if (null == email) {
            return ControllerResult.error(SystemCode.notFound, "未找到该类型的邮件发送服务");
        }
        setMailSender(email);
        send(to, body, title, sendHost);
        return ControllerResult.success("发送成功");
    }

    private void setMailSender(EmailEntity email) {
        this.javaMailSenderImpl.setHost(email.getHost());
        this.javaMailSenderImpl.setUsername(email.getUserName());
        this.javaMailSenderImpl.setPassword(Base64Utils.decryptBASE64(email.getPassword()));
        this.javaMailSenderImpl.setPort(email.getPort());
        this.javaMailSenderImpl.setProtocol(email.getProtocol());
    }

    public void send(String to, String body, String title, String sendHost) {
        EmailRecord record = new EmailRecord();
        record.setSendTime(new Date());
        record.setSendTo(to);
        record.setSendForm(javaMailSenderImpl.getUsername());
        record.setSendBody(body);
        record.setSendHost(sendHost);
        //这里开启线程发送
        threadPoolTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    //建立邮件消息
                    SimpleMailMessage mainMessage = new SimpleMailMessage();
                    //发送者
                    mainMessage.setFrom(javaMailSenderImpl.getUsername());
                    //接收者
                    mainMessage.setTo(to);
                    //发送的标题
                    mainMessage.setSubject(title);
                    //发送的内容
                    mainMessage.setText(body);
                    javaMailSenderImpl.send(mainMessage);
                    record.setSendStatus(EmailStatus.SUCCESS.getEmailStatus());
                    emailRecordService.insert(record);
                } catch (Exception e) {
                    record.setSendStatus(EmailStatus.FAIL.getEmailStatus());
                    emailRecordService.insert(record);
                    log.error("【发送邮件异常】{}", e);
                }
            }
        });

    }
}