package hexlet.code.games;
import java.util.Scanner;
import java.util.Random;
import hexlet.code.Engine;


public class Parity {
    public static void getNumber() {
        String newUserName = Engine.getName(); // greeting and receiving the player's name

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'."); // rules of game

        int counterOfSuccessfulAttempts = 0;
        Random random = new Random();

        while (counterOfSuccessfulAttempts < 3) {
            int randomNumber = random.nextInt(100); //will return a random number from 0 to 99
            System.out.println("Question: " + randomNumber);

            Scanner scanner = new Scanner(System.in);
            String answerOfUser = scanner.next();
            System.out.println("Your answer: " + answerOfUser);

            //checking the player's answer
            if (randomNumber % 2 == 0) {
                counterOfSuccessfulAttempts = Engine.checkingForCorrectness(newUserName, answerOfUser, "yes",
                        counterOfSuccessfulAttempts);
            } else {
                counterOfSuccessfulAttempts = Engine.checkingForCorrectness(newUserName, answerOfUser, "no",
                        counterOfSuccessfulAttempts);
            }
        }
        // congratulating the player when he wins
        Engine.checkingTheResultOfGame(newUserName, counterOfSuccessfulAttempts);
    }
}
