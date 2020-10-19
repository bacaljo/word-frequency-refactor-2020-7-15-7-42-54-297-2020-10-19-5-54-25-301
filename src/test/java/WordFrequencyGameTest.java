import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordFrequencyGameTest {

    @Test
    public void should_get_the_1_when_input_the() {
        //Given
        String inputPhrase = "the";
        String expectResult = "the 1";
        validate_Input_words_process_to_expected_word(inputPhrase, expectResult);
    }

    @Test
    public void should_process_two_words() {
        //Given
        String inputPhrase = "the is";
        String expectResult = "the 1\nis 1";
        validate_Input_words_process_to_expected_word(inputPhrase, expectResult);
    }

    @Test
    public void should_process_two_words_with_special_spaces() {
        //Given
        String inputPhrase = "the      is";
        String expectResult = "the 1\nis 1";
        validate_Input_words_process_to_expected_word(inputPhrase, expectResult);
    }

    @Test
    public void should_process_two_words_with_special_enter() {
        //Given
        String inputPhrase = "the   \n   is";
        String expectResult = "the 1\nis 1";
        validate_Input_words_process_to_expected_word(inputPhrase, expectResult);
    }

    @Test
    public void should_pracess_two_same_words_with_sorted() {
        //Given
        String inputPhrase = "the the is";
        String expectResult = "the 2\nis 1";
        validate_Input_words_process_to_expected_word(inputPhrase, expectResult);
    }

    @Test
    public void should_process_sorted_with_count_descending() {
        //Given
        String inputPhrase = "the is is";
        String expectResult = "is 2\nthe 1";
        validate_Input_words_process_to_expected_word(inputPhrase, expectResult);
    }

    private void validate_Input_words_process_to_expected_word(String inputPhrase, String expectResult) {
        WordFrequencyGame game = new WordFrequencyGame();
        //When
        String result = game.getResult(inputPhrase);
        //Then
        assertEquals(result, expectResult);
    }
}
