package com.sibo.email.controller;

import com.sibo.email.util.IPUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 父类controller
 * @author: panwz
 * @create: 2018-11-22 16:52
 **/

public class BaseController {
    public String getIp(HttpServletRequest request) {
        return IPUtils.getIpAdrress(request);
    }
}
