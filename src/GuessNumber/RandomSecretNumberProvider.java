package GuessNumber;

import java.util.Random;

public class RandomSecretNumberProvider implements SecretNumberProvider {
    private final int min;
    private final int max;
    private final Random rnd = new Random();

    public RandomSecretNumberProvider(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int nextSecret() {
        return rnd.nextInt(max - min + 1) + min;
    }
}