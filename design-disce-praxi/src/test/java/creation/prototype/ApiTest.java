package creation.prototype;

import org.junit.Test;

//原型模式
public class ApiTest {

    @Test
    public void test_QuestionBank() throws CloneNotSupportedException {
        QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.createPaper("花花", "1000001921032"));
        System.out.println(questionBankController.createPaper("豆豆", "1000001921051"));
        System.out.println(questionBankController.createPaper("大宝", "1000001921987"));
    }
    
    //总结:
    //以上的实际场景模拟了原型模式在开发中重构的作用，但是原型模式的使用频率确实不是很高。如果有一些特殊场景需要使用到，也可以按照此设计模式进行优化。
    //另外原型设计模式的优点包括；便于通过克隆方式创建复杂对象、也可以避免重复做初始化操作、不需要与类中所属的其他类耦合等。但也有一些缺点如果对象中包括了循环引用的克隆，以及类中深度使用对象的克隆，都会使此模式变得异常麻烦。
    //终究设计模式是一整套的思想，在不同的场景合理的运用可以提升整体的架构的质量。永远不要想着去硬凑设计模式，否则将会引起过渡设计，以及在承接业务反复变化的需求时造成浪费的开发和维护成本。
    //初期是代码的优化，中期是设计模式的使用，后期是把控全局服务的搭建。不断的加强自己对全局能力的把控，也加深自己对细节的处理。可上可下才是一个程序员最佳处理方式，选取做合适的才是最好的选择。
}
