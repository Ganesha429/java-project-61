package hexlet.code.games;
import java.util.Scanner;
import java.util.Random;
import hexlet.code.Engine;


public class GCD {
    public static String findTheGreatestCommonDivisor(int firstNumber, int secondNumber) {
        String gsdOfNumbers;
        int result;

        while (firstNumber != secondNumber) {
            if (firstNumber > secondNumber) {
                firstNumber = firstNumber - secondNumber;
            } else {
                secondNumber = secondNumber - firstNumber;
            }
        }

        gsdOfNumbers = String.valueOf(firstNumber);
        return gsdOfNumbers;
    }

    public static void getGCD() {
        String newUserName = Engine.getName(); // greeting and receiving the player's name

        System.out.println("Find the greatest common divisor of given numbers."); // rules of game

        int counterOfSuccessfulAttempts = 0;
        Random random = new Random();

        while (counterOfSuccessfulAttempts < 3) {
            int randomNumberFirst = random.nextInt(100); //will return the first random number from 0 to 99
            int randomNumberSecond = random.nextInt(100); //will return the second random number from 0 to 99

            System.out.println("Question: " + randomNumberFirst  + " " + randomNumberSecond);

            String gsdOfNumbers = findTheGreatestCommonDivisor(randomNumberFirst, randomNumberSecond);

            Scanner scanner = new Scanner(System.in);
            String answerOfUser = scanner.next();
            System.out.println("Your answer: " + answerOfUser);

            //checking the player's answer
            counterOfSuccessfulAttempts = Engine.checkingForCorrectness(newUserName, answerOfUser, gsdOfNumbers,
                    counterOfSuccessfulAttempts);

            // congratulating the player when he wins
            Engine.checkingTheResultOfGame(newUserName, counterOfSuccessfulAttempts);
        }
    }
}
