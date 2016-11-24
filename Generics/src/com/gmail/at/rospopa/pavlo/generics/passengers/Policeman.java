package com.gmail.at.rospopa.pavlo.generics.passengers;

public class Policeman extends Human {
    private PoliceRank rank;

    public PoliceRank getRank() {
        return rank;
    }

    public void setRank(PoliceRank rank) {
        this.rank = rank;
    }

    public Policeman(Long id, String name, PoliceRank rank) {
        super(id, name);
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Policeman{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", rank='" + getRank() + '\'' +
                '}';
    }
}
