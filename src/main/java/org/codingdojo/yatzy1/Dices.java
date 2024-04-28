package org.codingdojo.yatzy1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dices {
    private final int[] diceArray = new int[5];

    public Dices(int dice0, int dice1, int dice2, int dice3, int dice4){
        this.diceArray[0] = dice0;
        this.diceArray[1] = dice1;
        this.diceArray[2] = dice2;
        this.diceArray[3] = dice3;
        this.diceArray[4] = dice4;
    }

    public int sum(){
        return Arrays.stream(this.diceArray).sum();
    }

    protected boolean areAllDicesIdentical(){
        return Arrays.stream(this.diceArray).distinct().count() == 1;
    }

    protected int sumOfSpecificValue(int value){
        return (int) (Arrays.stream(this.diceArray).filter(dice -> dice == value).count() * value);
    }

    private Map<Integer, Long> getCountOfEachDiceValue() {
        return Arrays.stream(this.diceArray)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    protected int numberOfAKind(int number){
        Map<Integer, Long> counts = getCountOfEachDiceValue();
        return counts.entrySet().stream()
            .filter(cardCount -> cardCount.getValue() >= number)
            .mapToInt(diceCount -> diceCount.getKey() * number)
            .findFirst().orElse(0);
    }

    protected int scoreNumberOfPair(int numberOfPair){
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

    protected int computeStraight(){
        int[] sortedDices = Arrays.stream(this.diceArray).sorted().toArray();
        for (int i = 0; i < 5; i++) {
            if (sortedDices[i] != i + sortedDices[0]) {
                return 0;
            }
        }
        return this.sum();
    }

    public int computeFullHouse() {
        Map<Integer, Long> counts = getCountOfEachDiceValue();
        if (counts.containsValue(3L) && counts.containsValue(2L)){
            return this.sum();
        }
        return 0;
    }
}
