package org.tveki.games.setgame;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.tveki.games.setgame.model.Number;
import org.tveki.games.setgame.model.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Table extends AbstractRedrawable {

    public static final double CARD_WIDTH = 100;
    public static final double CARD_HEIGHT = 180;
    public static final double SYMBOL_WIDTH = 60;
    public static final double SYMBOL_HEIGHT = 25;
    public static final double SYMBOL_VERTICAL_FACTOR = 1.5; //recommended value is between 1 and 2
    public static final double CARD_ARC = 15;
    public static final double HORIZONTAL_SPACE = 30;
    public static final double VERTICAL_SPACE = 30;
    public static final double SELECTION_LINE_WIDTH = 5;


    private CardImageProvider imageProvider = new CardImageProvider();

    private final Canvas cardLayer;
    private final Canvas selectionLayer;

    private List<Card> cards;
    private Set<Integer> selected;

    public Table() {
        cardLayer = new Canvas(CanvasProps.CANVAS_WIDTH, CanvasProps.CANVAS_HEIGHT);
        selectionLayer = new Canvas(CanvasProps.CANVAS_WIDTH, CanvasProps.CANVAS_HEIGHT);
        getContext(selectionLayer).setLineWidth(SELECTION_LINE_WIDTH);
        getContext(selectionLayer).setStroke(Color.ORANGE);

        cardLayer.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onTableClick);
        selectionLayer.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onTableClick);
        selected = new HashSet<>();
    }

    private void onTableClick(MouseEvent event) {
        System.out.println("x=" + event.getX() + ", y=" + event.getY());
        final Optional<Integer> cardOptional = getCardAt(event.getX(), event.getY());
        if (cardOptional.isPresent()) {
            int cardIndex = cardOptional.get();
            if (selected.contains(cardIndex)) {
                selected.remove(cardIndex);
                clearSelection(cardIndex);
            } else {
                selected.add(cardIndex);
                showSelection(cardIndex);
            }
        }
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
                    getSymbolX(x),
                    getSymbolY(y, number, i),
                    SYMBOL_WIDTH,
                    SYMBOL_HEIGHT);
        }
    }

    private void showSelection(int cardIndex) {
        double x = getCardX(cardIndex);
        double y = getCardY(cardIndex);
        getContext(selectionLayer).strokeRoundRect(
                x,
                y,
                CARD_WIDTH,
                CARD_HEIGHT,
                CARD_ARC,
                CARD_ARC
        );
        selectionLayer.toFront();
    }

    private void clearSelection(int cardIndex) {
        double x = getCardX(cardIndex);
        double y = getCardY(cardIndex);
        getContext(selectionLayer).clearRect(
                x - SELECTION_LINE_WIDTH,
                y - SELECTION_LINE_WIDTH,
                CARD_WIDTH + 2 * SELECTION_LINE_WIDTH,
                CARD_HEIGHT + 2 * SELECTION_LINE_WIDTH
        );
    }

    private double getSymbolX(double x) {
        return x + CARD_WIDTH / 2 - SYMBOL_WIDTH / 2;
    }

    private double getSymbolY(double y, Number number, int i) {
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
        return middle + position * SYMBOL_HEIGHT * SYMBOL_VERTICAL_FACTOR - SYMBOL_HEIGHT / 2;
    }

    @Override
    public List<Canvas> getLayers() {
        return List.of(cardLayer, selectionLayer);
    }

    @Override
    public void redraw() {
        clearLayers();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            double x = getCardX(i);
            double y = getCardY(i);
            drawCard(card, x, y);
        }
    }

    private Optional<Integer> getCardAt(double x, double y) {
        for (int i = 0; i < cards.size(); i++) {
            double xDiff = x - getCardX(i);
            double yDiff = y - getCardY(i);
            if (xDiff >= 0 && xDiff <= CARD_WIDTH && yDiff >= 0 && yDiff <= CARD_HEIGHT) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    private double getCardY(int i) {
        return VERTICAL_SPACE + Math.floor(i / 4) * (CARD_HEIGHT + VERTICAL_SPACE);
    }

    private double getCardX(int i) {
        return HORIZONTAL_SPACE + (i % 4) * (CARD_WIDTH + HORIZONTAL_SPACE);
    }
}
