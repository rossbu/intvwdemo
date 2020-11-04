package com.shareforever.intvwdemo.corejava.keyword;

public class FinallyTest {
    public static void main(String[] args) {
//        systemExitFinallyWontBeTriggered(); // any methods after won't be execusted
        zeroAsDivisor();
        normalCase();
    }

    private static void systemExitFinallyWontBeTriggered() {
        try {
            int data = 25 / 1;
            System.out.println(data);
            System.exit(1);  // exit means 1, jvm shutdown. 2 catches and finally will be ignored and exit directly.
        } catch (NullPointerException e) {
            System.out.println("npe exception , so return;" + e);
            return;
        } catch (Exception e) {
            System.out.println("All Exception , so return;" + e);
            return;
        } finally {
            System.out.println("finally block is always executed");
        }
    }

    private static void zeroAsDivisor() {
        try {
            int data = 25 / 0;
            System.out.println(data);
            return;
        } catch (NullPointerException e) {
            System.out.println("npe exception , so return;" + e);
            return;  //wont' return because finally
        } catch (Exception e) {
            System.out.println("All Exception , so return;" + e);
            return; // wont' return because finally
        } finally {
            System.out.println("finally zeroAsDivisor is always executed");
        }
    }

    private static void normalCase() {
        try {
            int data = 25 / 5;
            System.out.println(data);
        } catch (NullPointerException e) {
            System.out.println("npe exception" + e);
        } finally {
            System.out.println("finally normalCase is always executed");
        }
        System.out.println("rest of the code in normalCase ...");
    }
}

