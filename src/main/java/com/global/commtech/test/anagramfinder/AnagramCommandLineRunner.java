package com.global.commtech.test.anagramfinder;

import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class AnagramCommandLineRunner implements CommandLineRunner {

    private final AnagramFinderService anagramFinderService;

    @Autowired
    public AnagramCommandLineRunner(AnagramFinderService anagramFinderService) {
        this.anagramFinderService = anagramFinderService;
    }

    @Override
    public void run(final String... args) throws Exception {
        Assert.isTrue(args.length == 1, "Please ensure that the input file is provided");

        Path filePath = Path.of(args[0]);
        Assert.isTrue(Files.exists(filePath), args[0] + " Does not exist");

        anagramFinderService.findAnagrams(filePath);
    }
}
