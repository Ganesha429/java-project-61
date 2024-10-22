package hexlet.code.games;
import java.util.Scanner;
import java.util.Random;
import hexlet.code.Engine;


public class Progression {
    public static void getProgression(int numOfGame) {
        String userName = Engine.getName(numOfGame); // Greet and get player's name
        int successfulAttempts = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        while (successfulAttempts < 3) {
            int length = random.nextInt(6) + 5; // Random length from 5 to 10
            int gapIndex = random.nextInt(length); // Random gap index
            int step = random.nextInt(10) + 1; // Step from 1 to 10
            int start = random.nextInt(10) + 1; // Start number from 1 to 10

            String[] progression = new String[length];
            String correctAnswer = "";

            for (int i = 0; i < length; i++) {
                if (i == gapIndex) {
                    correctAnswer = String.valueOf(start);
                    progression[i] = "..";
                } else {
                    progression[i] = String.valueOf(start);
                }
                start += step;
            }

            System.out.println("Question: " + String.join(" ", progression));
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            // Check the player's answer
            successfulAttempts = Engine.checkingForCorrectness(userName, userAnswer, correctAnswer, successfulAttempts);

            // Congratulate the player when they win
            Engine.checkingTheResultOfGame(userName, successfulAttempts);
        }
    }
}

