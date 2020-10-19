import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static java.lang.String.format;

public class WordFrequencyGame {

    public final String REGEX_SPACE = "\\s+";
    public final String NEW_LINE = "\n";

    public String getResult(String inputStr) {
        try {

            String[] words = inputStr.split(REGEX_SPACE);

            List<WordFrequency> wordFrequencyList = new ArrayList<>();
            for (String word : words) {
                WordFrequency wordFrequency = new WordFrequency(word, 1);
                wordFrequencyList.add(wordFrequency);
            }

            Map<String, List<WordFrequency>> map = getListMap(wordFrequencyList);

            List<WordFrequency> list = new ArrayList<>();
            for (Map.Entry<String, List<WordFrequency>> entry : map.entrySet()) {
                WordFrequency wordFrequency = new WordFrequency(entry.getKey(), entry.getValue().size());
                list.add(wordFrequency);
            }
            wordFrequencyList = list;

            wordFrequencyList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());

            StringJoiner joiner = new StringJoiner(NEW_LINE);
            for (WordFrequency wordFrequency : wordFrequencyList) {
                String wordFrequencyLine = format("%s %d", wordFrequency.getWord(), wordFrequency.getWordCount());
                joiner.add(wordFrequencyLine);
            }

            return joiner.toString();
        } catch (Exception e) {


            return "Calculate Error";
        }
    }


    private Map<String, List<WordFrequency>> getListMap(List<WordFrequency> wordFrequencyList) {
        Map<String, List<WordFrequency>> wordFrequencyMap = new HashMap<>();
        for (WordFrequency wordFrequency : wordFrequencyList) {
            if (!wordFrequencyMap.containsKey(wordFrequency.getWord())) {
                ArrayList arr = new ArrayList<>();
                arr.add(wordFrequency);
                wordFrequencyMap.put(wordFrequency.getWord(), arr);
            } else {
                wordFrequencyMap.get(wordFrequency.getWord()).add(wordFrequency);
            }
        }


        return wordFrequencyMap;
    }


}
