package org.tveki.games.setgame;

import org.tveki.games.setgame.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private static Game instance;

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    private Game() {
    }

    private CardService cardService = new CardService();

    private List<Card> allCards;
    private List<Card> cardsOnTable;

    public void start() {
        allCards = cardService.getAllCards();
        Collections.shuffle(allCards);
        cardsOnTable = new ArrayList<>();
        cardsOnTable.addAll(allCards.subList(0, 12));
    }

    public List<Card> getCardsOnTable() {
        return Collections.unmodifiableList(cardsOnTable);
    }
}
