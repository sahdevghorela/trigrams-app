package org.jpmc.trigrams;

import java.util.*;

public class TrigramsGenerator {

    private final Map<String, List<String>> trigrams;
    private final TrigramTextGenerator trigramTextGenerator;

    public TrigramsGenerator(String input, TrigramTextGenerator trigramTextGenerator) {
        this.trigrams = generateTrigram(input);
        this.trigramTextGenerator = trigramTextGenerator;
    }

    private Map<String, List<String>> generateTrigram(String input) {
        if(Objects.isNull(input) || input.trim().equals("")) {
            throw new IllegalArgumentException("Input can not be null or blank");
        }

        List<String> inputWords = Arrays.asList(input.split(" "));
        if(inputWords.size() < 3) {
            throw new IllegalArgumentException("At least 3 input words are required");
        }

        Map<String, List<String>> trigrams = new HashMap<>();

        for(int i = 0; i < inputWords.size()-2 ; i++) {
            String key = inputWords.get(i) + " " + inputWords.get(i + 1);
            if(trigrams.containsKey(key)) {
                trigrams.get(key).add(inputWords.get(i+2));
            } else {
                List<String> values = new ArrayList<>();
                values.add(inputWords.get(i+2));
                trigrams.put(key,values);
            }

        }
        return trigrams;
    }

    public String generateTrigramText() {
        return trigramTextGenerator.generateText();
    }

    public Map<String,List<String>> getTrigrams() {
        return this.trigrams;
    }
}
