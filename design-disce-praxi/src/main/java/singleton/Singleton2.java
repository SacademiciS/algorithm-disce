package singleton;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/3/4 17:56
 * Copyright (c) 2019 北京新媒传信科技有限公司
 */
public class Singleton2 {

    private Singleton2 singleton = null;

    private Singleton2() {
    }

    public Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
