package com.sibo.email.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 邮件发送记录
 * @author: panwz
 * @create: 2018-11-22 15:10
 **/
@TableName("t_email_record")
@Data
public class EmailRecord implements Serializable {

    @TableId
    private long id;
    /**
     * 接收邮箱
     */
    private String sendTo;
    /**
     * 发送邮箱
     */
    private String sendForm;
    /**
     * 发送时间
     */
    private Date sendTime;
    /**
     * 发送内容
     */
    private String sendBody;
    /**
     * 发送主机
     */
    private String sendHost;
    /**
     * 发送状态
     */
    private String sendStatus;
}
