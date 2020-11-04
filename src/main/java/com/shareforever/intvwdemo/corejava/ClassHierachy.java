package com.shareforever.intvwdemo.corejava;

public class ClassHierachy implements Order {

    private int x;

    private void callme() {
    }

    public static void main(String[] args) {
        Order ch = new ClassHierachy();
//        ch.initialize(new JavaSEEnvironment());
    }

    /*
        Outer class can access any field of Inner class but through object of inner class.
     */
    public void outerCall() {
        Inner inner = new Inner();
        inner.g();
        inner.y = 5; // access private field in the inner class
        inner.accessMe = "tryme";
    }

    private class Inner {
        private int y;
        private String accessMe;

        public void g() {
            x = 5;   // inner class can access outter class's variable
            callme();
        }
    }

    @Override
    public void initialize(IKMEnvironment environment) {
        if (environment instanceof JavaSE7TestEnvironment) {
            System.out.println("JavaSE7TestEnvironment");
        } else if (environment instanceof JavaSEEnvironment) {
            System.out.println("JavaSEEnvironment");
        } else if (environment instanceof TestEnvironment) {
            System.out.println("TestEnvironment");
        } else if (environment instanceof JavaEETestEnvironment) {
            System.out.println("JavaEETestEnvironment");
        } else if (environment instanceof JavaSETestEnvironment) {
            System.out.println("JavaSETestEnvironment");
        }
    }
}

interface Order {
    public void initialize(IKMEnvironment environment);
}

interface IKMObserver {
}

interface Environment {
}

interface IKMEnvironment extends Environment {
}

interface IKMProgramEnvironment extends IKMEnvironment {
}

class JavaSEEnvironment implements Environment {
}

class TestEnvironment implements IKMEnvironment {
}

class JavaSETestEnvironment extends TestEnvironment {
}

class JavaSE7TestEnvironment implements IKMObserver {
}

class JavaEETestEnvironment implements IKMObserver, IKMProgramEnvironment {
}
