package creation.abstractFactory.matter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class IIR {

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String get(String key) {
        System.out.println("IIR获取数据 key:" + key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        System.out.println("IIR写入数据 key: " + key + "value: " + value);
        dataMap.put(key, value);
    }

    public void setExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        System.out.println("IIR写入数据 key:" + key + "value: " + value + "timeout: " + timeout + "timeUnit: " + timeUnit.toString());
        dataMap.put(key, value);
    }

    public void del(String key) {
        System.out.println("IIR删除数据 key: " + key);
        dataMap.remove(key);
    }
}
