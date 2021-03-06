package org.tveki.games.alapozo.ember;

public class Diak extends Ember {

    public Diak(String nev) {
        super(nev);
    }

    public void tanul(String tantargy) {
        kiir("%s ezt tanulja: %s%n", getNev(), tantargy);
        eleterotCsokkent(10);
    }

}
