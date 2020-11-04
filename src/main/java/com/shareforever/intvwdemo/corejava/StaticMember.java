package com.shareforever.intvwdemo.corejava;


/**
 * private, static and final methods cannot be overridden as they are local to the class.
 */
public class StaticMember {
    public static void main(String[] args) {
        Invoice invoice = new SalesInvoice();
        SalesInvoice salesInvoice = new SalesInvoice();
        System.out.println(invoice.formatId("1234"));
        System.out.println(salesInvoice.formatId("1234"));
    }
}

class Invoice {
    public static String formatId(String oldId) {
        return oldId + "_Invoice";
    }
}

class SalesInvoice extends Invoice {

    // static can not be overridden, but can be re-declared
    public static String formatId(String oldId) {
        return oldId + "_SalesInvoice";
    }
}




