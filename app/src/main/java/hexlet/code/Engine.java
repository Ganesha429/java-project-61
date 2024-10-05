package hexlet.code;
import java.util.Scanner;


public class Engine {
    // greeting the player and getting his name
    public static String getName() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");

        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        return userName;
    }

    // checking the correctness of the entered answer from the player
    public static int checkingForCorrectness(String newUserName, String answerOfUser, String trueResult,
                                int counterOfSuccessfulAttempts) {
        if (answerOfUser.equalsIgnoreCase(trueResult)) {
            System.out.println("Correct!");
            counterOfSuccessfulAttempts += 1;
        } else {
            System.out.println("\"" + answerOfUser + "\"" + " is wrong answer ;(. Correct answer was '"
                    + trueResult + "'.\n"
                    + "Let's try again, " + newUserName + "!");
            counterOfSuccessfulAttempts = 5;
        }

        return counterOfSuccessfulAttempts;
    }

    // in order to win, the player must answer correctly 3 times in a row
    public static void checkingTheResultOfGame(String newUserName, int counterOfSuccessfulAttempts) {
        if (counterOfSuccessfulAttempts == 3) {
            System.out.println("Congratulations, " + newUserName + "!");
        }
    }
}
