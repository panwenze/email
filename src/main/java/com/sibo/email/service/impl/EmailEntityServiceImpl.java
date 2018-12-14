package com.sibo.email.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sibo.email.constant.SystemCode;
import com.sibo.email.domain.EmailEntity;
import com.sibo.email.mapper.email.EmailMapper;
import com.sibo.email.service.EmailEntityService;
import com.sibo.email.util.Base64Utils;
import com.sibo.email.util.ControllerResult;
import com.sibo.email.util.EmailUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @description:
 * @author: panwz
 * @create: 2018-11-22 15:29
 **/
@Service
public class EmailEntityServiceImpl extends ServiceImpl<EmailMapper, EmailEntity> implements EmailEntityService {
    /**
     * 添加邮件
     *
     * @param emailEntity
     * @return
     */
    @Override
    public Object addEmail(EmailEntity emailEntity) {
        if (null == emailEntity) {
            return ControllerResult.error(SystemCode.para_error, "参数为空");
        }

        if (StringUtils.isEmpty(emailEntity.getHost())) {
            return ControllerResult.error(SystemCode.para_error, "服务器地址为空");
        }

        if (StringUtils.isEmpty(emailEntity.getUserName())) {
            return ControllerResult.error(SystemCode.para_error, "邮箱名为空");
        }

        if (!EmailUtil.isEmail(emailEntity.getUserName())) {
            return ControllerResult.error(SystemCode.para_error, "邮箱格式错误");
        }

        if (StringUtils.isEmpty(emailEntity.getEmailType())) {
            return ControllerResult.error(SystemCode.para_error, "邮箱类型为空");
        }

        EntityWrapper ew = new EntityWrapper();
        ew.where("user_name={0}", emailEntity.getUserName()).or("email_type={0}", emailEntity.getEmailType());
        if (this.selectCount(ew) > 0) {
            return ControllerResult.error(SystemCode.para_error, "该邮箱或该类型的邮箱已存在");
        }

        if (StringUtils.isEmpty(emailEntity.getPassword())) {
            return ControllerResult.error(SystemCode.para_error, "邮箱密码为空");
        }
        if (StringUtils.isEmpty(emailEntity.getPort()) || emailEntity.getPort() == 0) {
            emailEntity.setPort(EmailEntity.default_port);
        }
        if (StringUtils.isEmpty(emailEntity.getProtocol())) {
            emailEntity.setProtocol(EmailEntity.default_protocol);
        }
        emailEntity.setPassword(Base64Utils.encryptBASE64(emailEntity.getPassword()));
        if (this.insert(emailEntity)) {
            return ControllerResult.success("添加成功");
        }
        return ControllerResult.error("添加失败");
    }

    /**
     * 删除邮件
     *
     * @param userName
     * @return
     */
    @Override
    public Object removeEmail(String userName) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(userName.trim())) {
            return ControllerResult.error(SystemCode.para_error, "邮件名为空");
        }
        EntityWrapper ew = new EntityWrapper();
        ew.eq("user_name", userName);
        if (this.delete(ew)) {
            return ControllerResult.success("删除成功");
        }
        return ControllerResult.error(SystemCode.notFound, "邮箱不存在");
    }
}
