package hexlet.code.games;
import java.util.Scanner;
import java.util.Random;
import hexlet.code.Engine;


public class Prime {
    public static void checkNumber(int numOfGame) {
        String newUserName = Engine.getName(numOfGame); // greeting and receiving the player's name
        int counterOfSuccessfulAttempts = 0;
        Random random = new Random();

        while (counterOfSuccessfulAttempts < 3) {
            int randomNumber = random.nextInt(100); // will return a random number from 0 to 99
            System.out.println("Question: " + randomNumber);

            Scanner scanner = new Scanner(System.in);
            String answerOfUser = scanner.next();
            System.out.println("Your answer: " + answerOfUser);

            boolean isPrime = isPrime(randomNumber);
            String correctAnswer = isPrime ? "yes" : "no";

            counterOfSuccessfulAttempts = Engine.checkingForCorrectness(newUserName, answerOfUser, correctAnswer,
                                                                        counterOfSuccessfulAttempts);
        }

        // congratulating the player when he wins
        Engine.checkingTheResultOfGame(newUserName, counterOfSuccessfulAttempts);
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
