package com.ps.user.exception;



import lombok.Getter;
import lombok.ToString;

/**
   * @Description: Return code enumeration
 * @Author yemiaoxin
 * @Date 2018/5/22
 */
@Getter
@ToString
public enum ResponseCode {

    /**
           * Success and failure
     */
    SUCCESS(200, "success"),
    FAIL(-1, "failure"),

    /**
           * Common parameters
     */
    PARAM_ERROR(1001, "Parameter error"),
    PARAM_NOT_NULL(1002, "Parameter cannot be empty"),
    SIGN_ERROR(1003,"Signature error"),
    REQUEST_METHOD_ERROR(1004, "The request method is wrong"),
    MEDIA_TYPE_NOT_SUPPORT_ERROR(1005, "Parameter (file) format is not supported"),
    PARAM_BIND_ERROR(1006, "Parameter format error, data binding failed"),
    NOT_FOUND_ERROR(1007, "The requested resource (interface) does not exist"),
    MISS_REQUEST_PART_ERROR(1008, "Missing request body (file not uploaded)"),
    MISS_REQUEST_PARAM_ERROR(1009, "Missing request parameter"),

    /**
           * User module
     */
    ACCOUNT_ERROR(2001, "Account error"),
    PASSWORD_ERROR(2002,"wrong password"),
    ACCOUNT_NOT_EXIST(2003,"Account does not exist"),

    /**
           * Other
     */
    UNKNOWN_ERROR(-1000,"Unknown exception");

    /**
           * Return code
     */
    private int code;

    /**
           * returned messages 
     */
    private String msg;

    private ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

