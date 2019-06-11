package Brelok.workshops;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoPropability {
    public static void main(String[] args) {

        int result1 = 0;
        int result2 = 0;
        int result3 = 0;
        int result4 = 0;
        int result5 = 0;
        int result6 = 0;

        double draw = 100;
        List<Integer> listOfDraw = new ArrayList<>();

        for (int i = 0; i < draw; i++) {
            listOfDraw.add(result(computerNumber(), computerNumber()));
        }

        for (Integer result : listOfDraw) {
            if (result == 1) {
                result1++;
            } else if (result == 2) {
                result2++;
            } else if (result == 3) {
                result3++;
            } else if (result == 4) {
                result4++;
            } else if (result == 5) {
                result5++;
            } else if (result == 6) {
                result6++;
            }
        }

        System.out.println("Prawdopobieństwo wypadnięcia 1 dla " + draw + " losowań to: " + Math.round(result1 / draw * 100) + "%");
        System.out.println("Prawdopobieństwo wypadnięcia 2 dla " + draw + " losowań to: " + Math.round(result2 / draw * 100) + "%");
        System.out.println("Prawdopobieństwo wypadnięcia 3 dla " + draw + " losowań to: " + Math.round(result3 / draw * 100) + "%");
        System.out.println("Prawdopobieństwo wypadnięcia 4 dla " + draw + " losowań to: " + Math.round(result4 / draw * 100) + "%");
        System.out.println("Prawdopobieństwo wypadnięcia 5 dla " + draw + " losowań to: " + Math.round(result5 / draw * 100) + "%");
        System.out.println("Prawdopobieństwo wypadnięcia 6 dla " + draw + " losowań to: " + Math.round(result6 / draw * 100) + "%");
    }

    static int[] computerNumber() {
        Integer[] integers = new Integer[49];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(integers));

        int[] computerNumber = new int[6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= 1; j++)
                computerNumber[i] = integers[i];
        }
        Arrays.sort(computerNumber);
        return computerNumber;
    }

    static int result(int[] tab1, int[] tab2) {
        int count = 0;
        for (int i = 0; i < tab1.length; i++) {
            for (int j = 0; j < tab2.length; j++) {
                if (tab1[i] == tab2[j]) {
                    count++;
                }
            }
        }
        return count;

    }
}