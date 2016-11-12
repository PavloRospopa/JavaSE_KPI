package com.gmail.at.rospopa.pavlo;

public class SkiPassWithLimitedLifts extends SkiPass {
    private int numberOfLifts;

    public SkiPassWithLimitedLifts(String owner, SkiPassType type, int numberOfLifts) {
        super(owner, type);
        this.numberOfLifts = numberOfLifts;
    }

    public int getNumberOfLifts() {
        return numberOfLifts;
    }

    public void setNumberOfLifts(int numberOfLifts) {
        this.numberOfLifts = numberOfLifts;
    }

    @Override
    public String toString() {
        return "SkiPassWithLimitedLifts{" +
                "id=" + super.getId() +
                ", owner='" + super.getOwner() + '\'' +
                ", type=" + super.getType() +
                ", number of lifts=" + this.numberOfLifts +
                '}';
    }
}
