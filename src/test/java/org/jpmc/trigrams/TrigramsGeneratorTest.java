package org.jpmc.trigrams;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TrigramsGeneratorTest {

    private TrigramTextGenerator trigramTextGenerator = Mockito.mock(TrigramTextGenerator.class);

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInputIsNull() {
        //Given
        String input = null;

        //When
        TrigramsGenerator trigramsGenerator = new TrigramsGenerator(input, trigramTextGenerator);

        //Then
        fail("should have thrown IllegalArgumentException");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInputSizeIsInvalid() {
        //Given
        String input = "12";

        //When
        TrigramsGenerator trigramsGenerator = new TrigramsGenerator(input, trigramTextGenerator);

        //Then
        fail("should have thrown IllegalArgumentException");
    }

    @Test
    public void shouldGenerateTrigramsWhenInputIsValid() {
        //Given
        String input = "I wish I may I wish I might";
        TrigramsGenerator trigramsGenerator = new TrigramsGenerator(input, trigramTextGenerator);

        //When
        Map<String, List<String>> trigrams = trigramsGenerator.getTrigrams();

        //Then
        assertEquals(4, trigrams.size());

        assertTrue(trigrams.containsKey("I wish"));
        assertTrue(trigrams.containsKey("wish I"));
        assertTrue(trigrams.containsKey("may I"));
        assertTrue(trigrams.containsKey("I may"));

        TrigramTextGenerator trigramTextGenerator = new TrigramTextGeneratorImpl(trigrams, new RandomNumberProviderImpl());
        System.out.println(trigramTextGenerator.generateText());
        System.out.println(trigramTextGenerator.generateText());
        System.out.println(trigramTextGenerator.generateText());
        System.out.println(trigramTextGenerator.generateText());
        System.out.println(trigramTextGenerator.generateText());
        System.out.println(trigramTextGenerator.generateText());
        System.out.println(trigramTextGenerator.generateText());
        System.out.println(trigramTextGenerator.generateText());
    }
}