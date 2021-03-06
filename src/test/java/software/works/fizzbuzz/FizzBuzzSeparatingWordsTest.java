package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzSeparatingWordsTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_get_fizzbuzz_given_comma_as_separator() {
        assertThat(fizzBuzz.separatedBy(", ").of(3, 5)).isEqualTo("Fizz, Buzz");
    }

    @Test
    public void should_get_fizzbuzz_given_comma_as_predefined_separator() {
        assertThat(fizzBuzz.separatedByComma().of(3, 5)).isEqualTo("Fizz, Buzz");
    }

    @Test
    public void should_get_fizzbuzz_given_semicolon_as_predefined_separator() {
        assertThat(fizzBuzz.separatedBySemiColon().of(3, 5)).isEqualTo("Fizz; Buzz");
    }

    @Test
    public void should_get_fizzbuzz_given_french_semicolon_as_predefined_separator() {
        assertThat(fizzBuzz.separatedByFrenchSemiColon().of(3, 5)).isEqualTo("Fizz ; Buzz");
    }

    @Test
    public void should_get_fizzbuzz_given_line_feed_as_predefined_separator() {
        assertThat(fizzBuzz.separatedByLineFeed().of(3, 5)).isEqualTo("Fizz\nBuzz");
    }

    @Test
    public void should_get_fizzbuzz_given_slash_as_predefined_separator() {
        assertThat(fizzBuzz.separatedBySlash().of(3, 5)).isEqualTo("Fizz / Buzz");
    }

    @Test
    public void should_get_fizzbuzz_given_backslash_as_predefined_separator() {
        assertThat(fizzBuzz.separatedByBackslash().of(3, 5)).isEqualTo("Fizz \\ Buzz");
    }

    @Test
    public void should_get_fizzbuzz_given_dash_as_predefined_separator() {
        assertThat(fizzBuzz.separatedByDash().of(3, 5)).isEqualTo("Fizz - Buzz");
    }

    @Test
    public void should_get_fizzbuzz_given_punctuation_as_punctuation() {
        assertThat(fizzBuzz.punctuatedBy("!").of(3, 5)).isEqualTo("Fizz! Buzz!");
    }

    @Test
    public void should_get_fizzbuzz_given_exclamation_mark_as_predefined_punctuation() {
        assertThat(fizzBuzz.punctuatedByExclamationMark().of(3, 5)).isEqualTo("Fizz! Buzz!");
    }

    @Test
    public void should_get_fizzbuzz_given_french_exclamation_mark_as_predefined_punctuation() {
        assertThat(fizzBuzz.punctuatedByFrenchExclamationMark().of(3, 5)).isEqualTo("Fizz ! Buzz !");
    }

    @Test
    public void should_get_fizzbuzz_given_full_stop_mark_as_predefined_punctuation() {
        assertThat(fizzBuzz.punctuatedByFullStop().of(3, 5)).isEqualTo("Fizz. Buzz.");
    }

    @Test
    public void should_get_fizzbuzz_given_period_as_predefined_punctuation() {
        assertThat(fizzBuzz.punctuatedByPeriod().of(3, 5)).isEqualTo("Fizz. Buzz.");
    }

    @Test
    public void should_get_numbers_between_brackets_after_words_given_a_range_of_numbers() {
        assertThat(fizzBuzz.withNumbers().from(1).to(5)).isEqualTo("1 2 Fizz (3) 4 Buzz (5)");
    }

    @Test
    public void should_get_numbers_between_brackets_after_words_separated_by_comma_given_a_range_of_numbers() {
        assertThat(fizzBuzz.withNumbers().separatedByComma().from(1).to(5)).isEqualTo("1, 2, Fizz (3), 4, Buzz (5)");
    }
}