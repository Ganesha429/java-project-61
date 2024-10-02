package hexlet.code;
import java.util.Scanner;
import java.util.Random;


public class Parity {
    public static void getNumber() {

        String newUserName = Cli.getName(); // greeting and receiving the player's name

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'."); // rules of game

        int counterOfSuccessfulAttempts = 0;
        Random random = new Random();

        while(counterOfSuccessfulAttempts < 3) {
            int randomNumber = random.nextInt(100); //will return a random number from 0 to 99

            System.out.println("Question: " + randomNumber);

            Scanner scanner = new Scanner(System.in);
            String answerOfUser = scanner.next();

            System.out.println("Your answer: " + answerOfUser);

            //checking the player's answer
            if(randomNumber % 2 == 0) {
                if(answerOfUser.equalsIgnoreCase("yes")) {
                    System.out.println("Correct!");
                    counterOfSuccessfulAttempts += 1;
                }
                else {
                    System.out.println(answerOfUser + " is wrong answer ;(. Correct answer was 'yes'.\n" +
                            "Let's try again, " + newUserName + "!");
                    counterOfSuccessfulAttempts = 5;
                }
            }
            else {
                if(answerOfUser.equalsIgnoreCase("no")) {
                    System.out.println("Correct!");
                    counterOfSuccessfulAttempts += 1;
                }
                else {
                    System.out.println(answerOfUser + " is wrong answer ;(. Correct answer was 'no'.\n" +
                            "Let's try again, " + newUserName + "!");
                    counterOfSuccessfulAttempts = 5;
                }
            }
        }

        // in order to win, the player must answer correctly 3 times in a row
        if(counterOfSuccessfulAttempts == 3) {
            System.out.println("Congratulations, " + newUserName + "!");
        }
    }
}
