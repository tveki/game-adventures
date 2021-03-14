package org.tveki.games.setgame;

import org.tveki.games.setgame.model.Number;
import org.tveki.games.setgame.model.*;

import java.util.ArrayList;
import java.util.List;

public class CardService {

    public List<Card> getAllCards() {
        List<Card> cards = new ArrayList<>();
        for (Shape shape : Shape.values()) {
            for (Color color : Color.values()) {
                for (Number number : Number.values()) {
                    for (Shading shading : Shading.values()) {
                       cards.add(new Card(shape, color, number, shading));
                    }
                }
            }
        }
        return cards;
    }

}
