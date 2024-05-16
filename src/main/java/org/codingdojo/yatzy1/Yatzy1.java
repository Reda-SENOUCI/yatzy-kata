package org.codingdojo.yatzy1;

import org.codingdojo.Dice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Objects.requireNonNull;

public class Yatzy1 {

    private final List<Dice> roll;

    private Yatzy1(List<Dice> roll) {
        this.roll = requireNonNull(roll);
    }

    public static Yatzy1 roll(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy1(IntStream.of(d1, d2, d3, d4, d5).mapToObj(Dice::new).toList());

    }


    public int scoreOnes() {
        return sumOfDiceWithValue(1);
    }

    public int scoreTwos() {
        return sumOfDiceWithValue(2);
    }

    public int scoreThrees() {
        return sumOfDiceWithValue(3);
    }

    public int scoreFours() {
        return sumOfDiceWithValue(4);
    }

    public int scoreFives() {
        return sumOfDiceWithValue(5);
    }

    public int scoreSixes() {
        return sumOfDiceWithValue(6);
    }

    public int scorePairs() {
        Map<Integer, Long> valueCounts = countDiceGroups();

        return valueCounts.entrySet().stream()
            .filter(entry -> entry.getValue() >= 2)
            .mapToInt(entry -> entry.getKey() * 2)
            .max()
            .orElse(0);
    }


    public int scoreTwoPairs() {
        Map<Integer, Long> valueCounts = countDiceGroups();

        var groups = valueCounts.entrySet().stream()
            .filter(entry -> entry.getValue() >= 2)
            .toList();

        if (groups.size() == 2) {
            return groups.stream()
                .mapToInt(entry -> entry.getKey() * 2)
                .sum();
        }
        return 0;
    }

    public int scoreThreeKinds() {
        Map<Integer, Long> valueCounts = countDiceGroups();

        return valueCounts.entrySet().stream()
            .filter(entry -> entry.getValue() >= 3)
            .mapToInt(entry -> entry.getKey() * 3)
            .sum();
    }


    public int scoreFourKinds() {
        Map<Integer, Long> valueCounts = countDiceGroups();

        return valueCounts.entrySet().stream()
            .filter(entry -> entry.getValue() >= 4)
            .mapToInt(entry -> entry.getKey() * 4)
            .sum();
    }


    public int scoreSmallStraight() {
        return List.of(1, 2, 3, 4, 5).equals(getSortedDices()) ? 15 : 0;
    }


    public int scoreLargeStraight() {
        return List.of(2, 3, 4, 5, 6).equals(getSortedDices()) ? 20 : 0;
    }

    public int scoreFullHouse() {
        var threeKinds = this.scoreThreeKinds();
        var pair = this.scorePairs();
        return threeKinds > 0 && pair > 0 ? threeKinds + pair : 0;

    }

    public int scoreChance() {
        return this.roll.stream().mapToInt(Dice::getValue).sum();
    }

    public int scoreYatzy() {
        return countDiceGroups().size() == 1 ? 50 : 0;
    }

    private List<Integer> getSortedDices() {
        return this.roll.stream().map(Dice::getValue).sorted().toList();
    }

    private Map<Integer, Long> countDiceGroups() {
        return this.roll.stream()
            .collect(Collectors.groupingBy(Dice::getValue, Collectors.counting()));
    }

    private int sumOfDiceWithValue(int side) {
        return this.roll.stream()
            .filter(dice -> dice.getValue() == side)
            .mapToInt(Dice::getValue)
            .sum();
    }
}



