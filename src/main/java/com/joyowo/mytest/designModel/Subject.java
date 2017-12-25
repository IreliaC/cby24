package com.joyowo.mytest.designModel;


/**
 * Author: chenby
 * Date: 2017-12-15
 */
public interface Subject {
    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObservers();
}
