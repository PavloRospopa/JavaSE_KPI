package com.gmail.at.rospopa.pavlo.generics.passengers;

public class Fireman extends Human {
    private FiremanRank rank;

    public FiremanRank getRank() {
        return rank;
    }

    public void setRank(FiremanRank rank) {
        this.rank = rank;
    }

    public Fireman(Long id, String name, FiremanRank rank) {
        super(id, name);
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Fireman{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", rank='" + getRank() + '\'' +
                '}';
    }
}
