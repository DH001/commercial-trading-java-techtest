# Anagram Finder
A simple command line utility for finding anagrams in a specified file

## Software required to run this
* Java 17
* Gradle

## Building and Running the tests
```
./gradlew clean build
```

## Running the program
```
./gradlew bootRun --args="example2.txt" 
```
where example2.txt is the text file that we want to search for anagrams.

Output is in the form of comma separated lines of anagrams. Each set of anagrams is on a newline.
A word with no anagrams will appear in a line by itself. Output is written to standard out (so may be piped to a file).

### Assumptions
- The file contains word grouped by order in increasing length in a text file. 
- Non-english characters are not supported. 
- All the words of the same length will be held in memory at the same time (but not the whole file).
- The program uses 'system' newlines for the file. 

### Notes
A single simple implementation has been provided (SortedStringAnagramStrategy) that sorts each word to test for anagrams.
With more time, other implementations could be developed and added to the strategy package.

A separate service class was used to that the application logic can be kept separate from the Spring Framework code.
The Word Fetcher and Anagram strategy are separate classes as they can easily be changed for better implementations in the future without changing the rest of the application. 
