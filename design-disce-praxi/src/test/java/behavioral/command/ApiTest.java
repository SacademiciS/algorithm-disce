package behavioral.command;

import behavioral.command.design.XiaoEr;
import behavioral.command.design.cook.impl.GuangDongCook;
import behavioral.command.design.cook.impl.JiangSuCook;
import behavioral.command.design.cook.impl.ShanDongCook;
import behavioral.command.design.cook.impl.SiChuanCook;
import behavioral.command.design.cuisine.ICuisine;
import behavioral.command.design.cuisine.impl.GuangDoneCuisine;
import behavioral.command.design.cuisine.impl.JiangSuCuisine;
import behavioral.command.design.cuisine.impl.ShanDongCuisine;
import behavioral.command.design.cuisine.impl.SiChuanCuisine;
import org.junit.Test;

//命令模式
public class ApiTest {

    //这里可以主要观察菜品与厨师的组合；new GuangDoneCuisine(new GuangDongCook());，每一个具体的命令都拥有一个对应的实现类，可以进行组合。
    //当菜品和具体的实现定义完成后，由小二进行操作点单，xiaoEr.order(guangDoneCuisine);，这里分别添加了四种菜品，给小二。
    //最后是下单，这个是具体命令实现的操作，相当于把小二手里的菜单传递给厨师。当然这里也可以提供删除和撤销，也就是客户取消了自己的某个菜品。
    @Test
    public void test() {
        // 菜系 + 厨师；广东（粤菜）、江苏（苏菜）、山东（鲁菜）、四川（川菜）
        ICuisine guangDoneCuisine = new GuangDoneCuisine(new GuangDongCook());
        ICuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ICuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
        ICuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());

        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(guangDoneCuisine);
        xiaoEr.order(jiangSuCuisine);
        xiaoEr.order(shanDongCuisine);
        xiaoEr.order(siChuanCuisine);

        xiaoEr.placeOrder();
    }
    //总结：
    //从以上的内容和例子可以感受到，命令模式的使用场景需要分为三个比较大的块；命令、实现、调用者，而这三块内容的拆分也是选择适合场景的关键因素，经过这样的拆分可以让逻辑具备单一职责的性质，便于扩展。
    //通过这样的实现方式与if语句相比，降低了耦合性也方便其他的命令和实现的扩展。但同时这样的设计模式也带来了一点问题，就是在各种命令与实现的组合下，会扩展出很多的实现类，需要进行管理。
    //设计模式的学习一定要勤加练习，哪怕最开始是模仿实现也是可以的，多次的练习后再去找到一些可以优化的场景，并逐步运用到自己的开发中。提升自己对代码的设计感觉，让代码结构更加清晰易扩展。
}
