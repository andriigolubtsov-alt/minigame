package GuessNumber;

import java.util.Scanner;

public class GuessTheNumberApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        SecretNumberProvider provider = new RandomSecretNumberProvider(1, 100);

        System.out.println("Guess the number (1..100). Type 'exit' to quit.");

        while (true) {
            int secret = provider.nextSecret();
            GameEngine engine = new GameEngine(secret);

            System.out.println("\nNew game started. Possible range: [1..100]");

            while (!engine.isFinished()) {
                System.out.print("Your guess: ");
                String s = in.nextLine().trim();

                if (s.equalsIgnoreCase("exit")) {
                    System.out.println("Bye!");
                    return;
                }

                int guess;
                try {
                    guess = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter an integer in [1..100].");
                    continue;
                }

                GuessResult r = engine.processGuess(guess);
                System.out.println(r.message);
            }

            System.out.print("Play again? (y/n): ");
            String again = in.nextLine().trim();
            if (!again.equalsIgnoreCase("y")) {
                System.out.println("Bye!");
                return;
            }
        }
    }
}