package com.sibo.email.service;

import com.baomidou.mybatisplus.service.IService;
import com.sibo.email.domain.EmailEntity;

public interface EmailEntityService extends IService<EmailEntity> {
    /**
     * 添加邮件
     *
     * @param emailEntity
     * @return
     */
    Object addEmail(EmailEntity emailEntity);

    /**
     * 删除邮件
     *
     * @param userName
     * @return
     */
    Object removeEmail(String userName);
}
