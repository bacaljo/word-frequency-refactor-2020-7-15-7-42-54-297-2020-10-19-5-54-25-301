import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Collections.frequency;
import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;

public class WordFrequencyGame {

    public final String REGEX_SPACE = "\\s+";
    public final String NEW_LINE = "\n";

    public String getResult(String sentence) {
        List<WordFrequency> wordFrequencyList = extractWordFrequencies(sentence);
        wordFrequencyList.sort(reverseOrder(comparingInt(WordFrequency::getWordCount)));

        return buildWordFrequencyLines(wordFrequencyList);
    }

    private String buildWordFrequencyLines(List<WordFrequency> wordFrequencyList) {
        return wordFrequencyList.stream()
                .map(WordFrequency::getWordFrequencyLine)
                .collect(joining(NEW_LINE));
    }

    private List<WordFrequency> extractWordFrequencies(String sentence) {
        List<String> wordList = asList(sentence.split(REGEX_SPACE));
        Set<String> wordSet = new HashSet<>(wordList);

        return wordSet.stream()
                .map(word -> new WordFrequency(word, frequency(wordList, word)))
                .collect(Collectors.toList());
    }
}
