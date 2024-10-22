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
            String[] progression = generateProgression(random);
            String correctAnswer = progression[progression.length - 1];
            progression[progression.length - 1] = "..";

            askQuestion(progression);
            String userAnswer = getUserAnswer(scanner);

            successfulAttempts = Engine.checkingForCorrectness(userName, userAnswer, correctAnswer, successfulAttempts);
            Engine.checkingTheResultOfGame(userName, successfulAttempts);
        }
    }

    private static String[] generateProgression(Random random) {
        int length = random.nextInt(6) + 5;
        int gapIndex = random.nextInt(length);
        int step = random.nextInt(10) + 1;
        int start = random.nextInt(10) + 1;

        String[] progression = new String[length + 1];
        for (int i = 0; i < length; i++, start += step) {
            if (i == gapIndex) {
                progression[length] = String.valueOf(start); // Store correct answer at the end
                progression[i] = "..";
            } else {
                progression[i] = String.valueOf(start);
            }
        }
        return progression;
    }

    private static void askQuestion(String[] progression) {
        System.out.println("Question: " + String.join(" ", progression));
    }

    private static String getUserAnswer(Scanner scanner) {
        System.out.print("Your answer: ");
        return scanner.next();
    }
}



