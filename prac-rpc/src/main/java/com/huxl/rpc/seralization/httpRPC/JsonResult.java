package com.huxl.rpc.seralization.httpRPC;

/**
 * @author huxl
 * @createDate 2017/10/31 9:45
 */
public class JsonResult {
    //结果状态码
    private int resultCode;
    //状态码解释消息
    private String message;
    //结果
    private Object result;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
