package com.example.zadanie2;

public class SimpleTask {

    int[] prepareData(String input) {
        String[] stringArray = input.split(",");
        int size = stringArray.length;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }
        return array;
    }

    int processArray(int[] array) {
        int even = 0;
        int indexEven = 0;
        int odd = 0;
        int indexOdd = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                even++;
                indexEven = i;
            } else {
                odd++;
                indexOdd = i;
            }
        }
        if (even < odd) {
            return array[indexEven];
        } else {
            return array[indexOdd];
        }
    }
}


