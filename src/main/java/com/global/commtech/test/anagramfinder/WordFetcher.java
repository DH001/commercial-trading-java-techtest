package com.global.commtech.test.anagramfinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Utility class to fetch batches of words of the same length from provided file.
 * Note: Words in the input file must be ordered by size.
 * Each new batch will be fetched on demand to avoid holding whole file in memory.
 */
public class WordFetcher implements AutoCloseable {
    private final BufferedReader reader;
    private String nextWord;

    public WordFetcher(Path filePath) throws IOException {
        this.reader = Files.newBufferedReader(filePath);
        nextWord = getNextWord();
    }

    /**
     * Returns the next batch of words that have the same length.
     * Returns an empty Optional when the end of file is reached.
     */
    public Optional<Set<String>> getWords() throws IOException {
        if (nextWord == null) {
            return Optional.empty(); // End of file reached
        }

        Set<String> batch = new LinkedHashSet<>();
        int currentLength = nextWord.length();

        // Iterates until it finds word of different length or reaches the end of file
        do {
            batch.add(nextWord);
            nextWord = getNextWord();
        } while (nextWord != null && nextWord.length() == currentLength);

        return Optional.of(batch);
    }

    @Override
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    private String getNextWord() throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty()) {
                return line;
            }
        }
        return null;
    }

}

