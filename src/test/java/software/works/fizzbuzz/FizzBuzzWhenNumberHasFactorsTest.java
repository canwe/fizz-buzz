package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzWhenNumberHasFactorsTest {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZ_BUZZ = "FizzBuzz";

    private FizzBuzz fizzBuzz;

    @Before
    public void prepareFixtures() {
        fizzBuzz = new FizzBuzz().whenNumberHasFactors();
    }

    @Test
    public void should_get_number_given_not_multiple_of_3_or_5() {
        assertThat(fizzBuzz.of(1)).isEqualTo(String.valueOf(1));
    }

    @Test
    public void should_get_fizz_given_3_as_number() {
        assertThat(fizzBuzz.of(3)).isEqualTo(FIZZ);
    }

    @Test
    public void should_get_fizz_given_number_multiple_of_3() {
        assertThat(fizzBuzz.of(6)).isEqualTo(FIZZ);
    }

    @Test
    public void should_get_buzz_given_5_as_number() {
        assertThat(fizzBuzz.of(5)).isEqualTo(BUZZ);
    }

    @Test
    public void should_get_buzz_given_number_multiple_of_5() {
        assertThat(fizzBuzz.of(10)).isEqualTo(BUZZ);
    }

    @Test
    public void should_get_fizzbuzz_given_15_as_number() {
        assertThat(fizzBuzz.of(15)).isEqualTo(FIZZ_BUZZ);
    }

    @Test
    public void should_get_fizzbuzz_given_number_multiple_of_3_and_5() {
        assertThat(fizzBuzz.of(45)).isEqualTo(FIZZ_BUZZ);
    }

    @Test
    public void should_get_fizz_or_buzz_given_several_numbers() {
        assertThat(fizzBuzz.of(3, 5, 15)).isEqualTo("Fizz Buzz FizzBuzz");
    }

    @Test
    public void should_get_fizz_and_buzz_and_fizzbuzz_and_numbers_given_a_range_of_numbers() {
        assertThat(fizzBuzz.from(1).to(15)).isEqualTo("1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz");
    }

    @Test
    public void should_get_the_same_result() {
        // GIVEN
        int start = 1, end = 100;
        String fizzBuzzResultByDefault = new FizzBuzz().from(start).to(end);

        // WHEN-THEN
        assertThat(fizzBuzz.from(start).to(end)).isEqualTo(fizzBuzzResultByDefault);
    }
}