package Brelok.workshops;

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

        double draw = 4;
        int [] listOfDraw = new int[(int) draw]; //lista, której długościa jest liczba losowań
        Arrays.fill(listOfDraw, 0); //uzupełniamy zerami


        for (int i = 0; i < listOfDraw.length; i++) {
            listOfDraw[i] = result(computerNumber(), computerNumber());
        }

        for (int i = 0; i < listOfDraw.length; i++) {
            if (listOfDraw[i] == 1) { // w jaki sposób zliczyć ilość 1, 2, 3 w losowaniu?
                result1++;
            } else if (listOfDraw[i] == 2) {
                result2++;
            } else if (listOfDraw[i] == 3) {
                result3++;
            } else if (listOfDraw[i] == 4) {
                result4++;
            } else if (listOfDraw[i] == 5) {
                result5++;
            } else {
                result6++;
            }
        }

        double propaiblityOf1 = result1 / draw;
        System.out.println("Prawdopobieństwo wypadnięcia 1 dla " + draw + " losowań to: " + propaiblityOf1);
        double propaiblityOf2 = result2 / draw;
        System.out.println("Prawdopobieństwo wypadnięcia 2 dla " + draw + " losowań to: " + propaiblityOf2);
        double propaiblityOf3 = result3 / draw;
        System.out.println("Prawdopobieństwo wypadnięcia 3 dla " + draw + " losowań to: " + propaiblityOf3);
        double propaiblityOf4 = result4 / draw;
        System.out.println("Prawdopobieństwo wypadnięcia 4 dla " + draw + " losowań to: " + propaiblityOf4);
        double propaiblityOf5 = result5 / draw;
        System.out.println("Prawdopobieństwo wypadnięcia 5 dla " + draw + " losowań to: " + propaiblityOf5);
        double propaiblityOf6 = result6 / draw;
        System.out.println("Prawdopobieństwo wypadnięcia 6 dla " + draw + " losowań to: " + propaiblityOf6);
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


            static int result ( int[] tab1, int[] tab2){
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