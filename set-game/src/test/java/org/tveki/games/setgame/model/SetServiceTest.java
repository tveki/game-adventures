package org.tveki.games.setgame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public  class SetServiceTest {

    private SetService setService;

    @BeforeEach
    public void setUp() {
        setService = new SetService();
    }

    @Test
    public void testIfDifferentShapesAndSameColorsAndSameNumbersAndDifferentShading() {
        Card a = new Card(Shape.SQUIGGLE, Color.RED, Number.ONE, Shading.SOLID);
        Card b = new Card(Shape.DIAMOND, Color.RED, Number.ONE, Shading.OPEN);
        Card c = new Card(Shape.OVAL, Color.RED, Number.ONE, Shading.STRIPED);

        assertTrue(setService.isSet(a, b, c));
    }

    @Test
    public void testIfSameShapesAndDifferentColorsAndSameNumbersAndSameShading() {
        Card a = new Card(Shape.OVAL, Color.RED, Number.ONE, Shading.STRIPED);
        Card b = new Card(Shape.OVAL, Color.GREEN, Number.ONE, Shading.STRIPED);
        Card c = new Card(Shape.OVAL, Color.BLUE, Number.ONE, Shading.STRIPED);

        assertTrue(setService.isSet(a, b, c));
    }

    @Test
    public void testIfSameShapesAndDifferentColorsAndSameNumbersAndTwoShading() {
        Card a = new Card(Shape.OVAL, Color.RED, Number.ONE, Shading.SOLID);
        Card b = new Card(Shape.OVAL, Color.GREEN, Number.ONE, Shading.STRIPED);
        Card c = new Card(Shape.OVAL, Color.BLUE, Number.ONE, Shading.STRIPED);

        assertFalse(setService.isSet(a, b, c));
    }

}