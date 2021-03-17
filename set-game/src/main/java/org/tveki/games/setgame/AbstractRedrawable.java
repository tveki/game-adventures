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
    
    protected GraphicsContext getContext(Canvas layer) {
        return layer.getGraphicsContext2D();
    }

    protected void clearLayer(Canvas layer) {
        getContext(layer).clearRect(0, 0, 
                layer.getWidth(),
                layer.getHeight());
    }
    
    protected void clearLayers() {
        getLayers().forEach(this::clearLayer);
    }
}
