import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Collections.frequency;
import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WordFrequencyGame {

    public String getResult(String sentence) {
        List<WordFrequency> wordFrequencyList = extractWordFrequencies(sentence);
        wordFrequencyList.sort(reverseOrder(comparingInt(WordFrequency::getWordCount)));

        return buildWordFrequencyLines(wordFrequencyList);
    }

    private String buildWordFrequencyLines(List<WordFrequency> wordFrequencyList) {
        String newLine = "\n";
        return wordFrequencyList.stream()
                .map(WordFrequency::getWordFrequencyLine)
                .collect(joining(newLine));
    }

    private List<WordFrequency> extractWordFrequencies(String sentence) {
        String regexSpace = "\\s+";
        List<String> wordList = asList(sentence.split(regexSpace));
        Set<String> wordSet = new HashSet<>(wordList);

        return wordSet.stream()
                .map(word -> new WordFrequency(word, frequency(wordList, word)))
                .collect(toList());
    }
}
