package org.tveki.games.setgame;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import org.tveki.games.setgame.model.Number;
import org.tveki.games.setgame.model.*;

import java.util.List;

public class Table extends AbstractRedrawable {

    public static final double CARD_WIDTH = 100;
    public static final double CARD_HEIGHT = 180;
    public static final double CARD_IMAGE_WIDTH = 60;
    public static final double CARD_IMAGE_HEIGHT = 25;
    public static final double CARD_ARC = 15;
    public static final double HORIZONTAL_GAP = 30;
    public static final double VERTICAL_GAP = 30;


    private CardImageProvider imageProvider = new CardImageProvider();

    private final Canvas cardLayer;

    private List<Card> cards;

    public Table() {
        cardLayer = new Canvas(CanvasProps.CANVAS_WIDTH, CanvasProps.CANVAS_HEIGHT);
    }

    public void updateCards(List<Card> cards) {
        this.cards = cards;
        redraw();
    }

    private void drawCard(Card card, double x, double y) {
        final Image image = imageProvider.getImage(card);
        Number number = card.getNumber();
        getContext(cardLayer).strokeRoundRect(
                x,
                y,
                CARD_WIDTH,
                CARD_HEIGHT,
                CARD_ARC,
                CARD_ARC
        );
        for (int i = 0; i < number.getValue(); i++) {
            getContext(cardLayer).drawImage(image,
                    x + CARD_WIDTH / 2 - CARD_IMAGE_WIDTH / 2,
                    getY(y, number, i),
                    CARD_IMAGE_WIDTH,
                    CARD_IMAGE_HEIGHT);
        }
    }

    private double getY(double y, Number number, int i) {
        double middle = y + CARD_HEIGHT / 2;
        double position;
        switch (number) {
            case ONE: {
                position = 0;
                break;
            }
            case TWO: {
                position = i - 0.5;
                break;
            }
            case THREE: {
                position = i - 1;
                break;
            }
            default: {
                throw new RuntimeException("Unknown number: " + number);
            }
        }
        return middle + position * CARD_IMAGE_HEIGHT * 1.5 - CARD_IMAGE_HEIGHT / 2;
    }

    @Override
    public List<Canvas> getLayers() {
        return List.of(cardLayer);
    }

    @Override
    public void redraw() {
        clearLayers();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            double x = HORIZONTAL_GAP + (i % 4) * (CARD_WIDTH + HORIZONTAL_GAP);
            double y = VERTICAL_GAP + Math.floor(i / 4) * (CARD_HEIGHT + VERTICAL_GAP);
            drawCard(card, x, y);
        }
    }
}
