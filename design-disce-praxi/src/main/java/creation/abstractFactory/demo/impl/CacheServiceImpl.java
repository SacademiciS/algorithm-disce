package creation.abstractFactory.demo.impl;

import creation.abstractFactory.RedisUtils;
import creation.abstractFactory.matter.EGM;
import creation.abstractFactory.matter.IIR;
import creation.abstractFactory.demo.CacheService;

import java.util.concurrent.TimeUnit;

//这里的实现过程非常简单，主要根据类型判断是哪个Redis集群。
//虽然实现是简单了，但是对使用者来说就麻烦了，并且也很难应对后期的拓展和不停的维护。
public class CacheServiceImpl implements CacheService {

    private RedisUtils redisUtils = new RedisUtils();

    private EGM egm = new EGM();

    private IIR iir = new IIR();

    @Override
    public String get(String key, int redisType) {
        if (1 == redisType) {
            return egm.gain(key);
        }

        if (2 == redisType) {
            return iir.get(key);
        }

        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value, int redisType) {
        if (1 == redisType) {
            egm.set(key, value);
            return;
        }

        if (2 == redisType) {
            iir.set(key, value);
            return;
        }
        redisUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType) {
        if (1 == redisType) {
            egm.setEx(key, value, timeout, timeUnit);
            return;
        }

        if (2 == redisType) {
            iir.setExpire(key, value, timeout, timeUnit);
            return;
        }
        redisUtils.set(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key, int redisType) {
        if (1 == redisType) {
            egm.delete(key);
            return;
        }

        if (2 == redisType) {
            iir.del(key);
            return;
        }
        redisUtils.del(key);
    }
}
