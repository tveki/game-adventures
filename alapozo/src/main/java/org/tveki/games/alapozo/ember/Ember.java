package org.tveki.games.alapozo.ember;

public class Ember {

    private String name;

    public Ember(String name) {
        this.name = name;
    }

    public void kakil() {
        kiir("%s kakil.%n", name);
    }

    public void felebred() {
        kiir("*********** nap eleje ***********%n");
        kiir( "%s felébred.%n",name);
    }

    public int eszik(String kaja, int kaloria) {
        kiir("%s ezt ette: %s, ennyi kalória volt benne: %d%n", name,  kaja, kaloria);
        final int kapottEletero = 10 * kaloria;
        kiir("Kapott életerő: %d%n", kapottEletero);
        return kapottEletero;
    }

    public int fut(int tavolsag) {
        final int elegetettKaloria = 2 * tavolsag;
        kiir("%s ennyi km-t futott: %d, ennyi kalóriát égetett el: %d%n", name, tavolsag, elegetettKaloria);
        return elegetettKaloria;
    }

    public void alszik() {
        kiir( "%s alszik.%n", name);
        kiir("-------------- nap vége --------------%n");
    }

    private void kiir(String sablon, Object... parameterek) {
        System.out.printf(sablon, parameterek);
    }

}
