package org.tveki.games.alapozo;

public class Ember {

    private String name;

    public Ember(String name) {
        this.name = name;
    }

    public void kakil() {
        System.out.println(name + " kakil.");
    }

    public void felebred() {
        System.out.println("*********** nap eleje ***********");
        System.out.println(name + " felébred.");
    }

    public int eszik(String kaja, int kaloria) {
        System.out.println(name + " ezt ette: " + kaja + ", ennyi kalória volt benne: " + kaloria);
        final int kapottEletero = 10 * kaloria;
        System.out.println("Kapott életerő: " + kapottEletero);
        return kapottEletero;
    }

    public int fut(int tavolsag) {
        final int elegetettKaloria = 2 * tavolsag;
        System.out.println(name + " ennyi km-t futott: " + tavolsag + ", ennyi kalóriát égetett el: " + elegetettKaloria);
        return elegetettKaloria;
    }

    public void alszik() {
        System.out.println(name + " alszik.");
        System.out.println("-------------- nap vége --------------");
    }

}
