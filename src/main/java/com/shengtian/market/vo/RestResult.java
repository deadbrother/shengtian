package com.shengtian.market.vo;

public class RestResult {
    private String msg;
    private Integer code;
    private Object data;

    public RestResult() {
    }

    public RestResult(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public void success(){
        this.code = StatusCode.SUCCESS;
    }

    public void unknownError(String msg){
        this.code = StatusCode.FAILURE;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
