package com.sibo.email.constant;

/**
 * 系统代码
 *
 * @author panwz
 * @ClassName: SystemCode
 * @date 2018年8月6日 下午4:40:42
 */
public enum SystemCode {

    server_error(500),
    para_error(403), //参数
    notFound(404),
    success(200),
    unauthorized(401),//未授权
    unlogin(400);

    private int code;

    SystemCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
