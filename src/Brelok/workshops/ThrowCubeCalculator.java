package Brelok.workshops;

import java.util.Random;
import java.util.Scanner;

public class ThrowCubeCalculator {

    public static void main(String[] args) {

        int endGame;
        do {
            String code = enterTheCode();
            char[] codeChar = code.toCharArray();
            String[] split = code.split("D");

            Random random = new Random();


            int result = 0;
            int valueOfCube = 0;
            int valueOfModyficator = 0;
            int numberThrows = 0;

            if (codeChar[0] == 'D') {
                if (split[1].contains("+")) {
                    String[] splitSecond = split[1].split("\\+");
                    valueOfCube = Integer.parseInt(splitSecond[0]);
                    valueOfModyficator = Integer.parseInt(splitSecond[1]);
                    result = (random.nextInt(valueOfCube) + 1) + valueOfModyficator;

                } else if (split[1].contains("-")) {
                    String[] splitSecond = split[1].split("-");
                    valueOfCube = Integer.parseInt(splitSecond[0]);
                    valueOfModyficator = Integer.parseInt(splitSecond[1]);
                    result = (random.nextInt(valueOfCube) + 1) - valueOfModyficator;

                } else if (!(split[1].contains("+")) && !(split[1].contains("-"))) {
                    valueOfCube = Integer.parseInt(split[1]);
                    result = random.nextInt(valueOfCube) + 1;
                }
            } else if (codeChar[0] != 'D') {
                numberThrows = Integer.parseInt(split[0]);
                if (split[1].contains("+")) {
                    String[] splitSecond = split[1].split("\\+");
                    valueOfCube = Integer.parseInt(splitSecond[0]);
                    valueOfModyficator = Integer.parseInt(splitSecond[1]);
                    result = numberThrows * (random.nextInt(valueOfCube) + 1) + valueOfModyficator;

                } else if (split[1].contains("-")) {
                    String[] splitSecond = split[1].split("-");
                    valueOfCube = Integer.parseInt(splitSecond[0]);
                    valueOfModyficator = Integer.parseInt(splitSecond[1]);
                    result = numberThrows * (random.nextInt(valueOfCube) + 1) - valueOfModyficator;

                } else if (!(split[1].contains("+")) && !(split[1].contains("-"))) {
                    valueOfCube = Integer.parseInt(split[1]);
                    result = numberThrows * (random.nextInt(valueOfCube) + 1);
                }
            }

            System.out.println("Twój wynik to: " + result);
            System.out.print("Chcesz zagrać raz jeszcze? Wciśnij 1 dla TAK, 0 aby zakończyć: \n");
            Scanner end = new Scanner(System.in);
            while (!end.hasNextInt()) {
                end.nextLine();
                System.out.print("Wciśnij 1 dla TAK, 0 aby zakończyć: \n");
            }
            endGame = end.nextInt();

        } while (endGame == 1);
    }


    public static String enterTheCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj wzór rzutu kości w formacie xDy?z, gdzie:\n" +
                "x - ilość rzutu kostką,\n" +
                "y - rodzaj kostki(ilość ścian kostki),\n" +
                "? - modyfikator \"+\" lub \"-\",\n" +
                "z - wartość modyfikatora (od 1 do 99),\n: ");
        String input = null;

        do {
            input = scanner.next().toUpperCase();
            if (!(input.matches("[0-9]*D[0-9]{1,3}[+-]{0,1}[0-9]{0,2}"))) {
                System.out.print("Niepoprawny format, podaj raz jeszcze: ");
            }

        } while (!(input.matches("[0-9]*D[0-9]{1,3}[+-]{0,1}[0-9]{0,2}")));

        return input;
    }
}
