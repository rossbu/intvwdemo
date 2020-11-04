package com.shareforever.intvwdemo.misc;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionDemo {
    public static void main(String args[]) {
        int x = 5, y = 0;
        try {
            try {
                System.out.println(x);
                System.out.println(x / y);
                System.out.println(y);
            } catch (ArithmeticException ex) {
                System.out.println("Inner Catch1 - Arithmetic Issue");
                throw ex;
            } catch (Exception ex) {
                System.out.println("Inner Catch2 - RunTime Issue");
                throw ex;
            } finally {
                System.out.println("Inner Finally");
            }
        } catch (Exception ex) {
            System.out.println("Outer Catch - Exception");
        }

        // 2nd test
        ExceptionDemo exceptionDemo = new ExceptionDemo();
        exceptionDemo.testExceptionFinally();


    }

    public List<String> queueSequence;

    public void testExceptionFinally() {
        try {
            establishQueueSequence();
        } finally {
            cleanupQueueSequence();
            System.out.println("Queue sequence successfully cleaned up");
        }
    }

    private void establishQueueSequence() {
        if (true) {
            throw new IllegalArgumentException();
        }
        queueSequence = new ArrayList<String>();
    }

    private void cleanupQueueSequence() {
        if (queueSequence.size() > 0) {
            System.out.println("Queue size > 0");
        }
    }


}
