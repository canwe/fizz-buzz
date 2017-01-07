package software.works.fizzbuzz;

import static software.works.fizzbuzz.Values.toBigInteger;
import static software.works.fizzbuzz.Values.toBigIntegerRangeClosed;

import java.math.BigInteger;

public class FizzBuzzRange {

    private Player player;

    FizzBuzzRange(Player player) {
        this.player = player;
    }

    class LongRange {

        private long start;

        LongRange from(long start) {
            this.start = start;
            return this;
        }

        public String to(long end) {
            return player.playAtFizzBuzz(toBigIntegerRangeClosed(start, end));
        }
    }

    class BigIntegerRange {

        private BigInteger start;

        BigIntegerRange from(String start) {
            this.start = toBigInteger(start);
            return this;
        }

        public String to(String end) {
            return player.playAtFizzBuzz(toBigIntegerRangeClosed(start, toBigInteger(end)));
        }
    }
}