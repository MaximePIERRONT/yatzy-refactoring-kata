package org.codingdojo.yatzy1;

public class Yatzy1 {
    private final Dices dices;

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

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean isTwoIdenticalCards = false;
        int i;
        int at2 = 0;
        boolean isThreeIdenticalCards = false;
        int at3 = 0;

        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                isTwoIdenticalCards = true;
                at2 = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                isThreeIdenticalCards = true;
                at3 = i + 1;
            }

        if (isTwoIdenticalCards && isThreeIdenticalCards)
            return at2 * 2 + at3 * 3;
        else
            return 0;
    }
}



