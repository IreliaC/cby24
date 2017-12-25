package com.joyowo.mytest.designModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: chenby
 * Date: 2017-12-15
 */
public class TeacherSubject implements Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private String info;
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(x -> x.update(info));
    }

    public void setHomework(String info) {
        this.info = info;
        System.out.println("今天的作业是" + info);
        this.notifyObservers();
    }
 }
