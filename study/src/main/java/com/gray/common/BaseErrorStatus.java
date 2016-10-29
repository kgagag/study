package com.gray.common;

/**
 * 公共异常消息。
 * 
 * @author Luffy
 *
 */
public class BaseErrorStatus extends ErrorStatus {

    /**
     * 200，系统服务成功
     */
    public static final ErrorStatus SUCCESS = new BaseErrorStatus(200, "ok");

    /**
     * 500 系统错误
     */
    public static final ErrorStatus ERROR = new BaseErrorStatus(500,
            "System error");

    /**
     * 102 服务暂停
     */
    public static final ErrorStatus sys_002 = new BaseErrorStatus(102,
            "Service unavailable");

    /**
     * 103 远程服务错误
     */
    public static final ErrorStatus sys_003 = new BaseErrorStatus(103,
            "Remote service error");

    /**
     * 104 IP限制不能请求该资源
     */
    public static final ErrorStatus sys_004 = new BaseErrorStatus(104,
            "IP limit");

    /**
     * 107 数据错误，请联系管理员
     */
    public static final ErrorStatus sys_007 = new BaseErrorStatus(107,
            "数据错误，请联系管理员");

    /**
     * 108 参数错误，请参考API文档
     */
    public static final ErrorStatus sys_008 = new BaseErrorStatus(108,
            "参数错误，请参考API文档");

    /**
     * 109 接口暂无实现
     */
    public static final ErrorStatus sys_009 = new BaseErrorStatus(109,
            "接口暂无实现");

    /**
     * 110 账号异常，请重新登录
     */
    public static final ErrorStatus sys_010 = new BaseErrorStatus(110,
            "账号异常，请重新登录");

    /**
     * 111 接口不提供此种服务，请参考API文档
     */
    public static final ErrorStatus sys_011 = new BaseErrorStatus(111,
            "接口不提供此种服务，请参考API文档");

    /**
     * 112 请求超时
     */
    public static final ErrorStatus sys_012 = new BaseErrorStatus(112, "请求超时");

    /**
     * 113 排队中，请稍后再提交
     */
    public static final ErrorStatus sys_013 = new BaseErrorStatus(113,
            "排队中，请稍后再提交");

    /**
     * 114 未知错误
     */
    public static final ErrorStatus sys_014 = new BaseErrorStatus(114, "未知错误");

    /**
     * 115 验证码错误,请重试
     */
    public static final ErrorStatus sys_015 = new BaseErrorStatus(115,
            "验证码错误,请重试");

    /**
     * 116 账号过期或输入错误,请重试
     */
    public static final ErrorStatus sys_016 = new BaseErrorStatus(116,
            "账号过期或输入错误,请重试");

    /**
     * 117请升至最新版本.
     */
    public static final ErrorStatus sys_017 = new BaseErrorStatus(117,
            "请升至最新版本.");

    protected BaseErrorStatus(int code, String codeText) {
        super(code, codeText);
    }

    @Override
    public int getModuleCode() {
        return 100;
    }

}
