package software.works.fizzbuzz;

import java.util.Optional;
import java.util.stream.IntStream;

import software.works.fizzbuzz.rule.PlayerBuilder;

class TheMostFizzyBuzzy {

    private FizzBuzzFinder finder;
    private int start;
    private Optional<FizzbuzzifiedNumber> theMostFizzyBuzzy;

    TheMostFizzyBuzzy(PlayerBuilder playerBuilder) {
        finder = new FizzBuzzFinder(playerBuilder);
    }

    public TheMostFizzyBuzzy in(int... values) {
        theMostFizzyBuzzy = finder.find(values);
        return this;
    }

    public TheMostFizzyBuzzy from(int start) {
        this.start = start;
        return this;
    }

    public TheMostFizzyBuzzy to(int end) {
        return in(IntStream.rangeClosed(start, end).toArray());
    }

    public Optional<FizzbuzzifiedNumber> get() {
        return theMostFizzyBuzzy;
    }

    public Optional<Integer> asNumber() {
        return theMostFizzyBuzzy.isPresent() ? Optional.of(theMostFizzyBuzzy.get().getNumber())
                : Optional.empty();
    }

    public Optional<String> asWord() {
        return theMostFizzyBuzzy.isPresent() ? Optional.of(theMostFizzyBuzzy.get().getFizzbuzzified())
                : Optional.empty();
    }
}