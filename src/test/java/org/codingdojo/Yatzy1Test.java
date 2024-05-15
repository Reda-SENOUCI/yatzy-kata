package org.codingdojo;

import org.codingdojo.yatzy1.Yatzy1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Yatzy1Test {

    @Test
    public void should_score_ones() {
        assertEquals(1, Yatzy1.Create(1, 2, 3, 4, 5).calculateOnes());
    }

    @Test
    public void should_not_score_ones() {
        assertEquals(0, Yatzy1.Create(6, 2, 2, 4, 5).calculateOnes());
    }

    @Test
    public void should_score_twos() {
        assertEquals(4, Yatzy1.Create(1, 2, 3, 2, 6).calculateTwos());
    }

    @Test
    public void should_not_score_twos() {
        assertEquals(0, Yatzy1.Create(1, 5, 3, 1, 6).calculateTwos());
    }

    @Test
    public void should_score_threes() {
        assertEquals(6, Yatzy1.Create(1, 2, 3, 2, 3).calculateThrees());
    }

    @Test
    public void should_not_score_threes() {
        assertEquals(0, Yatzy1.Create(1, 2, 4, 2, 5).calculateThrees());
    }

    @Test
    public void should_score_fours() {
        assertEquals(12, Yatzy1.Create(4, 4, 4, 5, 5).calculateFours());
    }

    @Test
    public void should_not_score_fours() {
        assertEquals(0, Yatzy1.Create(1, 3, 2, 5, 5).calculateFours());
    }


    @Test
    public void should_score_fives() {
        assertEquals(10, Yatzy1.Create(4, 4, 4, 5, 5).calculateFives());
    }

    @Test
    public void should_not_score_fives() {
        assertEquals(0, Yatzy1.Create(4, 4, 4, 1, 3).calculateFives());
    }

    @Test
    public void should_score_sixes() {
        assertEquals(6, Yatzy1.Create(4, 4, 6, 5, 5).calculateSixes());
    }

    @Test
    public void should_not_score_sixes() {
        assertEquals(0, Yatzy1.Create(4, 4, 4, 5, 5).calculateSixes());
    }

    @Test
    public void should_score_the_highest_matching_pair() {
        assertEquals(6, Yatzy1.Create(3, 4, 3, 5, 6).calculatePairs());
        assertEquals(6, Yatzy1.Create(3, 3, 3, 3, 3).calculatePairs());
        assertEquals(12, Yatzy1.Create(5, 3, 6, 6, 5).calculatePairs());
    }

    @Test
    public void should_not_score_one_pair() {
        assertEquals(0, Yatzy1.Create(3, 4, 1, 5, 6).calculatePairs());
    }


    @Test
    public void should_score_two_pair() {
        assertEquals(16, Yatzy1.Create(3, 3, 5, 4, 5).calculateTwoPairs());
        assertEquals(16, Yatzy1.Create(3, 3, 5, 5, 5).calculateTwoPairs());
    }

    @Test
    public void should_not_score_two_pair() {
        assertEquals(0, Yatzy1.Create(1, 1, 2, 3, 4).calculateTwoPairs());
    }

    @Test
    public void should_score_three_of_a_kind() {
        assertEquals(9, Yatzy1.Create(3, 3, 3, 4, 5).calculateThreeKinds());
        assertEquals(15, Yatzy1.Create(5, 3, 5, 4, 5).calculateThreeKinds());
        assertEquals(9, Yatzy1.Create(3, 3, 3, 3, 5).calculateThreeKinds());
    }

    @Test
    public void should_not_score_three_of_a_kind() {
        assertEquals(0, Yatzy1.Create(3, 3, 1, 4, 5).calculateThreeKinds());
    }

    @Test
    public void should_score_four_of_a_kind() {
        assertEquals(12, Yatzy1.Create(3, 3, 3, 3, 5).calculateFourKinds());
        assertEquals(20, Yatzy1.Create(5, 5, 5, 5, 5).calculateFourKinds());
    }

    @Test
    public void should_not_score_four_of_a_kind() {
        assertEquals(0, Yatzy1.Create(3, 3, 1, 3, 5).calculateFourKinds());
    }

    @Test
    public void should_score_smallStraight() {
        assertEquals(15, Yatzy1.Create(1, 2, 3, 4, 5).calculateSmallStraight());
        assertEquals(15, Yatzy1.Create(2, 3, 4, 5, 1).calculateSmallStraight());
    }

    @Test
    public void should_not_score_smallStraight() {
        assertEquals(0, Yatzy1.Create(1, 2, 2, 4, 5).calculateSmallStraight());
        assertEquals(0, Yatzy1.Create(6, 2, 3, 4, 5).calculateSmallStraight());
    }

    @Test
    public void should_score_largeStraight() {
        assertEquals(20, Yatzy1.Create(6, 2, 3, 4, 5).calculateLargeStraight());
        assertEquals(20, Yatzy1.Create(2, 3, 4, 5, 6).calculateLargeStraight());
    }

    @Test
    public void should_not_score_largeStraight() {
        assertEquals(0, Yatzy1.Create(1, 2, 3, 4, 5).calculateLargeStraight());
        assertEquals(0, Yatzy1.Create(1, 2, 2, 4, 5).calculateLargeStraight());

    }

    @Test
    public void should_score_fullHouse() {
        assertEquals(18, Yatzy1.Create(6, 2, 2, 2, 6).calculateFullHouse());
        assertEquals(0, Yatzy1.Create(2, 3, 4, 5, 6).calculateFullHouse());
    }

    @Test
    public void should_score_chance() {

        assertEquals(15, Yatzy1.Create(1, 2, 3, 4, 5).calculateChance());
    }

    @Test
    public void should_score_yatzy() {
        assertEquals(50, Yatzy1.Create(6, 6, 6, 6, 6).calculateYatzy());
    }

    @Test
    public void should_not_score_yatzy() {
        assertEquals(0, Yatzy1.Create(6, 6, 6, 6, 3).calculateYatzy());
    }

}
