package com.joyowo.mytest.designModel;

/**
 * Author: chenby
 * Date: 2017-12-15
 */
public class StudentObserver implements Observer {

    private Subject t;
    private String name;
    public StudentObserver(String name, Subject t) {
        this.name = name;
        this.t = t;
        t.addObserver(this);
    }

    @Override
    public void update(String info) {
        System.out.println(name + "收到的作业是" + info);
    }

    public static void main(String[] args) {
        TeacherSubject t = new TeacherSubject();
        StudentObserver s1 = new StudentObserver("zs",t);
        StudentObserver s2 = new StudentObserver("ls",t);
        StudentObserver s3 = new StudentObserver("ww",t);
        t.setHomework("课后练习题");
    }

}
