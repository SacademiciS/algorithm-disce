package behavioral.visitor.design.visitor.impl;

import behavioral.visitor.design.user.impl.Student;
import behavioral.visitor.design.user.impl.Teacher;
import behavioral.visitor.design.visitor.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parent implements Visitor {

    private Logger logger = LoggerFactory.getLogger(Parent.class);

    @Override
    public void visit(Teacher teacher) {
        logger.info("老师信息 姓名：{} 班级：{} 级别：{}", teacher.name, teacher.clazz, teacher.identity);

    }

    @Override
    public void visit(Student student) {
        logger.info("学生信息 姓名：{} 班级：{} 排名：{}", student.name, student.clazz, student.ranking());
    }

    //以上是两个具体的访问者实现类，他们都有自己的视角需求。
    //校长关注；学生的名称和班级，老师对这个班级的升学率
    //家长关注；自己家孩子的排名，老师的班级和教学水平
}
