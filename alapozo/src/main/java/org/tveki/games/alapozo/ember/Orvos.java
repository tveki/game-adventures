package org.tveki.games.alapozo.ember;

public class Orvos extends Ember {

    public Orvos(String nev) {
        super(nev);
    }

    public void gyogyit(String betegseg) {
        kiir("%s ezt a betegséget gyógyítja: %s%n", getNev(), betegseg);
        eleterotCsokkent(15);
    }
}
