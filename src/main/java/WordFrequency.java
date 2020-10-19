import static java.lang.String.format;

public class WordFrequency {
    private final String word;
    private final int frequency;

    public WordFrequency(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public int getWordCount() {
        return this.frequency;
    }

    public String getWordFrequencyLine() {
        return format("%s %d", word, frequency);
    }
}
