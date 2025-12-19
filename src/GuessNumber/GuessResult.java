package GuessNumber;

public class GuessResult {
    public final Outcome outcome;
    public final String message;

    public GuessResult(Outcome outcome, String message) {
        this.outcome = outcome;
        this.message = message;
    }
}