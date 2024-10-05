package hexlet.code.games;
import java.util.Scanner;
import java.util.Random;
import hexlet.code.Engine;


public class Progression {
    public static void getProgression() {
        String newUserName = Engine.getName(); // greeting and receiving the player's name

        System.out.println("What number is missing in the progression?"); // rules of game

        int counterOfSuccessfulAttempts = 0;
        Random random = new Random();
        int minLength = 5;

        while (counterOfSuccessfulAttempts < 3) {
            int lengthOfArray = random.nextInt(6) + minLength; //will return random length from 5 to 10
            int randomGap = random.nextInt(lengthOfArray); //will return random number of gap from 0 to length of array
            int randomStepOfProgression = random.nextInt(10) + 1; // return the first random step for
                                                                         // progression from 1 to 10
            int firstNumber = random.nextInt(10) + 1; //will return the first random number from 1 to 10

            String[] arrayOfNums = new String[lengthOfArray]; //massive of random numbers
            String trueAnswer = "";

            // fill each element with a random number from 0 to 99
            for (int counter = 0; counter < lengthOfArray; counter++) {
                if (counter == randomGap) {
                    arrayOfNums[counter] = String.valueOf(firstNumber);
                    firstNumber += randomStepOfProgression;
                    trueAnswer = arrayOfNums[counter];
                    arrayOfNums[counter] = "..";
                } else {
                    arrayOfNums[counter] = String.valueOf(firstNumber);
                    firstNumber += randomStepOfProgression;
                }
            }

            String str = String.join(" ", arrayOfNums);
            System.out.println("Question: " + str);

            Scanner scanner = new Scanner(System.in);
            String answerOfUser = scanner.next();
            System.out.println("Your answer: " + answerOfUser);

            //checking the player's answer
            counterOfSuccessfulAttempts = Engine.checkingForCorrectness(newUserName, answerOfUser, trueAnswer,
                    counterOfSuccessfulAttempts);

            // congratulating the player when he wins
            Engine.checkingTheResultOfGame(newUserName, counterOfSuccessfulAttempts);
        }
    }
}
