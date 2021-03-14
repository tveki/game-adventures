package org.tveki.games.setgame.model;

public class SetService {

    public boolean isSet(Card a, Card b, Card c) {
        return isSetByShape(a, b, c) &&
                isSetByColor(a, b, c) &&
                isSetByNumber(a, b, c) &&
                isSetByShading(a, b, c);
    }

    private boolean isSetByShape(Card a, Card b, Card c) {
        return isSameFeature(a.getShape(), b.getShape(), c.getShape()) ||
                isDifferentFeature(a.getShape(), b.getShape(), c.getShape());
    }


    private boolean isSetByColor(Card a, Card b, Card c) {
        return isSameFeature(a.getColor(), b.getColor(), c.getColor()) ||
                isDifferentFeature(a.getColor(), b.getColor(), c.getColor());
    }

    private boolean isSetByNumber(Card a, Card b, Card c) {
        return isSameFeature(a.getNumber(), b.getNumber(), c.getNumber()) ||
                isDifferentFeature(a.getNumber(), b.getNumber(), c.getNumber());
    }

    private boolean isSetByShading(Card a, Card b, Card c) {
        return isSameFeature(a.getShading(), b.getShading(), c.getShading()) ||
                isDifferentFeature(a.getShading(), b.getShading(), c.getShading());
    }

    private boolean isSameFeature(Feature a, Feature b, Feature c) {
        return a == b && a == c;
    }

    private boolean isDifferentFeature(Feature a, Feature b, Feature c) {
        return a != b && a != c && b != c;
    }
}
