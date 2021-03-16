package org.tveki.games.setgame;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import org.tveki.games.setgame.model.Number;
import org.tveki.games.setgame.model.*;

import java.util.List;

public class CardDisplay extends AbstractRedrawable {

    public static final double CARD_WIDTH = 100;
    public static final double CARD_HEIGHT = 180;
    public static final double CARD_IMAGE_WIDTH = 60;
    public static final double CARD_IMAGE_HEIGHT = 25;
    public static final double CARD_ARC = 10;


    private CardImageProvider imageProvider = new CardImageProvider();
    private CardService cardService = new CardService();

    private final Canvas firstLayer;
    private final Canvas secondLayer;

    public CardDisplay() {
        firstLayer = new Canvas(CanvasProps.CANVAS_WIDTH, CanvasProps.CANVAS_HEIGHT);
        secondLayer = new Canvas(CanvasProps.CANVAS_WIDTH, CanvasProps.CANVAS_HEIGHT);
    }

    private void drawCard(Card card) {
        final Image image = imageProvider.getImage(card);
        int x = 30;
        int number = card.getNumber().getValue();
        getContext(firstLayer).strokeRoundRect(
                10,
                10,
                CARD_WIDTH,
                CARD_HEIGHT,
                CARD_ARC,
                CARD_ARC
        );
        for (int i = 0; i < number; i++) {
            getContext(firstLayer).drawImage(image,
                    x,
                    50 + i * 40,
                    CARD_IMAGE_WIDTH,
                    CARD_IMAGE_HEIGHT);
        }
    }

    @Override
    public List<Canvas> getLayers() {
        return List.of(firstLayer, secondLayer);
    }

    @Override
    public void redraw() {
        clearLayer(0);
        drawCard(new Card(Shape.SQUIGGLE, Color.RED, Number.THREE, Shading.SOLID));
    }
}
