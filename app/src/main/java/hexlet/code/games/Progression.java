package hexlet.code.games;
import java.util.Scanner;
import java.util.Random;
import hexlet.code.Engine;


public class Progression {
    public static void getProgression(int numOfGame) {
        String newUserName = Engine.getName(numOfGame); // greeting and receiving the player's name
        int counterOfSuccessfulAttempts = 0;
        Random random = new Random();
        int minLength = 5;

        while (counterOfSuccessfulAttempts < 3) {
            int lengthOfArray = random.nextInt(6) + minLength; //will return random length from 5 to 10
            int randomGap = random.nextInt(lengthOfArray); //will return random number of gap from 0 to length of array
            int randomStepOfProgression = random.nextInt(10) + 1; // return the first random step for
            int firstNumber = random.nextInt(10) + 1; //will return the first random number from 1 to 10
            
            String[] arrayOfNums = new String[lengthOfArray]; //massive of random numbers
            String trueAnswer = "";

            // fill each element with a random number from 0 to 99
            for (int i = 0; i < lengthOfArray; i++) {
                if (i == randomGap) {
                    trueAnswer = arrayOfNums[i];
                    arrayOfNums[i] = "..";
                } else {
                    arrayOfNums[i] = String.valueOf(firstNumber);
                }
                firstNumber += randomStepOfProgression;
            }
            
            System.out.println("Question: " + String.join(" ", arrayOfNums));
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

