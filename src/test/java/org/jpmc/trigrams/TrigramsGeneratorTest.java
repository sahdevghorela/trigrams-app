package org.jpmc.trigrams;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrigramsGeneratorTest {

    @Test
    public void shouldLoadTrigramsGeneratorClass() {
        //Given
        TrigramsGenerator trigramsGenerator = new TrigramsGenerator();

        //Then
        assertNotNull(trigramsGenerator);
    }
}