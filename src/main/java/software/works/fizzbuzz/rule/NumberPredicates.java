package software.works.fizzbuzz.rule;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

enum NumberPredicates {

    IS_MULTIPLE_OF((value, factor) -> value % factor == 0), //
    CONTAINS_DIGIT((value, digit) -> String.valueOf(value).contains(String.valueOf(digit)));

    private BiPredicate<Integer, Integer> predicate;

    NumberPredicates(BiPredicate<Integer, Integer> predicate) {
        this.predicate = predicate;
    }

    BiPredicate<Integer, Integer> getPredicate() {
        return predicate;
    }

    Predicate<Integer> appliedTo(int property) {
        return value -> getPredicate().test(value, property);
    }
}