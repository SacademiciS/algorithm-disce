package behavioral.visitor.design.user.impl;

import behavioral.visitor.design.user.User;
import behavioral.visitor.design.visitor.Visitor;

public class Student extends User {

    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int ranking() {
        return (int) (Math.random() * 100);
    }
}
