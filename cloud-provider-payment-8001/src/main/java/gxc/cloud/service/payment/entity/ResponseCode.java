package gxc.cloud.service.payment.entity;

import lombok.Getter;

/**
 * http 请求 返回状态码
 *
 * @author GongXincheng
 * @date 2019/4/22 13:49
 */
public enum ResponseCode {
    /**
     * 状态码
     */
    SUCCESS(200, "请求成功"),
    CREATED(201, "资源已创建"),
    ERROR(-1, "ERROR"),
    /**
     * 未登录
     */
    UNAUTHORIZED(401, " Unauthorized"),
    /**
     * token 过期
     */
    TOKEN_TIMEOUT(40101, "登录超时"),
    /**
     * token 权限不足
     */
    PERMISSION_DENIED(40102, "无权访问"),

    METHOD_ERROR(405, "不支持的请求方法"),
    PARAMETER_ERROR(406, "输入参数有误"),
    INTERNAL_ERROR(500, "系统异常"),
    INTERNAL_SERVICE_ERROR(501, "内服务错误"),
    ;

    @Getter
    private final int code;
    @Getter
    private final String desc;


    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
