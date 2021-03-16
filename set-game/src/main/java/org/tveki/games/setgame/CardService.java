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

    public String getPng(Card card) {
        return png(
                card.getShape(),
                card.getShading(),
                card.getColor()
        );
    }

    public List<String> getAllPngs() {
        List<String> pngs = new ArrayList<>();
        for (Shape shape : Shape.values()) {
            for (Shading shading : Shading.values()) {
                for (Color color : Color.values()) {
                    pngs.add(png(shape, shading, color));
                }
            }
        }
        return pngs;
    }

    private String png(Shape shape, Shading shading, Color color) {
        return (shape.name() + "_" + shading.name() + "_" + color.name()).toLowerCase() + ".png";
    }
}
