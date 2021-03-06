package org.tveki.games.alapozo.app;

import org.tveki.games.alapozo.ember.*;

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

        Diak julia = new Diak("Júlia");
        julia.felebred();
        julia.eszik("müzli", 12);
        julia.tanul("Matek");
        julia.alszik();

        Orvos agi = new Orvos("Ági");
        agi.felebred();
        agi.gyogyit("COVID19");
        agi.alszik();

        Orvos tamas = new Orvos("Tamás");
        tamas.felebred();
        tamas.gyogyit("Kéztörés");
        tamas.alszik();

        Sebesz tomi = new Sebesz("Tomi");
        tomi.mut();

        Tanar vera = new Tanar("Vera");
        for (int i = 0; i < 10; i++) {
            if (vera.isElo()) {
                vera.tanit("Fizika");
                if (vera.getHp() < 20) {
                    vera.eszik("Szendvics", 21);
                }
            } else {
                System.out.println("Már halott");
            }
        }

        while (tomi.isElo()) {
            tomi.mut();
        }

    }

}
