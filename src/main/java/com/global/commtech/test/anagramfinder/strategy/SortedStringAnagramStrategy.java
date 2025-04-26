package com.global.commtech.test.anagramfinder.strategy;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Finds anagrams using a simple strategy of sorting the words by character
 * so they can be compared easily
 */
@Component
public class SortedStringAnagramStrategy implements AnagramStrategy {
    private static final String WORD_DELIM = ",";

    private final String newline = System.lineSeparator();

    /**
     * For given set of words it will find and group the anagrams on separate comma separated lines
     * No guaranteed order in results unless you pass an ordered set.
     * @param words Set of words of the same length
     * @return A string of comma separated anagrams with each new group of anagrams on a newline or empty string if no words passed in
     */
    @Override
    public String findAnagrams(Set<String> words) {
        if (words==null || words.isEmpty()) {
            return "";
        }
        MultiValueMap<String, String> anagrams = new LinkedMultiValueMap<>();

        words.forEach(word -> anagrams.add(sortString(word), word));

        return anagrams.values().stream()
                .map(l -> String.join(WORD_DELIM, l))
                .sorted()
                .collect(Collectors.joining(newline));
    }

    private String sortString(String input) {
        return input.chars()
                .sorted()
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

}
