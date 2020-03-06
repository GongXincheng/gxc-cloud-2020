package gxc.cloud.service.payment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 封装返回值
 *
 * @author GongXincheng
 * @date 2019/4/22 13:49
 */
@Getter
@Setter
public class ServerResponse<T> implements Serializable {

    private int code;

    /**
     * 用于描述业务接口执行情况的文案
     * 可用于展示给终端用户
     */
    @JsonProperty(defaultValue = "")
    private String message;
    /**
     * 异常信息 用于开发人员
     */
    @JsonProperty(defaultValue = "")
    private String errMsg;

    private T data;

    private ServerResponse() {
    }

    private ServerResponse(int code) {
        this.code = code;
    }

    private ServerResponse(ResponseCode code) {
        this.code = code.getCode();
        this.message = code.getDesc();
    }

    private ServerResponse(ResponseCode code, String errMsg) {
        this.code = code.getCode();
        this.message = code.getDesc();
        this.errMsg = errMsg;
    }

    private ServerResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    private ServerResponse(int code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    private ServerResponse(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    /**
     * 使之不在json序列化结果当中
     */
    @JsonIgnore
    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }


    public static <T> ServerResponse<T> ok() {
        return new ServerResponse<>(ResponseCode.SUCCESS);
    }

    public static <T> ServerResponse<T> ok(T data) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse<T> ok(String msg, T data) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg, data);
    }


    public static <T> ServerResponse<T> fail() {
        return new ServerResponse<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> fail(ResponseCode code) {
        return new ServerResponse<>(code);
    }

    public static <T> ServerResponse<T> fail(ResponseCode code, String errMsg) {
        return new ServerResponse<>(code);
    }


    public static <T> ServerResponse<T> fail(String message) {
        return new ServerResponse<>(ResponseCode.ERROR.getCode(), message);
    }

    public static <T> ServerResponse<T> fail(int errorCode, String message) {
        return new ServerResponse<>(errorCode, message);
    }

    public static <T> ServerResponse<T> build(int code, T data, String message) {
        return new ServerResponse<>(code, message, data);
    }

    public boolean getResult() {
        return isSuccess();
    }
}