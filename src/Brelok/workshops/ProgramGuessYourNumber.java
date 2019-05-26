package Brelok.workshops;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ProgramGuessYourNumber {

    public static void main(String[] args) {

        int computerGuessFinally = 0;
        int min = 0;
        int max = 1000;
        int count = 1;

        System.out.println("Pomyśl liczbę od 0 do 1 000 a ja ją zgadnę w max 10 próbach;");
        try {
            TimeUnit.SECONDS.sleep(2);
        }   catch (InterruptedException e) {} //sposóp na zatrzymanie algorytmu na określony czas

        do {
            int guess = ((max - min) / 2) + min;

            System.out.print("Zgaduję... " + guess + ". Wybierz 1 dla TAK, 0 dla NIE ");

            Scanner scanner = new Scanner(System.in);
            while(!scanner.hasNextInt() ){//user must write a number
                scanner.nextLine();//clean console
                System.out.print("To nie jest liczba! 1 = TAK, 0 = NIE ");
            }
            computerGuessFinally = scanner.nextInt();
            scanner.hasNextLine();

            try { //user must write number 0 or 1
                while (computerGuessFinally > 1 || computerGuessFinally < 0) {
                    System.out.print("NIe poprawny zakres. 1 = TAK, 0 = NIE ");
                    computerGuessFinally = scanner.nextInt();
                    scanner.nextLine();
                }
            } catch (InputMismatchException e) {}

            if (computerGuessFinally == 1) { //main condtition game. 1 to win, 0 to go on
                System.out.println("\nWygrałem! Zgadłem w " + count + " ruchach!");

            } else if (computerGuessFinally == 0) { //if 0 ask is number is too much. 1 to YES.
                System.out.print("Za dużo? Wybierz 1 dla TAK, 0 dla NIE: ");
                Scanner tooMuch = new Scanner(System.in);
                int tooMuchNumber = 0;
                tooMuchNumber = tooMuch.nextInt();

                 if (tooMuchNumber == 1) { //if 1, max = guessa and loop start again
                     max = guess;
                     count++;

                 } if (tooMuchNumber == 0) {// if 0 ask is number is not enough, 1 to YES
                    System.out.print("Za mało? Wybierz 1 dla TAK, 0 dla NIE: ");
                    Scanner notEnough = new Scanner(System.in);
                    int notEnoughNumber = notEnough.nextInt();

                    if (notEnoughNumber == 1){// if 1, mix = guess and loop start again
                        min = guess;
                        count++;

                    } else { //if 0, this is logic mistake of user
                        System.out.println("Nie oszukuj!");
                    }
                }
            }
        } while (computerGuessFinally == 0);// finish game when computer guess
    }

    static int caseTooMuch(int guess, int min, int max) {
        Scanner tooMuch = new Scanner(System.in);
        int tooMuchNumber = tooMuch.nextInt();
        if (tooMuchNumber == 1) {
            max = guess;
        } else caseTooMin(guess, min, max);
        return max;
    }

    static int caseTooMin (int guess, int min, int max) {
        System.out.print("Za mało? Wybierz 1 dla TAK, 0 dla NIE: ");
        Scanner notEnough = new Scanner(System.in);
        int notEnoughNumber = notEnough.nextInt();

        switch (notEnoughNumber) {
            case 0:
                System.out.print("Nie oszukuj!");
                break;
            case 1:
                min = guess;
                break;
        }
        return min;
    }
}
