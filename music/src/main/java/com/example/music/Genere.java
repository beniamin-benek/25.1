package com.example.music;

public enum Genere {

    ROCK("Rock"),
    POP("Pop"),
    ALTERNATIVE("Alternative"),
    RAP("Rap"),
    JAZZ("Jazz"),
    DUBSTEP("Dubstep"),
    BLUES("Blues"),
    COUNTRY("Country"),
    EDM("EDM"),
    TECHNO("Techno"),
    ELECTRONIC("Electronic");

    String genereName;

    Genere(String genereName) {
        this.genereName = genereName;
    }

    public String getGenereName() {
        return genereName;
    }

    @Override
    public String toString() {
        return getGenereName();
    }

}
