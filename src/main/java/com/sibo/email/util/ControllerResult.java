package com.sibo.email.util;



import com.sibo.email.constant.Constant;
import com.sibo.email.constant.SystemCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据返回封装类
 *
 * @author panwz
 * @ClassName: ControllerResult
 * @date 2018年8月7日  下午3:05:58
 */
public class ControllerResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;


    public static ControllerResult success(Object data) {
        ControllerResult resultMap = new ControllerResult();

        resultMap.put(Constant.DATA, data);
        resultMap.put(Constant.SUCCESS, true);
        resultMap.put(Constant.RESULT_CODE, SystemCode.success.getCode());
        return resultMap;
    }

    public static <T> ControllerResult ok(List<T> list) {
        ControllerResult result = new ControllerResult();

        result.put(Constant.RESULT_CODE, SystemCode.success.getCode());
        result.put(Constant.SUCCESS, true);
        result.put(Constant.DATA, list);
        return result;
    }

    /**
     * 是否回调
     * @param callback
     * @return
     */
    public static ControllerResult success(boolean callback) {
        ControllerResult result = new ControllerResult();

        result.put(Constant.RESULT_CODE, SystemCode.success.getCode());
        result.put(Constant.SUCCESS, true);
        result.put(Constant.CALLBACK, callback);

        return result;
    }
    /**
     * 是否回调
     * @param callback
     * @return
     */
    public static ControllerResult success(boolean callback,Object data) {
        ControllerResult result = new ControllerResult();

        result.put(Constant.RESULT_CODE, SystemCode.success.getCode());
        result.put(Constant.SUCCESS, true);
        result.put(Constant.CALLBACK, callback);
        result.put(Constant.DATA, data);

        return result;
    }

    public static ControllerResult success() {
        ControllerResult result = new ControllerResult();

        result.put(Constant.RESULT_CODE, SystemCode.success.getCode());
        result.put(Constant.SUCCESS, true);

        return result;
    }

    public static ControllerResult success(String message) {
        ControllerResult result = new ControllerResult();

        result.put(Constant.RESULT_CODE, SystemCode.success.getCode());
        result.put(Constant.SUCCESS, true);
        result.put(Constant.MESSAGE, message);
        return result;
    }


    public ControllerResult() {
        put(Constant.RESULT_CODE, SystemCode.success.getCode());
        put(Constant.SUCCESS, true);
        put(Constant.MESSAGE, "操作成功");
    }

    public static ControllerResult error() {
        return error(SystemCode.server_error, "操作失败");
    }

    public static ControllerResult error(String msg) {
        return error(SystemCode.server_error, msg);
    }

    public static ControllerResult error(SystemCode code, String msg) {
        ControllerResult r = new ControllerResult();
        r.put(Constant.RESULT_CODE, code.getCode());
        r.put(Constant.SUCCESS, false);
        r.put(Constant.MESSAGE, msg);
        return r;
    }

    public static ControllerResult ok(String msg) {
        ControllerResult r = new ControllerResult();
        r.put(Constant.MESSAGE, msg);
        return r;
    }

    public static ControllerResult ok(Map<String, Object> map) {
        ControllerResult r = new ControllerResult();
        r.putAll(map);
        return r;
    }

    public static ControllerResult ok() {
        return new ControllerResult();
    }

    @Override
    public ControllerResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
