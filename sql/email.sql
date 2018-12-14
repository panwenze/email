CREATE TABLE `t_email` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `host` varchar(45) DEFAULT NULL COMMENT '服务器地址',
  `user_name` varchar(45) DEFAULT NULL COMMENT '邮箱用户名',
  `password` varchar(45) DEFAULT NULL COMMENT '邮箱密码',
  `port` int(11) DEFAULT NULL COMMENT '端口',
  `protocol` varchar(45) DEFAULT NULL COMMENT '协议',
  `email_type` varchar(15) DEFAULT NULL COMMENT '邮件类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮箱服务';

CREATE TABLE `t_email_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `send_to` varchar(45) DEFAULT NULL COMMENT '接收邮箱',
  `send_form` varchar(45) DEFAULT NULL COMMENT '发送邮件',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `send_body` text COMMENT '发送内容',
  `send_host` varchar(45) DEFAULT NULL COMMENT '发送邮件的host',
  `send_status` varchar(15) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发送记录';