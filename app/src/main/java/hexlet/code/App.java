package hexlet.code;
import java.util.Scanner;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Parity;
import hexlet.code.games.Progression;


public class App {
    public static void main(String[] args) {
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                0 - Exit""");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.println("Your choice: " + choice);

        switch (choice) {
            case 1:
                Engine.getName();
                break;
            case 2:
                Parity.getNumber();
                break;
            case 3:
                Calc.getSum();
                break;
            case 4:
                GCD.getGCD();
                break;
            case 5:
                Progression.getProgression();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }

        scanner.close();
    }
}
