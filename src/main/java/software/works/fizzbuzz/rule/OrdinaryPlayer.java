package software.works.fizzbuzz.rule;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import software.works.fizzbuzz.Player;

class OrdinaryPlayer implements Player {

    protected List<FizzBuzzFunction> fizzBuzzFunctions;
    private PlayerConfiguration configuration;

    protected OrdinaryPlayer() {}

    OrdinaryPlayer(List<FizzBuzzFunction> fizzBuzzFunctions, PlayerConfiguration configuration) {
        this.fizzBuzzFunctions = fizzBuzzFunctions;
        this.configuration = configuration;
    }

    @Override
    public String playAtFizzBuzz(int value) {
        String fizzBuzz = fizzBuzzFunctions.stream() //
                .map(function -> function.fizzBuzzOf(value)) //
                .collect(joining());

        if (fizzBuzz.isEmpty()) {
            fizzBuzz = String.valueOf(value);
        } else if (configuration.numbersMustBePrinted()) {
            fizzBuzz += " (" + value + ")";
        }
        return fizzBuzz;
    }

    @Override
    public String playAtFizzBuzz(int... values) {
        return IntStream.of(values) //
                .mapToObj(this::playAtFizzBuzz) //
                .collect(joining(configuration.getWordSeparator())) //
                + configuration.getFinalPunctuation();
    }

    @Override
    public List<String> playAtFizzBuzzToList(int... values) {
        return IntStream.of(values) //
                .mapToObj(this::playAtFizzBuzz) //
                .collect(toList());
    }

    List<FizzBuzzFunction> getFizzBuzzFunctions() {
        return Collections.unmodifiableList(fizzBuzzFunctions);
    }

    void setFizzBuzzFunctions(List<FizzBuzzFunction> fizzBuzzFunctions) {
        this.fizzBuzzFunctions = fizzBuzzFunctions;
    }

    void setConfiguration(PlayerConfiguration configuration) {
        this.configuration = configuration;
    }
}