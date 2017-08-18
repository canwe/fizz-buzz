package software.works.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static testasyouthink.TestAsYouThink.resultOf;

public class FizzBuzzWordsPrintedNTimesTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz().wordsNTimes();
    }

    @Test
    public void should_get_number_given_1_as_number() {
        resultOf(() -> fizzBuzz.of(1)).isEqualTo("1");
    }

    @Test
    public void should_get_fizzfizz_given_9_as_number() {
        resultOf(() -> fizzBuzz
                .whenNumberHasFactors()
                .of(9)).isEqualTo("FizzFizz");
    }

    @Test
    public void should_get_fizzfizz_given_331_as_number() {
        resultOf(() -> fizzBuzz
                .whenNumberContainsDigits()
                .of(331)).isEqualTo("FizzFizz");
    }

    @Test
    public void should_get_fizzfizzfizz_given_33_as_number() {
        resultOf(() -> fizzBuzz
                .whenNumberHasFactors()
                .whenNumberContainsDigits()
                .of(33)).isEqualTo("FizzFizzFizz");
    }

    @Test
    public void should_get_fizzfizzbuzzbuzzbuzz_given_3355_as_number() {
        resultOf(() -> fizzBuzz
                .whenNumberHasFactors()
                .whenNumberContainsDigits()
                .of(3355)).isEqualTo("FizzFizzBuzzBuzzBuzz");
    }

    @Test
    public void should_fizz_or_buzz_given_some_arbitrary_numbers() {
        resultOf(() -> fizzBuzz
                .whenNumberHasFactors()
                .whenNumberContainsDigits()
                .of(1, 3, 5)).isEqualTo("1 FizzFizz BuzzBuzz");
    }

    @Test
    public void should_fizz_or_buzz_given_a_range_of_numbers() {
        resultOf(() -> fizzBuzz
                .whenNumberHasFactors()
                .whenNumberContainsDigits()
                .from(1)
                .to(15)).isEqualTo("1 2 FizzFizz 4 BuzzBuzz Fizz 7 8 FizzFizz Buzz 11 Fizz Fizz 14 FizzBuzzBuzz");
    }
}