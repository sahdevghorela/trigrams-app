package org.jpmc.trigrams;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.*;

public class TrigramTextGeneratorImplTest {

    private RandomNumberProvider randomNumberProvider = Mockito.mock(RandomNumberProvider.class);

    @Test
    public void shouldReturnNullWhenInputIsNull() {
        //Given
        Map<String, List<String>> input = null;
        TrigramTextGenerator trigramTextGenerator = new TrigramTextGeneratorImpl(input, randomNumberProvider);

        //When
        String result = trigramTextGenerator.generateText();

        //Then
        assertNull(result);
    }

    @Test
    public void shouldReturnNullWhenInputIsEmpty() {
        //Given
        Map<String, List<String>> input = new HashMap<>();
        TrigramTextGenerator trigramTextGenerator = new TrigramTextGeneratorImpl(input, randomNumberProvider);

        //When
        String result = trigramTextGenerator.generateText();

        //Then
        assertNull(result);
    }

    @Test
    public void shouldGenerateTrigramTextWhenInputIsValid1() {
        //Given
        Map<String, List<String>> inputTrigram = new LinkedHashMap<>();
        inputTrigram.put("I wish", Arrays.asList("I","I"));
        inputTrigram.put("wish I", Arrays.asList("may", "might"));
        inputTrigram.put("may I", Arrays.asList("wish"));
        inputTrigram.put("I may", Arrays.asList("I"));

        Mockito.when(randomNumberProvider.randomInt(Mockito.anyInt()))
                .thenReturn(3)
                .thenReturn(0)
                .thenReturn(0)
                .thenReturn(1)
                .thenReturn(0);

        TrigramTextGenerator trigramTextGenerator = new TrigramTextGeneratorImpl(inputTrigram, randomNumberProvider);

        //When
        String result = trigramTextGenerator.generateText();

        //Then
        assertEquals("I may I wish I may", result);

    }

    @Test
    public void shouldGenerateTrigramTextWhenInputIsValid2() {
        //Given
        Map<String, List<String>> inputTrigram = new LinkedHashMap<>();
        inputTrigram.put("I wish", Arrays.asList("I","I"));
        inputTrigram.put("wish I", Arrays.asList("may", "might"));
        inputTrigram.put("may I", Arrays.asList("wish"));
        inputTrigram.put("I may", Arrays.asList("I"));

        Mockito.when(randomNumberProvider.randomInt(Mockito.anyInt()))
                .thenReturn(3)
                .thenReturn(0)
                .thenReturn(0)
                .thenReturn(1)
                .thenReturn(1);

        TrigramTextGenerator trigramTextGenerator = new TrigramTextGeneratorImpl(inputTrigram, randomNumberProvider);

        //When
        String result = trigramTextGenerator.generateText();

        //Then
        assertEquals("I may I wish I might", result);

    }



}