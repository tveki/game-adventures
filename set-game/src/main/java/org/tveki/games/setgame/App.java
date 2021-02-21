package org.tveki.games.setgame;

public class App {

    public static void main(String[] args) {
        Ember terka = new Ember("Terka");
        terka.felebred();
        terka.eszik("alma", 5);
        terka.fut(3);
        terka.eszik("kenyér", 40);
        terka.fut(8);
        terka.eszik("vaj", 80);
        terka.fut(1);
        terka.fut(2);
        terka.fut(3);
        terka.alszik();

        Ember mate = new Ember("Máté");
        mate.felebred();
        mate.eszik("palacsinta", 70);
        mate.fut(77);
        mate.alszik();

        Ember bandi = new Ember("Bandi");
        bandi.felebred();
        bandi.eszik("hamburger", 75);
        bandi.kakil();
        bandi.fut(9);
        bandi.alszik();

    }

}
