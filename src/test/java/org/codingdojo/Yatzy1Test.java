package org.codingdojo;

import org.codingdojo.yatzy1.Yatzy1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Yatzy1Test {

    @Test
    public void should_score_ones() {
        assertEquals(1, Yatzy1.roll(1, 2, 3, 4, 5).scoreOnes());
    }

    @Test
    public void should_not_score_ones() {
        assertEquals(0, Yatzy1.roll(6, 2, 2, 4, 5).scoreOnes());
    }

    @Test
    public void should_score_twos() {
        assertEquals(4, Yatzy1.roll(1, 2, 3, 2, 6).scoreTwos());
    }

    @Test
    public void should_not_score_twos() {
        assertEquals(0, Yatzy1.roll(1, 5, 3, 1, 6).scoreTwos());
    }

    @Test
    public void should_score_threes() {
        assertEquals(6, Yatzy1.roll(1, 2, 3, 2, 3).scoreThrees());
    }

    @Test
    public void should_not_score_threes() {
        assertEquals(0, Yatzy1.roll(1, 2, 4, 2, 5).scoreThrees());
    }

    @Test
    public void should_score_fours() {
        assertEquals(12, Yatzy1.roll(4, 4, 4, 5, 5).scoreFours());
    }

    @Test
    public void should_not_score_fours() {
        assertEquals(0, Yatzy1.roll(1, 3, 2, 5, 5).scoreFours());
    }

    @Test
    public void should_score_fives() {
        assertEquals(10, Yatzy1.roll(4, 4, 4, 5, 5).scoreFives());
    }

    @Test
    public void should_not_score_fives() {
        assertEquals(0, Yatzy1.roll(4, 4, 4, 1, 3).scoreFives());
    }

    @Test
    public void should_score_sixes() {
        assertEquals(6, Yatzy1.roll(4, 4, 6, 5, 5).scoreSixes());
    }

    @Test
    public void should_not_score_sixes() {
        assertEquals(0, Yatzy1.roll(4, 4, 4, 5, 5).scoreSixes());
    }

    @Test
    public void should_score_the_highest_matching_pair() {
        assertEquals(6, Yatzy1.roll(3, 4, 3, 5, 6).scorePairs());
        assertEquals(6, Yatzy1.roll(3, 3, 3, 3, 3).scorePairs());
        assertEquals(12, Yatzy1.roll(5, 3, 6, 6, 5).scorePairs());
    }

    @Test
    public void should_not_score_one_pair() {
        assertEquals(0, Yatzy1.roll(3, 4, 1, 5, 6).scorePairs());
    }


    @Test
    public void should_score_two_pair() {
        assertEquals(16, Yatzy1.roll(3, 3, 5, 4, 5).scoreTwoPairs());
        assertEquals(16, Yatzy1.roll(3, 3, 5, 5, 5).scoreTwoPairs());
    }

    @Test
    public void should_not_score_two_pair() {
        assertEquals(0, Yatzy1.roll(1, 1, 2, 3, 4).scoreTwoPairs());
    }

    @Test
    public void should_score_three_of_a_kind() {
        assertEquals(9, Yatzy1.roll(3, 3, 3, 4, 5).scoreThreeKinds());
        assertEquals(15, Yatzy1.roll(5, 3, 5, 4, 5).scoreThreeKinds());
        assertEquals(9, Yatzy1.roll(3, 3, 3, 3, 5).scoreThreeKinds());
    }

    @Test
    public void should_not_score_three_of_a_kind() {
        assertEquals(0, Yatzy1.roll(3, 3, 1, 4, 5).scoreThreeKinds());
    }

    @Test
    public void should_score_four_of_a_kind() {
        assertEquals(12, Yatzy1.roll(3, 3, 3, 3, 5).scoreFourKinds());
        assertEquals(20, Yatzy1.roll(5, 5, 5, 5, 5).scoreFourKinds());
    }

    @Test
    public void should_not_score_four_of_a_kind() {
        assertEquals(0, Yatzy1.roll(3, 3, 1, 3, 5).scoreFourKinds());
    }

    @Test
    public void should_score_smallStraight() {
        assertEquals(15, Yatzy1.roll(1, 2, 3, 4, 5).scoreSmallStraight());
        assertEquals(15, Yatzy1.roll(2, 3, 4, 5, 1).scoreSmallStraight());
    }

    @Test
    public void should_not_score_smallStraight() {
        assertEquals(0, Yatzy1.roll(1, 2, 2, 4, 5).scoreSmallStraight());
        assertEquals(0, Yatzy1.roll(6, 2, 3, 4, 5).scoreSmallStraight());
    }

    @Test
    public void should_score_largeStraight() {
        assertEquals(20, Yatzy1.roll(6, 2, 3, 4, 5).scoreLargeStraight());
        assertEquals(20, Yatzy1.roll(2, 3, 4, 5, 6).scoreLargeStraight());
    }

    @Test
    public void should_not_score_largeStraight() {
        assertEquals(0, Yatzy1.roll(1, 2, 3, 4, 5).scoreLargeStraight());
        assertEquals(0, Yatzy1.roll(1, 2, 2, 4, 5).scoreLargeStraight());

    }

    @Test
    public void should_score_fullHouse() {
        assertEquals(18, Yatzy1.roll(6, 2, 2, 2, 6).scoreFullHouse());
        assertEquals(0, Yatzy1.roll(2, 3, 4, 5, 6).scoreFullHouse());
    }

    @Test
    public void should_score_chance() {

        assertEquals(15, Yatzy1.roll(1, 2, 3, 4, 5).scoreChance());
    }

    @Test
    public void should_score_yatzy() {
        assertEquals(50, Yatzy1.roll(6, 6, 6, 6, 6).scoreYatzy());
    }

    @Test
    public void should_not_score_yatzy() {
        assertEquals(0, Yatzy1.roll(6, 6, 6, 6, 3).scoreYatzy());
    }

}
