package org.codingdojo;

public class Dice {

    int value;

    public Dice(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isOne() {
        return this.value == 1;
    }

    public boolean isTwo() {
        return this.value == 2;
    }

    public boolean isThree() {
        return this.value == 3;
    }

    public boolean isFour() {
        return this.value == 4;
    }

    public boolean isFive() {
        return this.value == 5;
    }

    public boolean isSix() {
        return this.value == 6;
    }
}
