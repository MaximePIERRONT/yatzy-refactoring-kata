package org.codingdojo.yatzy1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DicesTest {

    @Test
    void diceCannotBe7(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Dices(1, 1, 1, 1, 7));
        assertEquals("Dice value must be between 1 and 6, received: 7", illegalArgumentException.getMessage());
    }

    @Test
    void sum() {
        assertEquals(16, new Dices(1,2,4,4,5).sum());
        assertEquals(13, new Dices(1,1,4,2,5).sum());
    }

    @Test
    void areAllDicesIdentical() {
        assertTrue(new Dices(1,1,1,1,1).areAllDicesIdentical());
        assertTrue(new Dices(2,2,2,2,2).areAllDicesIdentical());
        assertFalse(new Dices(1,1,1,1,3).areAllDicesIdentical());
    }

    @Test
    void sumOfSpecificValue() {
        assertEquals(2, new Dices(1,1,4,2,5).sumOfSpecificValue(1));
        assertEquals(10, new Dices(1,1,4,5,5).sumOfSpecificValue(5));
    }

    @Test
    void numberOfAKind() {
        assertEquals(3, new Dices(1,1,1,2,2).numberOfAKind(3));
        assertEquals(4, new Dices(1,1,1,2,2).numberOfAKind(2));
        assertEquals(3, new Dices(2,3,2,2,2).numberOfAKind(1));
    }

    @Test
    void scoreNumberOfPair() {
        assertEquals(4, new Dices(2,2,1,4,5).scoreNumberOfPair(1));
        assertEquals(12, new Dices(2,2,4,4,5).scoreNumberOfPair(2));
    }

    @Test
    void computeStraight() {
        assertEquals(15, new Dices(1,2,3,4,5).computeStraight());
        assertEquals(20, new Dices(6,2,3,4,5).computeStraight());
        assertEquals(0, new Dices(1,2,3,4,6).computeStraight());
    }

    @Test
    void computeFullHouse() {
        assertEquals(13, new Dices(1,1,1,5,5).computeFullHouse());
        assertEquals(15, new Dices(1,1,1,6,6).computeFullHouse());
        assertEquals(0, new Dices(1,1,1,1,5).computeFullHouse());
    }
}