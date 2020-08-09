package mjhct.springcloud.commons.utils;

import java.util.Random;

public class RandomUtil {

    private static final Random RANDOM = new Random();

    private static final Integer defaultRange = 1000;

    public static Random getRandom(){
        return RANDOM;
    }

    /**
     * 获取指定范围内的一个随机整数，不传范围则默认1000内
     * @param bound
     * @return
     */
    public static Integer getRandomInteger(Integer bound){
        if (bound == null || bound == 0){
            return RANDOM.nextInt(defaultRange);
        }
        return RANDOM.nextInt(bound);
    }

}
