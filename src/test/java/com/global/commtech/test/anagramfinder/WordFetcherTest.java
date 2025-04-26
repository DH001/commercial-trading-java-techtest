package com.global.commtech.test.anagramfinder;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;

class WordFetcherTest {

    @Test
    void getWords_returnInSetsByLength() throws IOException {
        Path testFile = Paths.get("src","test","resources", "example1.txt");

        try (WordFetcher wordFetcher = new WordFetcher(testFile)) { // Try is so resource is auto-closed
            assertEquals(Sets.newSet("abc", "fun", "bac", "cba", "unf"), wordFetcher.getWords().orElse(null));
            assertEquals(Sets.newSet("hello"), wordFetcher.getWords().orElse(null));
            assertTrue(wordFetcher.getWords().isEmpty());
        }
    }

    @Test
    void getWords_handleEmptyFile() throws IOException {
        Path testFile = Paths.get("src","test","resources", "empty.txt");

        try (WordFetcher wordFetcher = new WordFetcher(testFile)) { // Try is so resource is auto-closed
            assertTrue(wordFetcher.getWords().isEmpty());
        }
    }
}