package com.shareforever.intvwdemo.corejava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 * Can you create an instance of abstract class?
 * No, you are not creating the instance of your abstract class here.
 * Rather you are creating an instance of an anonymous subclass of your abstract class.
 * then you are invoking the method on your abstract class reference pointing to subclass object.
 */
public class ClassManipulation {
    public static void main(String a[]) {

        final MyInterface m1 = new MyInterface() {
        };
        final MyInterface m2 = new MyInterface() {
        };
        System.out.println(m1.getClass().toString());
        System.out.println(m2.getClass().toString());

        DatabaseOperations databaseOperations = new DatabaseOperations() {
            /* default method must have a body */
            @Override
            public ResultSet getData(String query) {
                return null;
            }

            @Override
            public Connection getConnection() {
                return null;
            }
        };
        MySqlDatabaseOperations oracleDatabaseOperations = new MySqlDatabaseOperations() {
            /*
                you need to implement all NON-implemented methods in either interface or abstract classes
                in this case.
                    3 methods are implemented by MySqlDatabaseOperations ,
                    1 method  is NOT implemented so add here.
             */

            @Override
            void batchExecution(List<String> batchQueries) {

            }
        };

        NoSqlDatabaseOperations noSqlDatabaseOperations = new NoSqlDatabaseOperations() {
            @Override
            void updateData(String updateQuery) {
            }

            @Override
            public ResultSet getData(String query) {
                return null;
            }

            @Override
            public Connection getConnection() {
                return null;
            }
        };

        System.out.println(databaseOperations.getClass().toString());
        System.out.println(oracleDatabaseOperations.getClass().toString());//SubClass$4
        System.out.println(noSqlDatabaseOperations.getClass().toString()); //SubClass$5

    }
}

interface MyInterface {
    default void defaultMethod() {
    }

    ;
}

interface MyInterface1 extends MyInterface {
    //Return type does not matter while overloading a method.
//    default String defaultMethod() { return "";};
    default void defaultMethod(String v) {
    }

    ;
}

interface DatabaseOperations {
    ResultSet getData(String query);

    default void executeProcedure(String procedureName) {
        System.out.println("do nothing");
    }

    Connection getConnection();
}

abstract class NoSqlDatabaseOperations implements DatabaseOperations {
    abstract void updateData(String updateQuery);

    void deleteData(String query) {/*code to delete records from database tables */ }
}


abstract class MySqlDatabaseOperations implements DatabaseOperations {
    public ResultSet getData(String query) {
        /*code to execute query and return result set.*/
        return null;
    }

    public void executeProcedure(String procedureName) {
        /*code to execute procedure.*/
    }

    public Connection getConnection() {
        /*code to return connection object. */
        return null;
    }

    abstract void batchExecution(List<String> batchQueries);
}

class OracleDatabaseOperations implements DatabaseOperations {
    public ResultSet getData(String query) {
        /*code to execute query and return result set.*/
        return null;
    }

    public Connection getConnection() {
        /*code to return connection object. */
        return null;
    }
}
