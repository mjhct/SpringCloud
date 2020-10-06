package mjhct.springcloud.sentinel.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import mjhct.springcloud.commons.entity.CommonCode;
import mjhct.springcloud.commons.entity.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handle1(BlockException blockException) {
        return new CommonResult(CommonCode.FAIL, "handle1");
    }

    public static CommonResult handle2(BlockException blockException) {
        return new CommonResult(CommonCode.FAIL, "handle2");
    }

}
