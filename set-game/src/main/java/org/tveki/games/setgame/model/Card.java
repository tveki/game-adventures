package org.tveki.games.setgame.model;

public class Card {

    private final Shape shape;
    private final Color color;
    private final Number number;
    private final Shading shading;

    public Card(Shape shape, Color color, Number number, Shading shading) {
        this.shape = shape;
        this.color = color;
        this.number = number;
        this.shading = shading;
    }

    public Shape getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public Number getNumber() {
        return number;
    }

    public Shading getShading() {
        return shading;
    }
}
