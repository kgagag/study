package com.gray.common;

/**
 * 公共异常定义为三位数的ErrorStatus，各模块的异常定义从四位开始，并需要在此处注册
 * 
 * =============模块ErrorStatus注册==============
 * 1000：用户模块；2000：商品模块；3000：订单模块；4000：规则模块；5000：推荐模块；6000：支付模块； 7000：活动模块；
 * =============模块ErrorStatus注册==============
 * 
 */
public abstract class ErrorStatus {
    /**
     * 错误码
     */
    private final int code;

    /**
     * 错误信息
     */
    private final String reasonPhrase;

    protected ErrorStatus(int code, String reasonPhrase) {
        this.code = code;
        this.reasonPhrase = reasonPhrase;
    }

    /**
     * 返回错误码。
     * 
     * @return
     */
    public int getCode() {
        return this.code;
    }

    /**
     * 返回错误信息。
     * 
     * @return
     */
    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    /**
     * 模块编码。
     * 
     * @return
     */
    public abstract int getModuleCode();

    /**
     * 在当前消息后追加消息内容。
     * 
     * @param postfix
     * @return
     */
    public ErrorStatus addMsg(String postfix) {
        return defineCode(this.code, this.reasonPhrase + postfix);
    }

    /**
     * 定义指定编码和内容的消息对象。
     * 
     * @param code
     * @param message
     * @return
     */
    public static ErrorStatus defineCode(int code, String message) {
        return new BaseErrorStatus(code, message);
    }

    @Override
    public String toString() {
        return "code:" + this.code + ",reasonPhrase:" + reasonPhrase;
    }
}
