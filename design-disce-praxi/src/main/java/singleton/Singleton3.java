package singleton;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/3/4 18:02
 * Copyright (c) 2019 北京新媒传信科技有限公司
 */
public class Singleton3 {

    private Singleton3 singleton = null;

    private Singleton3() {
    }

    public Singleton3 getInstance() {
        if (singleton == null) {
            singleton = new Singleton3();
        }
        return singleton;
    }

}
