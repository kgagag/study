package com.gray.common;

public class ResultTool {

    /**
     * 创建成功时返回结果对象。
     * 
     * @return ServiceResponse<T>
     */
    public static <T> ServiceResponse<T> success() {
        return success(null);
    }

    /**
     * 创建成功时返回结果对象。
     * 
     * @param data
     * @return ServiceResponse<T>
     */
    public static <T> ServiceResponse<T> success(T data) {
        return ServiceResponse.success(data);
    }

    /**
     * 处理指定异常的返回结果。
     * 
     * @param e
     * @return ServiceResponse<T>
     */
    public static <T> ServiceResponse<T> error(Throwable e) {
        return ServiceResponse.error(e);
    }

    /**
     * 处理指定异常的返回结果。
     * 
     * @param e
     * @return ServiceResponse<T>
     */
    public static <T> ServiceResponse<T> error(ErrorStatus errorStatus) {
        return ServiceResponse.error(errorStatus);
    }

    /**
     * 处理指定异常的返回结果。
     * 
     * @param code
     * @param message
     * @return ServiceResponse<T>
     */
    public static <T> ServiceResponse<T> error(String code, String message) {
        return ServiceResponse.error(code, message);
    }

}
