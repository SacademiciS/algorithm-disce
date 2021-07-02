package org.itstack.demo.design.web;

import org.itstack.demo.design.domain.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//以上的实现是模拟一个Api接口类，在里面添加白名单功能，但类似此类的接口会有很多都需要修改，所以这也是不推荐使用此种方式的重要原因。
@RestController
public class HelloWorldController {

    @Value("${server.port}")
    private int port;

    /**
     * key：需要从入参取值的属性字段，如果是对象则从对象中取值，如果是单个值则直接使用
     * returnJson：预设拦截时返回值，是返回对象的Json
     * <p>
     * http://localhost:8080/api/queryUserInfo?userId=1001
     * http://localhost:8080/api/queryUserInfo?userId=小团团
     */
    @RequestMapping(path = "/api/quertUserInfo", method = RequestMethod.GET)
    public UserInfo queryUserInfo(@RequestParam String userId) {
        List<String> userList = new ArrayList<String>();
        userList.add("1001");
        userList.add("aaaa");
        userList.add("ccc");
        //在这里白名单的代码占据了一大块，但它又不是业务中的逻辑，而是因为我们上线过程中需要做的开量前测试验证。
        //如果你日常对待此类需求经常是这样开发，那么可以按照此设计模式进行优化你的处理方式，让后续的扩展和摘除更加容易。
        if (!userList.contains(userId)) {
            return new UserInfo("1111", "非白名单可访问用户拦截！");
        }
        return new UserInfo("虫虫:" + userId, 19, "天津市南开区旮旯胡同100号");
    }

}
