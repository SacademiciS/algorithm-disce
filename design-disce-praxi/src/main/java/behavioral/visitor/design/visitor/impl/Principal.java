package behavioral.visitor.design.visitor.impl;

import behavioral.visitor.design.user.impl.Student;
import behavioral.visitor.design.user.impl.Teacher;
import behavioral.visitor.design.visitor.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//访问者；校长
public class Principal implements Visitor {

    private Logger logger = LoggerFactory.getLogger(Principal.class);

    @Override
    public void visit(Teacher teacher) {
        logger.info("老师信息 姓名：{} 班级：{} 升学率：{}", teacher.name, teacher.clazz, teacher.entranceRatio());
    }

    @Override
    public void visit(Student student) {
        logger.info("学生信息 姓名：{} 班级：{}", student.name, student.clazz);
    }

}
