package com.gmail.at.rospopa.pavlo;

public class Turnstile {
    private SkiPassSystem skiPassSystem;

    public Turnstile(SkiPassSystem skiPassSystem) {
        this.skiPassSystem = skiPassSystem;
    }

    public SkiPassSystem getSkiPassSystem() {
        return skiPassSystem;
    }

    public boolean processSkiPass(SkiPass skiPass){



        return true;
    }
}
