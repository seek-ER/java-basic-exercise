import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrammarExerciseTest {
    GrammarExercise grammarExercise;

    @BeforeEach
    void setUp() {
        grammarExercise = new GrammarExercise();
    }

    @Test
    void should_return_common_words_with_space() {
        //given
        String first = "apple,juice,mother,people,beautiful,apple,dog";
        String second = "cat,baby,smile,good,apple,beautiful,Dog,nice";
        List<String> expected = Arrays.asList("apple", "beautiful", "dog");
        //when
        List<String> result = grammarExercise.findCommonWordsWithSpace(first, second);
        //then
        assertIterableEquals(result, expected);
    }

    @Test
    void should_throw_exception_when_input_has_two_comma() {
        //given
        String first = "apple,,juice,mother,people,beautiful,apple,dog";
        String second = "cat,baby,smile,good,apple,beautiful,Dog,nice";
        //when&then
        assertThrows(RuntimeException.class, () -> {
            grammarExercise.findCommonWordsWithSpace(first, second);
        });
    }

    @Test
    void should_throw_exception_when_input_contains_invalid_symbol() {
        //given
        String first = "apple,juice,mother,people,bea&&utiful,apple,dog";
        String second = "cat,baby,smile,good,apple,bea&&utiful,Dog,nice";
        //when&then
        assertThrows(RuntimeException.class, () -> {
            grammarExercise.findCommonWordsWithSpace(first, second);
        });
    }
}