package mjhct.springcloud.commons.entities;

import java.io.Serializable;

public class CommonResult<T> implements Serializable {

    private String code;
    private String message;
    private T data;

    public CommonResult() {
    }

    public CommonResult(String code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public CommonResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(CommonCode commonCode) {
        this.code = commonCode.code;
        this.message = commonCode.message;
        this.data = null;
    }

    public CommonResult(CommonCode commonCode, T data) {
        this.code = commonCode.code;
        this.message = commonCode.message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
