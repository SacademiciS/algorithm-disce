package singleton;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/3/4 17:54
 * Copyright (c) 2019 北京新媒传信科技有限公司
 */
public class Singleton1 {

    private Singleton1 singleton1;

    private Singleton1() {

    }

    public Singleton1 getInstance() {
        return singleton1;
    }
}
