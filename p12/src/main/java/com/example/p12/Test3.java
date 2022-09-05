package com.example.p12;

import java.io.FileInputStream;

public class Test3 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("/home/parvin/Downloads/microsoft.gpg");
        byte[] bytes = fis.readAllBytes();
        System.out.println(bytes);
    }
}
