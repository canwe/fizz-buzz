package software.works.fizzbuzz;

import software.works.fizzbuzz.rule.DigitPlayer;
import software.works.fizzbuzz.rule.DivisionPlayer;

public class FizzBuzz {

    private Player player;

    public String of(int value) {
        return player.playAtFizzBuzz(value);
    }

    public FizzBuzzRange from(int start) {
        return new FizzBuzzRange(player).from(start);
    }

    public FizzBuzz whenNumberHasFactors() {
        player = new DivisionPlayer();
        return this;
    }

    public FizzBuzz whenNumberContainsDigits() {
        player = new DigitPlayer();
        return this;
    }
}