package org.tveki.games.alapozo.ember;

public class Ember {

    private String nev;
    private int hp; // health points

    public Ember(String nev) {
        this.nev = nev;
        hp = 100;
    }

    public void kakil() {
        kiir("%s kakil.%n", nev);
        eleterotCsokkent(5);
    }

    public void felebred() {
        kiir("*********** nap eleje ***********%n");
        kiir("%s felébred.%n", nev);
    }

    public void eszik(String kaja, int eletero) {
        kiir("%s ezt ette: %s, ennyi életerő volt benne: %d%n", nev, kaja, eletero);
        kiir("Kapott életerő: %d%n", eletero);
        eleterotNovel(eletero);
    }

    public void fut(int tavolsag) {
        int csokkenes = 2 * tavolsag;
        kiir("%s ennyi km-t futott: %d, ennyivel csökkent az életereje: %d%n", nev, tavolsag, csokkenes);
        eleterotCsokkent(csokkenes);
    }

    public void alszik() {
        kiir("%s alszik.%n", nev);
        kiir("-------------- nap vége --------------%n");
        eleterotNovel(20);
    }

    public String getNev() {
        return nev;
    }

    public boolean isElo() {
        return hp > 0;
    }

    public boolean isHalott() {
        return !isElo();
    }

    public int getHp() {
        return hp;
    }

    protected void kiir(String sablon, Object... parameterek) {
        System.out.printf(sablon, parameterek);
    }

    protected void eleterotCsokkent(int ennyivel) {
        if (isElo()) {
            if (ennyivel <= hp) {
                hp = hp - ennyivel;
            } else {
                hp = 0;
            }

            kiir("%s új életereje: %d%n", getNev(), hp);

            if (isHalott()) {
                kiir("%s sajnos most meghalt!%n", getNev());
            }
        } else  {
            kiir("%s már halott, nem tudjuk tovább csökkenteni az életerőt!%n", getNev());
        }
    }

    protected void eleterotNovel(int ennyivel) {
        if (isElo()) {
            hp = hp + ennyivel;
            kiir("%s új életereje: %d%n", getNev(), hp);
        } else {
            kiir("%s már halott, ezért már nem lehet növelni az életerejét!%n", getNev());
        }
    }

}
