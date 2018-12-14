package com.sibo.email.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 邮件实体
 * @author: panwz
 * @create: 2018-11-22 15:03
 **/
@TableName("t_email")
@Data
public class EmailEntity implements Serializable {
    @TableId
    private long id;
    /**
     * 服务器地址
     */
    private String host;
    /**
     * 邮箱用户名
     */
    private String userName;
    /**
     * 邮箱密码
     */
    private String password;
    /**
     * 发送端口
     */
    private int port;
    /**
     * 协议
     */
    private String protocol;
    /***
     * 邮件类型
     * */
    private String emailType;

    public static final int default_port = 25;
    public static final String default_protocol = "smtp";
}
