package com.shareforever.intvwdemo.corejava;


import java.util.*;
import java.util.function.Consumer;

public class NestedClass {
    private final String parentLog = new String();
    private String enclosingClassName = "";


    // static var -  class only
    static String ID = "";

    // static block - class only
    static {
        ID = "I am valued by static block";
    }

    // static method : which can ONLY access static variables
    static String getLog() {
        System.out.println(ID);
        //        System.out.println(parentLog); // Not allowed
        //        System.out.println(enclosingClassName); // Not allowed
        return "";
    }

    /*
        like other static members, such a static class is really just a hanger on that uses the containing class as its namespace.
        static class have nothing to do with any instances of the containing class.
        such a class has access to its containing class's private static members
    */
    static class StaticClass {
        String name;
        String type;
        static String uuid;

        static {
            ID = "GOATID by Goat static block";
        }

        public void test() {
            ID = "instance method invoked";
        }

        public static void tryMe() {
            ID = "statick method invoked";   //you can access enclosing instance var from static context.
//             NestedClass.this.enclosingClassName = ""; this can't be referenced from static context
        }
    }

    /*
        the inner class is known as qualified by its containing class name
        every instance of an inner class is tied to a particular instance of its containing class
        inner class instance has access to the instance members of the containing class instance
        InnerClass instance is implicitly tied to the Rhino NestedClass.cass this
        this in the inner class refers to the inner class instance
        inner class can NOT have static declaration
        you can refer to this of the containing class as EnclosingClass.this,  you can use this to refer to its members e.g. NestedClass.this.enclosingClassName

     */
    class InnerClass {
        String innerClassName;
        String type;

        //          inner class can NOT have static declaration
        //        static { }
        //        static void getMe(){}
        public void testMe() {
            System.out.println(this.innerClassName);
            System.out.println(enclosingClassName == NestedClass.this.enclosingClassName); // you can go directly
        }
    }

    /*
        A local inner class is a class declared in the body of a method.
        A local inner class is only known within its containing method
        A local inner class can only be instantiated and have its members accessed within its containing method.
        A local inner class is neither the member of a class or package
        Any inner class can NOT have static declaration
        A local inner class can access the final local variables of its containing method

     */
    public void localInnerClassOnlyInMethod() {
        final String methodString = "";
        class LocalInnerClass {
            String localInnerClassName;
            String id;

            public void getName() {
                System.out.println(methodString); // you can change it but you can ACCESS it.
            }
//            static String uuid;
//            static void getMe(){ }
        }
    }


    public void anonymousInnerClass() {
        List<String> list = new ArrayList<>() {
        };
        Set<Integer> integerSet = new TreeSet<>() {
        };
        Collection hashSet = new HashSet<>() {{
        }};  // double brace initialization
        Consumer consumer = new Consumer() {         //   new *InterfaceName*() {*members*}
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };
        Consumer consumer1 = o -> System.out.println(o);
    }


    public static void main(String[] args) {
        StaticClass goat = new StaticClass(); // activate Goat first, ID won't be re-evaluated otherwise.
        System.out.println(ID);
    }
}
