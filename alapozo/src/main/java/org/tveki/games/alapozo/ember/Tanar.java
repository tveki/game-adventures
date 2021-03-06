package org.tveki.games.alapozo.ember;

public class Tanar extends Ember {

    public Tanar(String nev) {
        super(nev);
    }

    public void tanit(String tantargy) {
        kiir("%s ezt tanítja: %s%n", getNev(), tantargy);
        eleterotCsokkent(19);
    }

}
