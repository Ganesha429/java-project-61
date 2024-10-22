package hexlet.code.games;
import java.util.Scanner;
import java.util.Random;
import hexlet.code.Engine;


public class Progression {
    public static void getProgression(int numOfGame) {
        String userName = Engine.getName(numOfGame);
        int successfulAttempts = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        while (successfulAttempts < 3) {
            int length = random.nextInt(6) + 5;
            int gapIndex = random.nextInt(length);
            int step = random.nextInt(10) + 1;
            int start = random.nextInt(10) + 1;

            String[] progression = new String[length];
            String correctAnswer = "";

            for (int i = 0; i < length; i++, start += step) {
                if (i == gapIndex) {
                    correctAnswer = String.valueOf(start);
                    progression[i] = "..";
                } else {
                    progression[i] = String.valueOf(start);
                }
            }

            System.out.println("Question: " + String.join(" ", progression));
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            successfulAttempts = Engine.checkingForCorrectness(userName, userAnswer, correctAnswer, successfulAttempts);
            Engine.checkingTheResultOfGame(userName, successfulAttempts);
        }
    }
}
