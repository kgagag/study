package com.gray.common;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.util.Assert;

/**
 * 定义RESTful服务数据返回格式。
 * 
 * @author wangshqb
 * 
 */
public class ServiceResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final String SUCCESS = "000000";

    /**
     * 失败
     */
    public static final String ERROR = "100000";

    /*
     * 字段名定义
     */
    public static final String CODE = "code";

    public static final String MESSAGE = "message";

    public static final String DATA = "data";

    /**
     * 返回状态编码
     */
    @JsonProperty(value = CODE)
    private String retcode;

    /**
     * 返回消息
     */
    @JsonProperty(value = MESSAGE)
    private String retmsg;

    /**
     * 返回请求的数据
     */
    @JsonProperty(value = DATA)
    private T data;

    ServiceResponse() {

    }

    /**
     * 构造指定编码和消息的返回对象。
     * 
     * @param code
     * @param message
     * @param data
     */
    protected ServiceResponse(String code, String message, T data) {
        Assert.hasText(code, "错误码不能为空");
        this.retcode = code;
        this.retmsg = message;
        this.data = data;
    }

    public String getRetcode() {
        return this.retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return this.retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 创建请求成功时返回结果对象。
     * 
     * @return
     */
    public static <T> ServiceResponse<T> success(T data) {
        return new ServiceResponse<T>(SUCCESS, "OK", data);
    }

    /**
     * 处理指定异常的返回结果。
     * 
     * @param e
     * @return
     */
    public static <T> ServiceResponse<T> error(Throwable e) {
        // 处理业务异常
        if (e instanceof BusinessException) {
            return error(((BusinessException) e).getError());
        }
        return error(ERROR, e.toString());
    }

    /**
     * 处理指定异常的返回结果。
     * 
     * @param errorStatus
     * @return
     */
    public static <T> ServiceResponse<T> error(ErrorStatus errorStatus) {
        // 处理业务异常
        if (errorStatus != null) {
            String code = String.valueOf(errorStatus.getCode());
            String message = errorStatus.getReasonPhrase();
            return new ServiceResponse<T>(code, message, null);
        }
        return error(ERROR, "");
    }

    /**
     * 处理指定错误码和消息的返回结果。
     * 
     * @param code
     * @param message
     * @return
     */
    public static <T> ServiceResponse<T> error(String code, String message) {
        return new ServiceResponse<T>(code, message, null);
    }
}
