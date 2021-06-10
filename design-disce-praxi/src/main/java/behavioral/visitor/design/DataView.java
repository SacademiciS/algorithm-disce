package behavioral.visitor.design;

import behavioral.visitor.design.user.User;
import behavioral.visitor.design.user.impl.Student;
import behavioral.visitor.design.user.impl.Teacher;
import behavioral.visitor.design.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class DataView {

    List<User> userList = new ArrayList<User>();

    public DataView() {
        userList.add(new Student("谢飞机", "重点班", "一年一班"));
        userList.add(new Student("windy", "重点班", "一年一班"));
        userList.add(new Student("大毛", "普通班", "二年三班"));
        userList.add(new Student("Shing", "普通班", "三年四班"));
        userList.add(new Teacher("BK", "特级教师", "一年一班"));
        userList.add(new Teacher("娜娜Goddess", "特级教师", "一年一班"));
        userList.add(new Teacher("dangdang", "普通教师", "二年三班"));
        userList.add(new Teacher("泽东", "实习教师", "三年四班"));
    }

    // 展示
    public void show(Visitor visitor) {
        for (User user : userList) {
            user.accept(visitor);
        }
    }

    //首先在这个类中初始化了基本的数据，学生和老师的信息。
    //并提供了一个展示类，通过传入不同的观察者(校长、家长)而差异化的打印信息。
}
