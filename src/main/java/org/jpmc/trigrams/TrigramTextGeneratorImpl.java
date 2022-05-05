package org.jpmc.trigrams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrigramTextGeneratorImpl implements TrigramTextGenerator {

    private final Map<String, List<String>> trigrams;
    private final RandomNumberProvider randomNumberProvider;

    public TrigramTextGeneratorImpl(Map<String, List<String>> trigrams, RandomNumberProvider randomNumberProvider) {
        this.trigrams = trigrams;
        this.randomNumberProvider = randomNumberProvider;
    }

    public String generateText() {
        if(trigrams == null || trigrams.isEmpty()) {
            return null;
        }
        List<String> keys = new ArrayList<>(trigrams.keySet());
        String key = keys.get(randomNumberProvider.randomInt(keys.size()));
        List<String> keysTaken = new ArrayList<>();
        StringBuilder sentence = new StringBuilder(key);

        while (!keysTaken.contains(key) && trigrams.containsKey(key)) {
            keysTaken.add(key);
            List<String> words = trigrams.get(key);
            String word = words.get(randomNumberProvider.randomInt(words.size()));
            sentence.append(" ").append(word);

            String[] keySplit = key.split(" ");
            if(keySplit != null && keySplit.length == 2) {
                key = keySplit[1] + " " + word;
            }else {
                break;
            }
        }
        return sentence.toString();
    }


}
