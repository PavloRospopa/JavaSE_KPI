package com.gmail.at.rospopa.pavlo;

public enum NumberOfLifts {
    TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);

    private int value;

    NumberOfLifts(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
