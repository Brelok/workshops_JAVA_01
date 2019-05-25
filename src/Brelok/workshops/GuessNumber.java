package Brelok.workshops;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        Random random = new Random();

        int guess = random.nextInt(101) + 1;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Zagraj ze mna! Zgadnij liczbę w zakresie od 1 do 100!: ");

        int check;
        int count = 0;

        while (true) {
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.print("To nie jest liczba, nie oszukuj!: ");
            }
            check = scanner.nextInt();

            if (check < guess) {
                System.out.print("Daj więcej: ");
                count++;

            } else if (check > guess) {
                System.out.print("Daj mniej!: ");
                count++;

            } else {
                count++;
                System.out.println("Brawo! Zgadłeś w " + count + " ruchach!");
                break;
            }
        }
    }
}