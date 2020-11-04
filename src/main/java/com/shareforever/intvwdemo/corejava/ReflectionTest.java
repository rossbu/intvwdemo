package com.shareforever.intvwdemo.corejava;

class ReflectionTest {
    public static void main(String args[]) {
        ReflectionTest myClass = new ReflectionTest();
        Class c = myClass.getClass();
        try {
            System.out.println(c.getMethod("getNumber", null).toString());
            System.out.println(c.getDeclaredMethod("setNumber", null).toString()); // need Integer.class
        } catch (NoSuchMethodException | SecurityException e) {
//            e.printStackTrace();
        }
    }

    public Integer getNumber() {
        return 2;
    }

    public void setNumber(Integer n) {
    }
}
