/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tveki.games.setgame;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author tveki
 */
public abstract class AbstractRedrawable implements Redrawable, HasLayers {
    
    private final Transformer transformer = new Transformer();
    
    protected GraphicsContext getContext(int index) {
        return getLayer(index).getGraphicsContext2D();
    }
    
    protected GraphicsContext getContext(Canvas layer) {
        return layer.getGraphicsContext2D();
    }
    
    protected Canvas getLayer(int index) {
        return getLayers().get(index);
    }
    
    protected void clearLayer(int index) {
        clearLayer(getLayer(index));
    }
    
    protected void clearLayer(Canvas layer) {
        getContext(layer).clearRect(0, 0, 
                layer.getWidth(),
                layer.getHeight());
    }

    protected double transformX(double x) {
        return transformer.transformX(x);
    }

    protected double transformY(double y) {
        return transformer.transformY(y);
    }
    
    protected void clearLayers() {
        getLayers().forEach(this::clearLayer);
    }
}
