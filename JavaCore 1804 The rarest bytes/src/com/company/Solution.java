package com.company;

/*
1804 The rarest bytes

        Enter the file name from the console.
        Find bytes or bytes with a minimum number of retries.
        Display them on the screen with a space.
        Close the I / O stream.

        Requirements:
        1. The program should read the file name from the console.
        2. To read from a file, use the FileInputStream stream.
        3. The console should display all bytes from the file with a minimum number of repetitions through a space.
        4. The data in the console should be displayed on one line.
        5. The stream of reading from the file should be closed.

 */

import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        String filename = reader.nextLine();

        FileInputStream f = new FileInputStream(filename);

        HashMap<Integer, Integer> mapOfByte = new HashMap<Integer, Integer>();

        int value = 0;
        Integer count = 0;
        while (f.available() > 0) {
            value = f.read();

            count = mapOfByte.get(value);
            if (count != null)
                count++;
            else
                count = 0;

            mapOfByte.put(value, count);
        }

        f.close();


        //int min = Collections.min(mapOfByte.values());


        //Находим минимальное число повторений
        boolean first = true;
        int min = 0;
        for (int amountByte : mapOfByte.values()) {
            if (first) {
                min = amountByte;
                first = false;
            }
            if (min > amountByte)
                min = amountByte;
        }


        //Выводим
        for (Map.Entry pair : mapOfByte.entrySet()) {
            if (min == (int) pair.getValue())
                System.out.print(" " + pair.getKey());
        }

    }
}
