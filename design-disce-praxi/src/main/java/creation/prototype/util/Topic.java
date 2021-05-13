package creation.prototype.util;

import java.util.HashMap;
import java.util.Map;

public class Topic {

    private Map<String, String> option;  // 选项；A、B、C、D
    private String key;                  // 答案；B

    public Topic(HashMap<String, String> optionNew, String keyNew) {
        this.option = optionNew;
        this.key = keyNew;
    }

    public Map<String, String> getOption() {
        return option;
    }

    public void setOption(Map<String, String> option) {
        this.option = option;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
