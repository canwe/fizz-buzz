package software.works.fizzbuzz;

import java.util.Optional;
import java.util.stream.IntStream;

import software.works.fizzbuzz.rule.PlayerBuilder;

class TheMostFizzyBuzzyWord {

    private FizzBuzzFinder finder;
    private int start;

    TheMostFizzyBuzzyWord(PlayerBuilder playerBuilder) {
        finder = new FizzBuzzFinder(playerBuilder);
    }

    public Optional<String> in(int... values) {
        Optional<FizzbuzzifiedNumber> theMostFizzbuzzified = finder.find(values);
        return theMostFizzbuzzified.isPresent() ? Optional.of(theMostFizzbuzzified.get().getFizzbuzzified())
                : Optional.empty();
    }

    public TheMostFizzyBuzzyWord from(int start) {
        this.start = start;
        return this;
    }

    public Optional<String> to(int end) {
        return in(IntStream.rangeClosed(start, end).toArray());
    }
}