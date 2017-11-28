/*
 * This Class demonstrates use of Todo annotation defined in Todo.java
 * 
 * @author Yashwant Golecha (ygolecha@gmail.com)
 * @version 1.0
 * 
 */

package com.joyowo.mytest.config;

import org.junit.jupiter.api.Test;

public class BusinessLogic {
    public BusinessLogic() {
        super();
    }
    
    public void compltedMethod() {
        System.out.println("This method is complete");
    }    
    
    @Todo(priority = Todo.Priority.HIGH)
    @Test
    public void notYetStartedMethod() {
        // No Code Written yet
    }
    
    @Todo(priority = Todo.Priority.MEDIUM, author = "Uday", status = Todo.Status.STARTED)
    @Test
    public void incompleteMethod1() {
        //Some business logic is written
        //But its not complete yet
    }

    @Todo(priority = Todo.Priority.LOW, status = Todo.Status.STARTED )
    public void incompleteMethod2() {
        //Some business logic is written
        //But its not complete yet
    }
}
