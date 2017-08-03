package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {

        switch (args[0]){
            case "-e" : encrypt(args[1], args[2]);
                break;
            case "-d" : decrypt(args[1], args[2]);
        }

    }

    private static void decrypt(String fileName, String fileOutputName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutputName);
        while(fis.available() > 0 ){
            int count = fis.read();
            count = count - 5;
            fos.write(count);
        }
        fis.close();
        fos.close();
    }

    private static void encrypt(String fileName, String fileName2) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileName2);
        while(fis.available() > 0 ){
            int count = fis.read();
            count = count + 5;
            fos.write(count);
        }
        fis.close();
        fos.close();
    }

}
