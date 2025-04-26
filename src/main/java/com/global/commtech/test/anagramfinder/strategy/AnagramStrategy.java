package com.global.commtech.test.anagramfinder.strategy;

import java.util.Set;

/**
 * A way of calculating anagrams
 */
public interface AnagramStrategy {
    /**
     * For given set of words it will find and group the anagrams on separate comma separated lines
     *
     * @param words Set of words of the same length
     * @return A string of comma separated anagrams with each new group of anagrams on a newline
     */
    String findAnagrams(Set<String> words);
}
