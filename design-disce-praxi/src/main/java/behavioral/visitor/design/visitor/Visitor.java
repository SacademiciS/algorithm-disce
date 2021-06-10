package behavioral.visitor.design.visitor;

import behavioral.visitor.design.user.impl.Student;
import behavioral.visitor.design.user.impl.Teacher;

public interface Visitor {

    void visit(Teacher teacher);

    void visit(Student student);

}
