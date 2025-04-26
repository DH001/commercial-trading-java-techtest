package com.global.commtech.test.anagramfinder.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class SortedStringAnagramStrategyTest {
    private final String newline = System.lineSeparator();
    private final SortedStringAnagramStrategy strategy = new SortedStringAnagramStrategy();

    @Test
    public void findAnagrams_return2Anagrams() {
        Set<String> words = new LinkedHashSet<>(Arrays.asList("dog", "cat", "god", "ate", "tea"));
        assertEquals(
                String.format("ate,tea%scat%sdog,god", newline, newline),
                strategy.findAnagrams(words)
        );
    }

    @Test
    public void findAnagrams_returnNoAnagrams() {
        Set<String> words = new LinkedHashSet<>(Arrays.asList("mat", "cat", "ate"));
        assertEquals(
                String.format("ate%scat%smat", newline, newline),
                strategy.findAnagrams(words)
        );
    }

    @Test
    public void findAnagrams_emptyWordList_returnEmptyString() {
        assertEquals("", strategy.findAnagrams(Collections.emptySet()));
    }

    @Test
    public void findAnagrams_nullWordList_returnEmptyString() {
        assertEquals("", strategy.findAnagrams(null));
    }

    @Test
    public void findAnagrams_ignoreDuplicates() {
        Set<String> words = new LinkedHashSet<>(Arrays.asList("ate", "tea", "ate", "ate", "tea"));
        assertEquals(
                "ate,tea",
                strategy.findAnagrams(words)
        );
    }
}