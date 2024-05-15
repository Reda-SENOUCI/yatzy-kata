package org.codingdojo.yatzy1;

import org.codingdojo.Dice;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Yatzy1 {

    private List<Dice> dices; //

    private Yatzy1(int d1, int d2, int d3, int d4, int d5) {
        // Make the list immutable
        this.dices = List.of(
            new Dice(d1),
            new Dice(d2),
            new Dice(d3),
            new Dice(d4),
            new Dice(d5));
    }

    public static Yatzy1 Create(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy1(d1, d2, d3, d4, d5);
    }


    public int calculateOnes() {
        return this.dices.stream()
            .filter(Dice::isOne)
            .mapToInt(Dice::getValue)
            .sum();
    }

    public int calculateTwos() {
        return this.dices.stream()
            .filter(Dice::isTwo)
            .mapToInt(Dice::getValue)
            .sum();

    }

    public int calculateThrees() {
        return this.dices.stream()
            .filter(Dice::isThree)
            .mapToInt(Dice::getValue)
            .sum();
    }

    public int calculateFours() {
        return this.dices.stream()
            .filter(Dice::isFour)
            .mapToInt(Dice::getValue)
            .sum();
    }

    public int calculateFives() {
        return this.dices.stream()
            .filter(Dice::isFive)
            .mapToInt(Dice::getValue)
            .sum();
    }

    public int calculateSixes() {
        return this.dices.stream()
            .filter(Dice::isSix)
            .mapToInt(Dice::getValue)
            .sum();
    }

    public int calculatePairs() {
        Map<Integer, Long> valueCounts = countDiceGroups();

        return valueCounts.entrySet().stream()
            .filter(entry -> entry.getValue() >= 2)
            .mapToInt(entry -> entry.getKey() * 2)
            .max()
            .orElse(0);
    }


    public int calculateTwoPairs() {
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

    public int calculateThreeKinds() {
        Map<Integer, Long> valueCounts = countDiceGroups();

        return valueCounts.entrySet().stream()
            .filter(entry -> entry.getValue() >= 3)
            .mapToInt(entry -> entry.getKey() * 3)
            .sum();
    }


    public int calculateFourKinds() {
        Map<Integer, Long> valueCounts = countDiceGroups();

        return valueCounts.entrySet().stream()
            .filter(entry -> entry.getValue() >= 4)
            .mapToInt(entry -> entry.getKey() * 4)
            .sum();
    }


    public int calculateSmallStraight() {
        var sortedDices = this.dices.stream().map(Dice::getValue).sorted().toList();
        return List.of(1, 2, 3, 4, 5).equals(sortedDices) ? 15 : 0;
    }


    public int calculateLargeStraight() {
        var sortedDices = this.dices.stream().map(Dice::getValue).sorted().toList();
        return List.of(2, 3, 4, 5, 6).equals(sortedDices) ? 20 : 0;
    }

    public int calculateFullHouse() {
        var threeKinds = this.calculateThreeKinds();
        var pair = this.calculatePairs();
        return threeKinds > 0 && pair > 0 ? threeKinds + pair : 0;

    }

    public int calculateChance() {
        return this.dices.stream().mapToInt(Dice::getValue).sum();
    }

    public int calculateYatzy() {
        Map<Integer, Long> valueCounts = countDiceGroups();
        return valueCounts.size() == 1 ? 50 : 0;
    }

    private Map<Integer, Long> countDiceGroups() {
        Map<Integer, Long> valueCounts = this.dices.stream()
            .collect(Collectors.groupingBy(Dice::getValue, Collectors.counting()));
        return valueCounts;
    }

}



