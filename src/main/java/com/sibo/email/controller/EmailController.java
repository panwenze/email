package com.sibo.email.controller;

import com.sibo.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: panwz
 * @create: 2018-11-21 11:24
 **/
@RestController
@CrossOrigin
@RequestMapping("/siboEmail")
public class EmailController extends BaseController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public Object sendEmail(String to, String body,
                            String title,
                            @RequestParam(required = false) String emailType,
                            @RequestParam(required = false) String username,
                            HttpServletRequest request) {
        return emailService.sendEmail(to, body, title, emailType, username, getIp(request));
    }

    @PostMapping("/sendServiceEmail")
    public Object senServiceEmail(String to,
                                  String body,
                                  String title,
                                  HttpServletRequest request) {
        return emailService.sendServiceEmail(to, body, title, getIp(request));
    }

    @PostMapping("/sendSystemEmail")
    public Object senSystemEmail(String to,
                                 String body,
                                 String title,
                                 HttpServletRequest request) {
        return emailService.sendSystemEmail(to, body, title, getIp(request));
    }

}
