package com.sibo.email.constant;

public class Constant {
    // 演示系统账户
    public static String DEMO_ACCOUNT = "test";
    // 自动去除表前缀
    public static String AUTO_REOMVE_PRE = "true";
    // 停止计划任务
    public static String STATUS_RUNNING_STOP = "stop";
    // 开启计划任务
    public static String STATUS_RUNNING_START = "start";
    // 通知公告阅读状态-未读
    public static String OA_NOTIFY_READ_NO = "0";
    // 通知公告阅读状态-已读
    public static int OA_NOTIFY_READ_YES = 1;
    // 部门根节点id
    public static Long DEPT_ROOT_ID = 0l;
    // 缓存方式
    public static String CACHE_TYPE_REDIS = "redis";

    public static String LOG_ERROR = "error";

    public final static String ROWS = "rows";
    public final static String TOTAL = "total";
    public final static String SUCCESS = "success";
    public final static String ERROR_MESSAGE = "errorMessage";
    public final static String MESSAGE = "msg";
    public final static String DATA = "data";
    public static final String PAGE_COUNT = "pageCount";
    public static final String RESULT_CODE = "code";
    public static final String SIGN = "sign";

    public static final String CALLBACK = "callback";

    /***AES类型-加密*/
    public static final String aseType_encrypt = "1";
    /***AES类型-解密*/
    public static final String aseType_decrypt = "2";

    /***开发环境*/
    public static final String environment_dev = "dev";
    /***生产环境*/
    public static final String environment_pro = "pro";

    public static final String aliPay = "aliPay";
    public static final String wxPay = "wxPay";

}
