package com.sibo.email.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sibo.email.domain.EmailRecord;
import com.sibo.email.mapper.emailrecord.EmailRecordMapper;
import com.sibo.email.service.EmailRecordService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: panwz
 * @create: 2018-11-22 16:11
 **/
@Service
public class EmailRecordServiceImpl extends ServiceImpl<EmailRecordMapper,EmailRecord> implements EmailRecordService {
}
