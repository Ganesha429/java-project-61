package hexlet.code.games;
import java.util.Scanner;
import java.util.Random;
import hexlet.code.Engine;


public class Calc {
    public static void getResult(int numOfGame) {
        String newUserName = Engine.getName(numOfGame); // greeting and receiving the player's name

        int counterOfSuccessfulAttempts = 0;
        Random random = new Random();

        while (counterOfSuccessfulAttempts < 3) {
            int randomNumberFirst = random.nextInt(100); //will return the first random number from 0 to 99
            int randomNumberSecond = random.nextInt(100); //will return the second random number from 0 to 99

            String[] operation = {"+", "-", "*"};
            int randomNumberForOperation = random.nextInt(3);

            System.out.println("Question: " + randomNumberFirst + " " + operation[randomNumberForOperation] + " "
                                + randomNumberSecond);

            Scanner scanner = new Scanner(System.in);
            String answerOfUser = scanner.next();
            System.out.println("Your answer: " + answerOfUser);

            // true answers
            String strTrueResultOfSum = String.valueOf(randomNumberFirst + randomNumberSecond);
            String strTrueResultOfDifference = String.valueOf(randomNumberFirst - randomNumberSecond);
            String strTrueResultOfMultiplication = String.valueOf(randomNumberFirst * randomNumberSecond);

            String strTrueResult = switch (randomNumberForOperation) {
                case 0 -> strTrueResultOfSum;
                case 1 -> strTrueResultOfDifference;
                case 2 -> strTrueResultOfMultiplication;
                default -> throw new IllegalStateException("Unexpected value: " + randomNumberForOperation);
            };

            //checking the player's answer
            counterOfSuccessfulAttempts = Engine.checkingForCorrectness(newUserName, answerOfUser,
                    strTrueResult, counterOfSuccessfulAttempts);

            // congratulating the player when he wins
            Engine.checkingTheResultOfGame(newUserName, counterOfSuccessfulAttempts);
        }
    }
}
