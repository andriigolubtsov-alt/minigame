package GuessNumber;

public class GameEngine {
    private final int secret;
    private int low = 1;
    private int high = 100;
    private int attempts = 0;
    private boolean finished = false;

    public GameEngine(int secret) {
        this.secret = secret;
    }

    public GuessResult processGuess(int guess) {
        if (finished) {
            return new GuessResult(Outcome.INVALID, "Game already finished.");
        }

        if (guess < 1 || guess > 100) {
            return new GuessResult(Outcome.INVALID, "Enter a number in range [1..100].");
        }

        attempts++;

        if (guess < secret) {
            low = Math.max(low, guess + 1);
            return new GuessResult(Outcome.HIGHER, "Higher. Possible range: [" + low + ".." + high + "]");
        } else if (guess > secret) {
            high = Math.min(high, guess - 1);
            return new GuessResult(Outcome.LOWER, "Lower. Possible range: [" + low + ".." + high + "]");
        } else {
            finished = true;
            return new GuessResult(Outcome.CORRECT, "Correct! Attempts: " + attempts);
        }
    }

    public boolean isFinished() { return finished; }
    public int getLow() { return low; }
    public int getHigh() { return high; }
    public int getAttempts() { return attempts; }
}