package mjhct.springcloud.commons.entities;

public class CommonResult<T> {

    private String code;
    private String message;
    private T data;

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
}
