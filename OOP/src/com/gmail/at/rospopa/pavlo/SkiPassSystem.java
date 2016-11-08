package com.gmail.at.rospopa.pavlo;

import java.util.HashSet;
import java.util.Set;

public class SkiPassSystem {
    private Set<SkiPass> skiPasses = new HashSet<>();
    private Set<SkiPass> bannedSkiPasses = new HashSet<>();

    private static long nextId = 0;

    private long getNextId() {
        return nextId++;
    }

    public SkiPassWithLimitedLifts createSkiPassWithLimitedLifts(String owner, SkiPassType type, NumberOfLifts numberOfLifts){
        SkiPassWithLimitedLifts skiPassInstance = new SkiPassWithLimitedLifts(owner, type, numberOfLifts.getValue());
        skiPassInstance.setId(getNextId());
        skiPasses.add(skiPassInstance);

        return skiPassInstance;
    }

}
