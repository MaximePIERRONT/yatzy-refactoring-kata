package org.codingdojo.yatzy1;

public class Yatzy1 {
    private Dices dices;

    public Yatzy1(Dices dices) {
        this.dices = dices;
    }

    public int chance() {
        return this.dices.sum();
    }

    public int yatzy() {
        if (dices.areAllDicesIdentical())
            return 50;
        return 0;
    }

    public int ones() {
        return this.dices.sumOfSpecificValue(1);
    }

    public int twos() {
        return this.dices.sumOfSpecificValue(2);
    }

    public int threes() {
        return this.dices.sumOfSpecificValue(3);
    }

    public int fours() {
        return this.dices.sumOfSpecificValue(4);
    }

    public int fives() {
        return this.dices.sumOfSpecificValue(5);
    }

    public int sixes() {
        return this.dices.sumOfSpecificValue(6);
    }

    public int scorePair() {
        return this.dices.scoreNumberOfPair(1);
    }

    public int twoPair() {
        return this.dices.scoreNumberOfPair(2);
    }

    public int fourOfAKind() {
        return this.dices.numberOfAKind(4);
    }

    public int threeOfAKind() {
        return this.dices.numberOfAKind(3);
    }

    public int smallStraight() {
        return this.dices.computeStraight();
    }

    public int largeStraight() {
        return this.dices.computeStraight();
    }

    public int fullHouse() {
        return this.dices.computeFullHouse();
    }

    public void setDices(Dices dices) {
        this.dices = dices;
    }
}



