/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tveki.games.setgame;

/**
 *
 * @author tveki
 */
public class Transformer {
    
    public double transformX(double x) {
        return x + CanvasProps.CANVAS_WIDTH / 2;
    }
    
    public double transformY(double y) {
        return -y + CanvasProps.CANVAS_HEIGHT / 2;
    }
    
}
