package Brelok.workshops;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class LottoGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] userNumber = new int[6];
        int endGame;

        System.out.println("Zagrajmy w Lotto! Podaj liczby w zakresie 1 - 49.");
        do {
            for (int i = 0; i < userNumber.length; i++) {
                int proposal = 0;

                System.out.print("Podaj " + (i + 1) + " liczbę: ");
                try{
                    while (!scanner.hasNextInt()) {
                        scanner.nextLine();
                        System.out.print("To nie jest liczba. Podaj " + (i + 1) + " liczbę z zakresu 1 - 49: ");
                    }
                    proposal = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e1) {};

                try{
                    while (proposal  <= 0 || proposal >= 50) {
                        System.out.print("Zbyt duży zakres. Podaj " + (i + 1) + " liczbę z zakresu 1 - 49: ");
                        proposal = scanner.nextInt();
                        scanner.nextLine();
                    }
                } catch (InputMismatchException e2) {};

                if (Arrays.binarySearch(userNumber, proposal) >= 0 ) {
                    System.out.print("Już jest taka liczba. Podaj inną: ");
                    proposal = scanner.nextInt();
                    scanner.nextLine();
                }
                userNumber[0] = proposal;
                Arrays.sort(userNumber);
            }

            System.out.println("Oto Twoje liczby: " + Arrays.toString(userNumber));
            int[] computerNumber = computerNumbers();

            System.out.println(result(userNumber, computerNumber));
            System.out.print("Chcesz zagrać raz jeszcze? Wciśnij 1 dla TAK, 0 aby zakończyć: \n");

            Scanner end = new Scanner(System.in);
            while (!end.hasNextInt()) {
                end.nextLine();
                System.out.print("Wciśnij 1 dla TAK, 0 aby zakończyć: \n");
            }
            endGame = end.nextInt();

        } while (endGame == 1);
    }

    static int [] computerNumbers (){
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

    static String result (int [] userNumber, int [] computerNumber){
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
