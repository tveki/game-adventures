package org.tveki.games.alapozo.ember;

public class Sebesz extends Orvos {

    public Sebesz(String nev) {
        super(nev);
    }

    public void mut() {
        kiir("%s műt...%n", getNev());
        eleterotCsokkent(18);
    }
}
