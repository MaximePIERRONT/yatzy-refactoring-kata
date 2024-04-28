package org.codingdojo;

import org.codingdojo.yatzy1.Dices;
import org.codingdojo.yatzy1.Yatzy1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Yatzy1Test {

    @Test
    void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = new Yatzy1(new Dices(2, 3, 4, 5, 1)).chance();
        assertEquals(expected, actual);
        assertEquals(16, new Yatzy1(new Dices(3, 3, 4, 5, 1)).chance());
    }

    @Test
    void yatzyScores50() {
        int expected = 50;
        int actual = new Yatzy1(new Dices(4, 4, 4, 4, 4)).yatzy();
        assertEquals(expected, actual);
        assertEquals(50, new Yatzy1(new Dices(6, 6, 6, 6, 6)).yatzy());
        assertEquals(0, new Yatzy1(new Dices(6, 6, 6, 6, 3)).yatzy());
    }

    @Test
    void testOnes() {
        assertEquals(1, new Yatzy1(new Dices(1, 2, 3, 4, 5)).ones());
        assertEquals(2, new Yatzy1(new Dices(1, 2, 1, 4, 5)).ones());
        assertEquals(0, new Yatzy1(new Dices(6, 2, 2, 4, 5)).ones());
        assertEquals(4, new Yatzy1(new Dices(1, 2, 1, 1, 1)).ones());
    }

    @Test
    void testTwos() {
        assertEquals(4, new Yatzy1(new Dices(1, 2, 3, 2, 6)).twos());
        assertEquals(10,new Yatzy1(new Dices(2, 2, 2, 2, 2)).twos());
    }

    @Test
    void testThrees() {
        assertEquals(6, new Yatzy1(new Dices(1, 2, 3, 2, 3)).threes());
        assertEquals(12, new Yatzy1(new Dices(2, 3, 3, 3, 3)).threes());
    }

    @Test
    void testFours() {
        assertEquals(12, new Yatzy1(new Dices(4, 4, 4, 5, 5)).fours());
        assertEquals(8, new Yatzy1(new Dices(4, 4, 5, 5, 5)).fours());
        assertEquals(4, new Yatzy1(new Dices(4, 5, 5, 5, 5)).fours());
    }

    @Test
    void testFives() {
        assertEquals(10, new Yatzy1(new Dices(4, 4, 4, 5, 5)).fives());
        assertEquals(15, new Yatzy1(new Dices(4, 4, 5, 5, 5)).fives());
        assertEquals(20, new Yatzy1(new Dices(4, 5, 5, 5, 5)).fives());
    }

    @Test
    void testSixes() {
        assertEquals(0, new Yatzy1(new Dices(4, 4, 4, 5, 5)).sixes());
        assertEquals(6, new Yatzy1(new Dices(4, 4, 6, 5, 5)).sixes());
        assertEquals(18, new Yatzy1(new Dices(6, 5, 6, 6, 5)).sixes());
    }

    @Test
    void testOnePair() {
        assertEquals(6, new Yatzy1(new Dices(3, 4, 3, 5, 6)).scorePair());
        assertEquals(10, new Yatzy1(new Dices(5, 3, 3, 3, 5)).scorePair());
        assertEquals(12, new Yatzy1(new Dices(5, 3, 6, 6, 5)).scorePair());
    }

    @Test
    void testTwoPairs() {
        assertEquals(16, new Yatzy1(new Dices(3, 3, 5, 4, 5)).twoPair());
        assertEquals(16, new Yatzy1(new Dices(3, 3, 5, 5, 5)).twoPair());
    }

    @Test
    void testThreeOfAKind() {
        assertEquals(9,new Yatzy1(new Dices(3, 3, 3, 4, 5)).threeOfAKind());
        assertEquals(15, new Yatzy1(new Dices(5, 3, 5, 4, 5)).threeOfAKind());
        assertEquals(9, new Yatzy1(new Dices(3, 3, 3, 3, 5)).threeOfAKind());
    }

    @Test
    void testFourOfAKind() {
        assertEquals(12, new Yatzy1(new Dices(3, 3, 3, 3, 5)).fourOfAKind());
        assertEquals(20, new Yatzy1(new Dices(5, 5, 5, 4, 5)).fourOfAKind());
        assertEquals(12, new Yatzy1(new Dices(3, 3, 3, 3, 3)).fourOfAKind());
    }

    @Test
    void smallStraight() {
        assertEquals(15, new Yatzy1(new Dices(1, 2, 3, 4, 5)).smallStraight());
        assertEquals(15, new Yatzy1(new Dices(2, 3, 4, 5, 1)).smallStraight());
        assertEquals(0, new Yatzy1(new Dices(1, 2, 2, 4, 5)).smallStraight());
    }

    @Test
    void largeStraight() {
        assertEquals(20, new Yatzy1(new Dices(6, 2, 3, 4, 5)).largeStraight());
        assertEquals(20, new Yatzy1(new Dices(2, 3, 4, 5, 6)).largeStraight());
        assertEquals(0, new Yatzy1(new Dices(1, 2, 2, 4, 5)).largeStraight());
    }

    @Test
    void fullHouse() {
        assertEquals(18, new Yatzy1(new Dices(6, 2, 2, 2, 6)).fullHouse());
        assertEquals(0, new Yatzy1(new Dices(2, 3, 4, 5, 6)).fullHouse());
    }
}
