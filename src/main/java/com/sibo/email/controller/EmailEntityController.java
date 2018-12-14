package com.sibo.email.controller;

import com.sibo.email.domain.EmailEntity;
import com.sibo.email.service.EmailEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: panwz
 * @create: 2018-11-22 15:20
 **/
@RestController
@CrossOrigin
public class EmailEntityController {
    @Autowired
    private EmailEntityService emailEntityService;

    @PostMapping("/addEmail")
    public Object addEmail(EmailEntity email) {
        return emailEntityService.addEmail(email);
    }

    @PostMapping("/removeEmail")
    public Object removeEmail(EmailEntity email) {
        return null;
    }

    @PostMapping("/modifyEmail")
    public Object modifyEmail(EmailEntity email) {
        return null;
    }
}
