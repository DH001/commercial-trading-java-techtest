package com.global.commtech.test.anagramfinder.strategy;

import java.util.List;
import java.util.Set;

/**
 * A way of calculating anagrams
 */
public interface AnagramStrategy {
    /**
     * For given set of words it will find and group the anagrams on separate comma separated lines
     *
     * @param words Set of words of the same length
     * @return A list of groups containing words that are anagrams of each other.
     */
    List<List<String>> findAnagrams(Set<String> words);
}
