import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Collections.frequency;

public class WordFrequencyGame {

    public final String REGEX_SPACE = "\\s+";
    public final String NEW_LINE = "\n";

    public String getResult(String sentence) {
        List<WordFrequency> wordFrequencyList = extractWordFrequencies(sentence);

        wordFrequencyList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());

        StringJoiner joiner = new StringJoiner(NEW_LINE);
        for (WordFrequency wordFrequency : wordFrequencyList) {
            String wordFrequencyLine = format("%s %d", wordFrequency.getWord(), wordFrequency.getWordCount());
            joiner.add(wordFrequencyLine);
        }

        return joiner.toString();
    }

    private List<WordFrequency> extractWordFrequencies(String sentence) {
        List<WordFrequency> wordFrequencyList = new ArrayList<>();
        List<String> wordList = asList(sentence.split(REGEX_SPACE));
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.forEach(word -> wordFrequencyList.add(new WordFrequency(word, frequency(wordList, word))));

        return wordFrequencyList;
    }
}
