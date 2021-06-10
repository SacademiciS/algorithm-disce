package behavioral.visitor;

import behavioral.visitor.design.DataView;
import behavioral.visitor.design.visitor.impl.Parent;
import behavioral.visitor.design.visitor.impl.Principal;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//访问者模式
public class ApiTest {

    //访问者模式的类结构相对其他设计模式来说比较复杂，但这样的设计模式在我看来更加烧气有魅力，它能阔开你对代码结构的新认知，用这样思维不断的建设出更好的代码架构。
    //
    //关于这个案例的核心逻辑实现，有以下几点；
    //
    //建立用户抽象类和抽象访问方法，再由不同的用户实现；老师和学生。
    //建立访问者接口，用于不同人员的访问操作；校长和家长。
    //最终是对数据的看板建设，用于实现不同视角的访问结果输出。

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test(){
        DataView dataView = new DataView();

        logger.info("\r\n家长视角访问：");
        dataView.show(new Parent());        //家长

        logger.info("\r\n校长视角访问：");
        dataView.show(new Principal());     //校长

    }
    //总结：
    //从以上的业务场景中可以看到，在嵌入访问者模式后，可以让整个工程结构变得容易添加和修改。也就做到了系统服务之间的解耦，不至于为了不同类型信息的访问而增加很多多余的if判断或者类的强制转换。也就是通过这样的设计模式而让代码结构更加清晰。
    //另外在实现的过程可能你可能也发现了，定义抽象类的时候还需要等待访问者接口的定义，这样的设计首先从实现上会让代码的组织变得有些难度。另外从设计模式原则的角度来看，违背了迪米特原则，也就是最少知道原则。因此在使用上一定要符合场景的运用，以及提取这部分设计思想的精髓。
    //好的学习方式才好更容易接受知识，学习编程的更需要的不单单是看，而是操作。二十多种设计模式每一种都有自己的设计技巧，也可以说是巧妙之处，这些巧妙的地方往往是解决复杂难题的最佳视角。亲力亲为，才能为所欲为，为了自己的欲望而努力！

}
