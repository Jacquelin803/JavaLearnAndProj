package com.imooc.reader.service.exception;

/**
 * BussinessException业务逻辑异常
 */
public class BussinessException extends RuntimeException {

    private String code;
    private String msg;

    public BussinessException(String code, String msg) {
        super(msg);  // 先实现父类构造器,不希望前台页面看到code，故而只传msg不传code
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
