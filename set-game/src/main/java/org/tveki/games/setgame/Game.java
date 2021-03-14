package org.tveki.games.setgame;

import org.tveki.games.setgame.model.Card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Game {

    private CardService cardService = new CardService();

    private List<Card> allCards;
    private List<Card> cardsOnTable;

    public void start() {
        allCards = cardService.getAllCards();
        Collections.shuffle(allCards);

//        for (Card card : allCards) {
//            System.out.println(card);
//        }

        cardsOnTable = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            cardsOnTable.add(allCards.get(i));
        }

    }

}
