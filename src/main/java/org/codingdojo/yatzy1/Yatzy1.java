package org.codingdojo.yatzy1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Yatzy1 {
    private final int[] dices;

    public Yatzy1(Dices dices) {
        this.dices = dices.getDicesArray();
    }

    public int chance() {
        return Arrays.stream(this.dices).sum();
    }

    public int yatzy() {
        if (Arrays.stream(this.dices).distinct().count() == 1)
            return 50;
        return 0;
    }

    private int sumOfSpecificValue(int value){
        return (int) (Arrays.stream(this.dices).filter(dice -> dice == value).count() * value);
    }

    public int ones() {
        return this.sumOfSpecificValue(1);
    }

    public int twos() {
        return this.sumOfSpecificValue(2);
    }

    public int threes() {
        return this.sumOfSpecificValue(3);
    }

    public int fours() {
        return this.sumOfSpecificValue(4);
    }

    public int fives() {
        return this.sumOfSpecificValue(5);
    }

    public int sixes() {
        return this.sumOfSpecificValue(6);
    }

    private int scoreNumberOfPair(int numberOfPair){
        Map<Integer, Long> counts = getCountOfEachDiceValue();
        return getBestPairScores(counts)
            .sorted(Comparator.reverseOrder())
            .limit(numberOfPair)
            .mapToInt(Integer::intValue).sum();
    }

    private static Stream<Integer> getBestPairScores(Map<Integer, Long> counts) {
        return counts.entrySet().stream()
            .filter(cardCount -> cardCount.getValue() >= 2)
            .map(diceCount -> diceCount.getKey() * 2);
    }

    private Map<Integer, Long> getCountOfEachDiceValue() {
        return Arrays.stream(this.dices)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public int scorePair() {
        return scoreNumberOfPair(1);
    }

    public int twoPair() {
        return this.scoreNumberOfPair(2);
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1]++;
        tallies[d2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int[] t;
        t = new int[6];
        t[d1 - 1]++;
        t[d2 - 1]++;
        t[d3 - 1]++;
        t[d4 - 1]++;
        t[d5 - 1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
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



