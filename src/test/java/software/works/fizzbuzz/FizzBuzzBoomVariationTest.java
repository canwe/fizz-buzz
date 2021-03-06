package software.works.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzBoomVariationTest {

    private FizzBuzz fizzBuzzBoom;

    @Before
    public void prepareFixtures() {
        fizzBuzzBoom = new FizzBuzz().boom();
    }

    @Test
    public void should_get_fizz_given_3_as_number() {
        assertThat(fizzBuzzBoom.of(3)).isEqualTo("Fizz");
    }

    @Test
    public void should_get_buzz_given_5_as_number() {
        assertThat(fizzBuzzBoom.of(5)).isEqualTo("Buzz");
    }

    @Test
    public void should_get_boom_given_7_as_number() {
        assertThat(fizzBuzzBoom.of(7)).isEqualTo("Boom");
    }

    @Test
    public void should_get_fizzbuzzboom_given_7539() {
        assertThat(fizzBuzzBoom.of(7539)).isEqualTo("FizzBuzzBoom");
    }

    @Test
    public void should_get_fizz_buzz_or_boom_given_a_range_of_numbers() {
        assertThat(fizzBuzzBoom.from(1).to(15))
                .isEqualTo("1 2 Fizz 4 Buzz Fizz Boom 8 Fizz Buzz 11 Fizz Fizz Boom FizzBuzz");
    }
}