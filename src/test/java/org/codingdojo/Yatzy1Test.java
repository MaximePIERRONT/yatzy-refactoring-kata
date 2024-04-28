package org.codingdojo;

import org.codingdojo.yatzy1.Dices;
import org.codingdojo.yatzy1.Yatzy1;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Yatzy1Test {

    Yatzy1 yatzy1 = new Yatzy1(new Dices(1, 1, 1, 1, 1));

    private void testYatzyCombination(int expected, Supplier<Integer> supplier, int... diceValues) {
        yatzy1.setDices(new Dices(diceValues[0], diceValues[1], diceValues[2], diceValues[3], diceValues[4]));
        assertEquals(expected, supplier.get());
    }

    @Test
    void testChances() {
        testYatzyCombination(15, () -> yatzy1.chance(), 2, 3, 4, 5, 1);
        testYatzyCombination(16, () -> yatzy1.chance(), 3, 3, 4, 5, 1);
    }

    @Test
    void testYatzy() {
        testYatzyCombination(50, () -> yatzy1.yatzy(), 4, 4, 4, 4, 4);
        testYatzyCombination(50, () -> yatzy1.yatzy(), 6, 6, 6, 6, 6);
        testYatzyCombination(0, () -> yatzy1.yatzy(), 6, 6, 6, 6, 3);
    }

    @Test
    void testOnes() {
        testYatzyCombination(1, () -> yatzy1.ones(), 1, 2, 3, 4, 5);
        testYatzyCombination(2, () -> yatzy1.ones(), 1, 2, 1, 4, 5);
        testYatzyCombination(0, () -> yatzy1.ones(), 6, 2, 2, 4, 5);
        testYatzyCombination(4, () -> yatzy1.ones(), 1, 2, 1, 1, 1);
    }

    @Test
    void testTwos() {
        testYatzyCombination(4, () -> yatzy1.twos(), 1, 2, 3, 2, 6);
        testYatzyCombination(10, () -> yatzy1.twos(), 2, 2, 2, 2, 2);
    }

    @Test
    void testThrees() {
        testYatzyCombination(6, () -> yatzy1.threes(), 1, 2, 3, 2, 3);
        testYatzyCombination(12, () -> yatzy1.threes(), 2, 3, 3, 3, 3);
    }

    @Test
    void testFours() {
        testYatzyCombination(12, () -> yatzy1.fours(), 4, 4, 4, 5, 5);
        testYatzyCombination(8, () -> yatzy1.fours(), 4, 4, 5, 5, 5);
        testYatzyCombination(4, () -> yatzy1.fours(), 4, 5, 5, 5, 5);
    }

    @Test
    void testFives() {
        testYatzyCombination(10, () -> yatzy1.fives(), 4, 4, 4, 5, 5);
        testYatzyCombination(15, () -> yatzy1.fives(), 4, 4, 5, 5, 5);
        testYatzyCombination(20, () -> yatzy1.fives(), 4, 5, 5, 5, 5);
    }

    @Test
    void testSixes() {
        testYatzyCombination(0, () -> yatzy1.sixes(), 4, 4, 4, 5, 5);
        testYatzyCombination(6, () -> yatzy1.sixes(), 4, 4, 6, 5, 5);
        testYatzyCombination(18, () -> yatzy1.sixes(), 6, 5, 6, 6, 5);
    }

    @Test
    void testOnePair() {
        testYatzyCombination(6, () -> yatzy1.scorePair(), 3, 4, 3, 5, 6);
        testYatzyCombination(10, () -> yatzy1.scorePair(), 5, 3, 3, 3, 5);
        testYatzyCombination(12, () -> yatzy1.scorePair(), 5, 3, 6, 6, 5);
    }

    @Test
    void testTwoPairs() {
        testYatzyCombination(16, () -> yatzy1.twoPair(), 3, 3, 5, 4, 5);
        testYatzyCombination(16, () -> yatzy1.twoPair(), 3, 3, 5, 5, 5);
    }

    @Test
    void testThreeOfAKind() {
        testYatzyCombination(9, () -> yatzy1.threeOfAKind(), 3, 3, 3, 4, 5);
        testYatzyCombination(15, () -> yatzy1.threeOfAKind(), 5, 3, 5, 4, 5);
        testYatzyCombination(9, () -> yatzy1.threeOfAKind(), 3, 3, 3, 3, 5);
    }

    @Test
    void testFourOfAKind() {
        testYatzyCombination(12, () -> yatzy1.fourOfAKind(), 3, 3, 3, 3, 5);
        testYatzyCombination(20, () -> yatzy1.fourOfAKind(), 5, 5, 5, 4, 5);
        testYatzyCombination(12, () -> yatzy1.fourOfAKind(), 3, 3, 3, 3, 3);
    }

    @Test
    void smallStraight() {
        testYatzyCombination(15, () -> yatzy1.smallStraight(), 1, 2, 3, 4, 5);
        testYatzyCombination(15, () -> yatzy1.smallStraight(), 2, 3, 4, 5, 1);
        testYatzyCombination(0, () -> yatzy1.smallStraight(), 1, 2, 2, 4, 5);
    }

    @Test
    void largeStraight() {
        testYatzyCombination(20, () -> yatzy1.largeStraight(), 6, 2, 3, 4, 5);
        testYatzyCombination(20, () -> yatzy1.largeStraight(), 2, 3, 4, 5, 6);
        testYatzyCombination(0, () -> yatzy1.largeStraight(), 1, 2, 2, 4, 5);
    }

    @Test
    void fullHouse() {
        testYatzyCombination(18, () -> yatzy1.fullHouse(), 6, 2, 2, 2, 6);
        testYatzyCombination(0, () -> yatzy1.fullHouse(), 2, 3, 4, 5, 6);
    }
}
