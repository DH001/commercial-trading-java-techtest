package com.global.commtech.test.anagramfinder;

import com.global.commtech.test.anagramfinder.strategy.AnagramStrategy;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AnagramFinderService {
    private static final String WORD_DELIM = ",";

    private final String newline = System.lineSeparator();

    private final AnagramStrategy strategy;

    public AnagramFinderService(AnagramStrategy strategy) {
        this.strategy = strategy;
    }

    public void findAnagrams(Path filePath) {
        log.info("Calculating anagrams from file: {}", filePath.toAbsolutePath());
        try (WordFetcher processor = new WordFetcher(filePath)) {
            Optional<Set<String>> batch;

            while ((batch = processor.getWords()).isPresent()) {
                Set<String> words = batch.get();

                // Formats result into comma separated lines
                String answer = strategy.findAnagrams(words)
                        .stream()
                        .map(l -> String.join(WORD_DELIM, l))
                        .collect(Collectors.joining(newline));
                System.out.println(answer);
            }
            log.info("Finished calculating anagrams");
        } catch (IOException e) {
            log.error("Failed with error: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
