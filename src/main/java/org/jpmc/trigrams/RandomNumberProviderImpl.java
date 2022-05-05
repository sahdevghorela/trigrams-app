package org.jpmc.trigrams;

import java.util.Random;

public class RandomNumberProviderImpl implements RandomNumberProvider {

    private final Random random = new Random();

    public int randomInt(int size) {
        return random.nextInt(size);
    }
}
