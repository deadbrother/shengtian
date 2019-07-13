package com.shengtian.market.vo;

public class RestResult {
    private String msg;
    private Integer status;
    private Object data;

    public RestResult() {
    }

    public RestResult(String msg, Integer status) {
        this.msg = msg;
        this.status = status;
    }

    public void success(){
        this.status = StatusCode.SUCCESS;
    }

    public void unknownError(String msg){
        this.status = StatusCode.FAILURE;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
