import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();

        //Play again loop
        boolean over = false;
        do {
            //Variables for dice and rolls
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int roll = die1 + die2;
            int previousRoll;

            // First roll outputs
            if (roll == 2 || roll == 3 || roll == 12) {
                System.out.println("You crapped out! " + die1 + " and " + die2 + " = " + roll);
                over = true;
            } else if (roll == 7 || roll == 11) {
                System.out.println("You win with a natural number! " + die1 + " and " + die2 + " = " + roll);
                over = true;
            } else {
                System.out.println("You must now roll a " + roll + " to win. " + die1 + " and " + die2);

                //Do while for all rolls after first
                boolean over2 = false;
                do {
                    //Variables for subsequent rolls
                    int die3 = rnd.nextInt(6) + 1;
                    int die4 = rnd.nextInt(6) + 1;
                    int roll2 = die3 + die4;

                    //Subsequent rolls outputs
                    if (roll == 7) {
                        System.out.println("You lose! " + roll);
                        over2 = true;
                    } else if (roll2 == roll) {
                        System.out.println("You Win! " + roll);
                        over2 = true;
                    } else {
                        System.out.println("You did not lose nor win! " +roll2 +" != " +roll);
                    }
                } while (!over2);
            }

            //Check if input if valid
            boolean inputError = false;
            do {
                System.out.print("Do you want to play again? (Y/N) ");
                Scanner in = new Scanner(System.in);
                String playAgain = in.nextLine();

                //Does player want to play again?
                if (playAgain.equalsIgnoreCase("N")) {
                    over = true;
                    inputError = true;
                } else if (playAgain.equalsIgnoreCase("Y")) {
                    over = false;
                    inputError = true;
                    System.out.println("");
                } else {
                    System.out.println("That is not a valid answer! " + playAgain);
                    over = true;
                }
            } while (!inputError);
        } while (!over);
    }
}