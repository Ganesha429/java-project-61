package hexlet.code.games;
import java.util.Scanner;
import java.util.Random;
import hexlet.code.Engine;


public class Calc {
    public static void getSum() {
        String newUserName = Engine.getName(); // greeting and receiving the player's name

        System.out.println("What is the result of the expression?"); // rules of game

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

            //checking the player's answer
            switch (randomNumberForOperation) {
                case 0:
                    int trueResultOfSum = randomNumberFirst + randomNumberSecond;
                    String strTrueResultOfSum = String.valueOf(trueResultOfSum);
                    counterOfSuccessfulAttempts = Engine.checkingForCorrectness(newUserName, answerOfUser,
                            strTrueResultOfSum, counterOfSuccessfulAttempts);
                    break;
                case 1:
                    int trueResultOfDifference = randomNumberFirst - randomNumberSecond;
                    String strTrueResultOfDifference = String.valueOf(trueResultOfDifference);
                    counterOfSuccessfulAttempts = Engine.checkingForCorrectness(newUserName, answerOfUser,
                            strTrueResultOfDifference, counterOfSuccessfulAttempts);
                    break;
                case 2:
                    int trueResultOfMultiplication = randomNumberFirst * randomNumberSecond;
                    String strTrueResultOfMultiplication = String.valueOf(trueResultOfMultiplication);
                    counterOfSuccessfulAttempts = Engine.checkingForCorrectness(newUserName, answerOfUser,
                            strTrueResultOfMultiplication, counterOfSuccessfulAttempts);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + randomNumberForOperation);
            }
            // congratulating the player when he wins
            Engine.checkingTheResultOfGame(newUserName, counterOfSuccessfulAttempts);
        }
    }
}
