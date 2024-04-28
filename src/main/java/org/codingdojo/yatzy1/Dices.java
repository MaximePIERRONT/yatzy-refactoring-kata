package org.codingdojo.yatzy1;

public class Dices {
    private final int[] diceArray = new int[5];

    public Dices(int dice0, int dice1, int dice2, int dice3, int dice4){
        this.diceArray[0] = dice0;
        this.diceArray[1] = dice1;
        this.diceArray[2] = dice2;
        this.diceArray[3] = dice3;
        this.diceArray[4] = dice4;
    }

    public int[] getDicesArray() {
        return diceArray;
    }
}
