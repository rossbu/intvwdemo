package com.shareforever.intvwdemo.corejava.keyword;

/**
 * https://www.javatpoint.com/multiple-catch-block-in-java
 */
class ExceptionDemo {
    static String message;

    /*
    1. All catch blocks must be ordered from most specific to most general,
        i.e. catch for ArithmeticException must come before catch for Exception  --> ArithmeticException then Exception
    2. At a time only ONE exception occurs and at a time only ONE catch block is executed.
    3. finally always run unless System.exit in try block.
    4. rethrow exception won't trigger more catches block. once in a catch, it will break out instead of breaking through.

     */
    public static void main(String[] args) {
        reThrowException();
//        oneCatchExecuted();
//        oneCatchTry();
//        compilerError();
    }

    private static void compilerError() {
        try {
            int a[] = new int[5];
            a[5] = 30 / 0;
        }
//        catch(Exception e){System.out.println("common task completed");}  // order from specific to general.  this compiles wrongly
        catch (ArithmeticException e) {
            System.out.println("ArithmeticException is thrown");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException is thrown");
        }
        System.out.println("rest of the code...");
    }

    /*
        Try/catch blocks don't work like that
            a catch block will always break out of the try/catch block;   which means only execute one catch {block} , won't trigger more catch below
            it doesn't "fall through" like switch statements can.
     */
    private static void reThrowException() {
        try {
            int a[] = new int[5];
            a[5] = 30 / 0;
        }
//        catch(Exception e){System.out.println("common task completed");}  //order  from specific to general.  this compiles wrongly
        catch (ArithmeticException e) {
            System.out.println("ArithmeticException is occured, and try to rethrow exception and expect to be caught, it won't work.");
            throw new ArrayIndexOutOfBoundsException();  // but WON"T be caught by below
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException is thrown");
        } catch (Exception e) {
            System.out.println("Exception is thrown");
        }
        System.out.println("rest of the code...");
    }



    private static void oneCatchTry() {
        try {
            int a[] = new int[5];
            System.out.println(a[10]);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occurs");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");  // never reach
        } catch (Exception e) {  // never reach
            System.out.println("Parent Exception occurs");
        }
    }

    private static void oneCatchExecuted() {
        try {
            int a[] = new int[5];
            a[5] = 30 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occurs");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");// never reach
        } catch (Exception e) {
            System.out.println("Parent Exception occurs");// never reach
        } finally {
            System.out.println("finally : " + message);
        }
    }

}
