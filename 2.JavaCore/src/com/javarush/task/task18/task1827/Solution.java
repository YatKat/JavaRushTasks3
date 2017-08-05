package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName = r.readLine();

        switch (args[0]){
            case "-c" : addData(formData(args[1], args[2], args[3]), fileName); break;
            default: break;
        }

    }

    private static void addData(String allData, String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        byte [] id = new byte[fis.available()];
            int count = fis.read(id);
        fis.close();
        ArrayList<String> list = new ArrayList<>();
        String s = new String(id);
        String [] ss = s.split("\n");
        for (int i = 0; i < ss.length ; i++) {
            list.add(ss[i].substring(0,8));
        }
        ArrayList<Integer> listOfId = new ArrayList<>();
        for (int i = 0; i < list.size() ; i++) {
            if(list.get(i).contains(" ")) {
                int index = list.get(i).indexOf(" ");
                listOfId.add(Integer.parseInt(list.get(i).substring(0, index)));
            }
            else listOfId.add(Integer.parseInt(list.get(i)));
        }
        Collections.sort(listOfId);

        int idPlus = listOfId.get(listOfId.size() - 1) + 1;
        String strokaID = String.valueOf(idPlus);
            if (strokaID.length() < 8) {
                int var = 8 - strokaID.length();
                for (int i = 0; i < var; i++) {
                    strokaID +=" ";
                }
            }
        String stroka = strokaID + allData;
        s += "\r\n"+ stroka;
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(s.getBytes());
        fos.close();
    }

    private static String formData(String productName, String price, String quantity) {
        String allData = productName;
        if(productName.length()< 30){
            for (int i = 0; i < 30 - productName.length() ; i++) {
                allData+=" ";
            }
        }
        allData+= price;
        if(price.length() < 8){
            for (int i = 0; i < 8 - price.length() ; i++) {
                allData+=" ";
            }
        }
        allData+= quantity;
        if(quantity.length() < 4){
            for (int i = 0; i < 4 - quantity.length() ; i++) {
                allData+= " ";
            }
        }
        return allData;
    }
}
