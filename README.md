# Anagram Finder
A simple command line utility for finding anagrams in a specified file.
Based on requirements in file: CTE1-Anagram exercise-230425-092613.pdf (using Java 17+).

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

The anagram strategy uses a Set so that duplicates are not passed. The Client can choose whether to use a sorted or unsorted set if they care about consistent order of results.
The anagram strategy returns a lst of lists so that the order of results is consistent for testing. This can then be output in any way client class wants. 

### Complexity 
The implemented sort algorithm should have a time complexity of O(n log (n)) based on the sort of the character array (as per JavaDoc for Arrays.sort()). This will be multiplied by the number of words 
that are processed: O(noWords * n log (n)) for whole file. Space complexity would be the number of words held in memory (i.e. max number of words on the same length in input file) based on the WordFetcher implementation. 

## Future enhancements
With more time available I would have investigated some alternative strategies for calculating the anagrams. 
I would also have refactored the output logic (writing comma-separated lines to standard output) to a separate writer class so it could 
be easily substituted for an alternative (e.g. write to file, json format) without impacting other classes.