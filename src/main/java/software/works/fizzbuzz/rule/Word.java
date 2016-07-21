package software.works.fizzbuzz.rule;

import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Word {

    private String word;
    private int property;

    Word(String word, int property) {
        this.word = word;
        this.property = property;
        validate();
    }

    private void validate() {
        if (word == null || word.isEmpty() || property < 0) {
            throw new IllegalStateException("Invalid word: '" + word
                    + "' must be a word associated to a positive integer '" + property + "' as property!");
        }
    }

    FizzBuzzPredicate ifNumberSatisfies(NumberPredicate predicate) {
        return value -> predicate.appliedTo(property).test(value) ? word : "";
    }

    FizzBuzzPredicate ifNumberSatisfies(List<NumberPredicate> numberPredicates) {
        Optional<BiPredicate<Integer, Integer>> merged = numberPredicates.stream() //
                .map(p -> p.getPredicate()) //
                .reduce((result, current) -> result.or(current));
        return this.ifNumberSatisfies(merged.get());
    }

    private FizzBuzzPredicate ifNumberSatisfies(BiPredicate<Integer, Integer> predicate) {
        return value -> predicate.test(value, property) ? word : "";
    }

    FizzBuzzPredicate nTimesIfNumberSatisfies(NumberPredicate numberPredicate) {
        return value -> {
            StringBuilder result = new StringBuilder();

            switch (numberPredicate) {
            case IS_MULTIPLE_OF:
                int remaining = value;
                while (remaining % property == 0) {
                    result.append(word);
                    remaining /= property;
                }
                break;
            case CONTAINS_DIGIT:
                Matcher digitMatcher = Pattern.compile(String.valueOf(property)).matcher(String.valueOf(value));
                while (digitMatcher.find()) {
                    result.append(word);
                }
                break;
            default:
                break;
            }

            return result.toString();
        };

    }

    @Override
    public String toString() {
        return String.format("{word: %s, property: %d}", word, property);
    }
}