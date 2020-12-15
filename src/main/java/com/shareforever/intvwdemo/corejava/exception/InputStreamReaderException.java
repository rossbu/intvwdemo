package com.shareforever.intvwdemo.corejava.exception;

import java.io.*;
import java.util.*;

/**
 * FileReader can take File or File name
 * BufferedReader can only take 'Reader' such as FileReader or InputStreamReader
 * InputStreamReader can only take 'InputStream' such as FileInputStream
 */
public class InputStreamReaderException {
    private static String initString;

    static {
        String currentString = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("initconfig.txt"));
            initString = reader.lines().findFirst().orElse(null);
        } catch (IOException ex) {
            throw new NoSuchElementException("File initconfig.txt");
        }
    }

    public InputStreamReaderException() {
        if (initString.length() == 0) {
            throw new IllegalArgumentException("length is zero");
        }
        System.out.println("It works!");
    }

    public static void main(String[] args) {
        InputStreamReaderException myClass = new InputStreamReaderException();
    }
}
