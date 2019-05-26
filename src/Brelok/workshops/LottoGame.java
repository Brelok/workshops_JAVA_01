package Brelok.workshops;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class LottoGame {
    public static void main(String[] args) {
            int endGame;
            do {
                System.out.println("Zagrajmy w Lotto!");
                int [] userNumber = getUniqueInt(6,1, 49);

                System.out.println(result(userNumber, computerNumbers()));

                System.out.print("Chcesz zagrać raz jeszcze? Wciśnij 1 dla TAK, 0 aby zakończyć: \n");

                Scanner end = new Scanner(System.in);
            while (!end.hasNextInt()) {
                end.nextLine();
                System.out.print("Wciśnij 1 dla TAK, 0 aby zakończyć: \n");
            }
                endGame = end.nextInt();
            } while (endGame == 1);
    }

    public static int[] getUniqueInt (int count, int lowerBound, int upperBound){
        int [] uniqueInt = new int[count];
        Arrays.fill(uniqueInt,lowerBound - 1);
        int counter = 0;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Podaj %d liczbę: ", counter + 1);
            while(!scanner.hasNextInt()){
                String badInput = scanner.nextLine();
                System.out.printf("\"%s\" nie jest liczbą! Podaj poprawną liczbe : ", badInput);
            }
            int proposal = scanner.nextInt();
            if (proposal < lowerBound || proposal > upperBound) {
                System.out.printf("Podaj liczbę z zakresu od %d do %d ", lowerBound, upperBound);
                continue;
            }
            if (Arrays.binarySearch(uniqueInt, proposal) >=0) {
                System.out.printf("%d już została wybrana. ", proposal);
                continue;
            }
            uniqueInt[0] = proposal;
            Arrays.sort(uniqueInt);
            counter++;
            }
                while (counter < count);
                System.out.println("Oto Twoje liczby: " + Arrays.toString(uniqueInt));
                return uniqueInt;
    }

    static int [] computerNumbers (){//shuffle computer numbers
        Integer [] integers = new Integer[49];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(integers));

        int [] computerNumber= new int [6];

        for (int i = 0; i < 6; i++){
            for (int j = 0; j <= 1; j++)
            computerNumber[i] = integers [i];
        }
        Arrays.sort(computerNumber);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {}

        System.out.println("A to liczby z dzisiejszego losowania: " + Arrays.toString(computerNumber));

        return computerNumber;
    }

    static String result (int [] userNumber, int [] computerNumber){//equals user number with computer number
        int count = 0;
        for (int i = 0; i <userNumber.length; i++) {
            for (int j = 0; j < computerNumber.length; j++) {
                if (userNumber[i] == computerNumber[j]){
                    count++;
                }
            }
        }
        switch (count) {
            case 3:
                return  "Brawo! Trafiłeś 3!";
            case 4:
                return  "Brawo! Trafiłeś 4!";
            case 5:
                return  "Brawo! Trafiłeś 5!";
            case 6:
                return  "Brawo! Trafiłeś 6!";
        }
        return "Nie trafiłeś, spróbuj jeszcze raz.";
    }
}
