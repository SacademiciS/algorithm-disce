package behavioral.memo;

import behavioral.memo.design.Admin;
import behavioral.memo.design.ConfigFile;
import behavioral.memo.design.ConfigOriginator;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

//备忘录模式
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() {
        Admin admin = new Admin();
        ConfigOriginator configOriginator = new ConfigOriginator();
        configOriginator.setConfigFile(new ConfigFile("1000001", "配置内容A=哈哈", new Date(), "小傅哥"));
        admin.append(configOriginator.saveMemento()); // 保存配置
        configOriginator.setConfigFile(new ConfigFile("1000002", "配置内容A=嘻嘻", new Date(), "小傅哥"));
        admin.append(configOriginator.saveMemento());
        configOriginator.setConfigFile(new ConfigFile("1000003", "配置内容A=么么", new Date(), "小傅哥"));
        admin.append(configOriginator.saveMemento());
        configOriginator.setConfigFile(new ConfigFile("1000004", "配置内容A=嘿嘿", new Date(), "小傅哥"));
        admin.append(configOriginator.saveMemento());

        // 历史配置(回滚)
        configOriginator.getMemento(admin.undo());
        logger.info("历史配置(回滚)undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));

        // 历史配置(回滚)
        configOriginator.getMemento(admin.undo());
        logger.info("历史配置(回滚)undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));

        // 历史配置(前进)
        configOriginator.getMemento(admin.redo());
        logger.info("历史配置(前进)redo：{}", JSON.toJSONString(configOriginator.getConfigFile()));

        //历史配置（获取）
        configOriginator.getMemento(admin.get("1000002"));
        logger.info("历史配置(获取)get：{}", JSON.toJSONString(configOriginator.getConfigFile()));
    }
    //总结：
    //此种设计模式的方式可以满足在不破坏原有属性类的基础上，扩充了备忘录的功能。虽然和我们平时使用的思路是一样的，但在具体实现上还可以细细品味，这样的方式在一些源码中也有所体现。
    //在以上的实现中我们是将配置模拟存放到内存中，如果关机了会导致配置信息丢失，因为在一些真实的场景里还是需要存放到数据库中。那么此种存放到内存中进行回复的场景也不是没有，比如；Photoshop、运营人员操作ERP配置活动，那么也就是即时性的一般不需要存放到库中进行恢复。另外如果是使用内存方式存放备忘录，需要考虑存储问题，避免造成内存大量消耗。
    //设计模式的学习都是为了更好的写出可扩展、可管理、易维护的代码，而这个学习的过程需要自己不断的尝试实际操作，理论的知识与实际结合还有很长一段距离。切记多多上手！
}
