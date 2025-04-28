package com.global.commtech.test.anagramfinder.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static java.util.Arrays.asList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class SortedStringAnagramStrategyTest {
    private final SortedStringAnagramStrategy strategy = new SortedStringAnagramStrategy();

    @Test
    public void findAnagrams_return2Anagrams() {
        Set<String> words = new LinkedHashSet<>(asList("dog", "cat", "god", "ate", "tea"));
        assertEquals(
                asList(
                        asList("dog", "god"),
                        List.of("cat"),
                        asList("ate", "tea")
                ),
                strategy.findAnagrams(words)
        );
    }

    @Test
    public void findAnagrams_returnNoAnagrams() {
        Set<String> words = new LinkedHashSet<>(asList("mat", "cat", "ate"));
        assertEquals(
                asList(
                        List.of("mat"),
                        List.of("cat"),
                        List.of("ate")
                ),
                strategy.findAnagrams(words)
        );
    }

    @Test
    public void findAnagrams_emptyWordList_returnEmptyString() {
        assertEquals(Collections.emptyList(), strategy.findAnagrams(Collections.emptySet()));
    }

    @Test
    public void findAnagrams_nullWordList_returnEmptyString() {
        assertEquals(Collections.emptyList(), strategy.findAnagrams(null));
    }

    @Test
    public void findAnagrams_ignoreDuplicates() {
        Set<String> words = new LinkedHashSet<>(asList("ate", "tea", "ate", "ate", "tea"));
        assertEquals(
                List.of(List.of("ate", "tea")),
                strategy.findAnagrams(words)
        );
    }
}