package structure.bridging;

import org.junit.Test;
import structure.bridging.design.channel.Pay;
import structure.bridging.design.channel.WxPay;
import structure.bridging.design.channel.ZfbPay;
import structure.bridging.design.mode.PayFaceMode;
import structure.bridging.design.mode.PayFingerprintMode;

import java.math.BigDecimal;

//桥接模式
public class ApiTest {

//    @Test
//    public void test_pay() {
//        PayController pay = new PayController();
//        System.out.println("\r\n模拟测试场景；微信支付、人脸方式");
//        pay.doPay("weixin_1092033111", "100000109893", new BigDecimal(100), 1, 2);
//
//        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
//        pay.doPay("jlu19dlxo111", "100000109894", new BigDecimal(100), 2, 3);
//    }

    //与上面的ifelse实现方式相比，这里的调用方式变得整洁、干净、易使用；new WxPay(new PayFaceMode())、new ZfbPay(new PayFingerprintMode())
    //外部的使用接口的用户不需要关心具体的实现，只按需选择使用即可。
    //目前以上优化主要针对桥接模式的使用进行重构if逻辑部分，关于调用部分可以使用抽象工厂或策略模式配合map结构，将服务配置化。
    // 因为这里主要展示桥接模式，所以就不在额外多加代码，避免喧宾夺主。
    @Test
    public void test_pay() {
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(100));
    }
    //总结：
    //通过模拟微信与支付宝两个支付渠道在不同的支付模式下，刷脸、指纹、密码，的组合从而体现了桥接模式的在这类场景中的合理运用。简化了代码的开发，给后续的需求迭代增加了很好的扩展性。
    //从桥接模式的实现形式来看满足了单一职责和开闭原则，让每一部分内容都很清晰易于维护和拓展，但如果我们是实现的高内聚的代码，那么就会很复杂。所以在选择重构代码的时候，需要考虑好整体的设计，否则选不到合理的设计模式，将会让代码变得难以开发。
    //任何一种设计模式的选择和使用都应该遵顼符合场景为主，不要刻意使用。而且统一场景因为业务的复杂从而可能需要使用到多种设计模式的组合，才能将代码设计的更加合理。但这种经验需要从实际的项目中学习经验，并提不断的运用
}
