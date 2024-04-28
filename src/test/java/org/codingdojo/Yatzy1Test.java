package org.codingdojo;

import org.codingdojo.yatzy1.Dices;
import org.codingdojo.yatzy1.Yatzy1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Yatzy1Test {
    
    Yatzy1 yatzy1 = new Yatzy1(new Dices(1,1,1,1,1));

    @Test
    void testChances() {
        yatzy1.setDices(new Dices(2, 3, 4, 5, 1));
        assertEquals(15, yatzy1.chance());
        yatzy1.setDices(new Dices(3, 3, 4, 5, 1));
        assertEquals(16, yatzy1.chance());
    }

    @Test
    void testYatzy() {
        yatzy1.setDices(new Dices(4, 4, 4, 4, 4));
        assertEquals(50, yatzy1.yatzy());
        yatzy1.setDices(new Dices(6, 6, 6, 6, 6));
        assertEquals(50, yatzy1.yatzy());
        yatzy1.setDices(new Dices(6, 6, 6, 6, 3));
        assertEquals(0, yatzy1.yatzy());
    }

    @Test
    void testOnes() {
        yatzy1.setDices(new Dices(1, 2, 3, 4, 5));
        assertEquals(1, yatzy1.ones());
        yatzy1.setDices(new Dices(1, 2, 1, 4, 5));
        assertEquals(2, yatzy1.ones());
        yatzy1.setDices(new Dices(6, 2, 2, 4, 5));
        assertEquals(0, yatzy1.ones());
        yatzy1.setDices(new Dices(1, 2, 1, 1, 1));
        assertEquals(4, yatzy1.ones());
    }

    @Test
    void testTwos() {
        yatzy1.setDices(new Dices(1, 2, 3, 2, 6));
        assertEquals(4, yatzy1.twos());
        yatzy1.setDices(new Dices(2, 2, 2, 2, 2));
        assertEquals(10,yatzy1.twos());
    }

    @Test
    void testThrees() {
        yatzy1.setDices(new Dices(1, 2, 3, 2, 3));
        assertEquals(6, yatzy1.threes());
        yatzy1.setDices(new Dices(2, 3, 3, 3, 3));
        assertEquals(12, yatzy1.threes());
    }

    @Test
    void testFours() {
        yatzy1.setDices(new Dices(4, 4, 4, 5, 5));
        assertEquals(12, yatzy1.fours());
        yatzy1.setDices(new Dices(4, 4, 5, 5, 5));
        assertEquals(8, yatzy1.fours());
        yatzy1.setDices(new Dices(4, 5, 5, 5, 5));
        assertEquals(4, yatzy1.fours());
    }

    @Test
    void testFives() {
        yatzy1.setDices(new Dices(4, 4, 4, 5, 5));
        assertEquals(10, yatzy1.fives());
        yatzy1.setDices(new Dices(4, 4, 5, 5, 5));
        assertEquals(15, yatzy1.fives());
        yatzy1.setDices(new Dices(4, 5, 5, 5, 5));
        assertEquals(20, yatzy1.fives());
    }

    @Test
    void testSixes() {
        yatzy1.setDices(new Dices(4, 4, 4, 5, 5));
        assertEquals(0, yatzy1.sixes());
        yatzy1.setDices(new Dices(4, 4, 6, 5, 5));
        assertEquals(6, yatzy1.sixes());
        yatzy1.setDices(new Dices(6, 5, 6, 6, 5));
        assertEquals(18, yatzy1.sixes());
    }

    @Test
    void testOnePair() {
        yatzy1.setDices(new Dices(3, 4, 3, 5, 6));
        assertEquals(6, yatzy1.scorePair());
        yatzy1.setDices(new Dices(5, 3, 3, 3, 5));
        assertEquals(10, yatzy1.scorePair());
        yatzy1.setDices(new Dices(5, 3, 6, 6, 5));
        assertEquals(12, yatzy1.scorePair());
    }

    @Test
    void testTwoPairs() {
        yatzy1.setDices(new Dices(3, 3, 5, 4, 5));
        assertEquals(16, yatzy1.twoPair());
        yatzy1.setDices(new Dices(3, 3, 5, 5, 5));
        assertEquals(16, yatzy1.twoPair());
    }

    @Test
    void testThreeOfAKind() {
        yatzy1.setDices(new Dices(3, 3, 3, 4, 5));
        assertEquals(9,yatzy1.threeOfAKind());
        yatzy1.setDices(new Dices(5, 3, 5, 4, 5));
        assertEquals(15, yatzy1.threeOfAKind());
        yatzy1.setDices(new Dices(3, 3, 3, 3, 5));
        assertEquals(9, yatzy1.threeOfAKind());
    }

    @Test
    void testFourOfAKind() {
        yatzy1.setDices(new Dices(3, 3, 3, 3, 5));
        assertEquals(12, yatzy1.fourOfAKind());
        yatzy1.setDices(new Dices(5, 5, 5, 4, 5));
        assertEquals(20, yatzy1.fourOfAKind());
        yatzy1.setDices(new Dices(3, 3, 3, 3, 3));
        assertEquals(12, yatzy1.fourOfAKind());
    }

    @Test
    void smallStraight() {
        yatzy1.setDices(new Dices(1, 2, 3, 4, 5));
        assertEquals(15, yatzy1.smallStraight());
        yatzy1.setDices(new Dices(2, 3, 4, 5, 1));
        assertEquals(15, yatzy1.smallStraight());
        yatzy1.setDices(new Dices(1, 2, 2, 4, 5));
        assertEquals(0, yatzy1.smallStraight());
    }

    @Test
    void largeStraight() {
        yatzy1.setDices(new Dices(6, 2, 3, 4, 5));
        assertEquals(20, yatzy1.largeStraight());
        yatzy1.setDices(new Dices(2, 3, 4, 5, 6));
        assertEquals(20, yatzy1.largeStraight());
        yatzy1.setDices(new Dices(1, 2, 2, 4, 5));
        assertEquals(0, yatzy1.largeStraight());
    }

    @Test
    void fullHouse() {
        yatzy1.setDices(new Dices(6, 2, 2, 2, 6));
        assertEquals(18, yatzy1.fullHouse());
        yatzy1.setDices(new Dices(2, 3, 4, 5, 6));
        assertEquals(0, yatzy1.fullHouse());
    }
}
