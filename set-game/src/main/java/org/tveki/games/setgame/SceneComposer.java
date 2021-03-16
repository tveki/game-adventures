/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tveki.games.setgame;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * @author tveki
 */
public class SceneComposer {

    public static final int SCENE_WIDTH = CanvasProps.CANVAS_WIDTH;
    public static final int SCENE_HEIGHT = CanvasProps.CANVAS_HEIGHT + 100;

    public Scene compose() {
        VBox pane = new VBox();

        Pane canvasPane = new Pane();
        pane.getChildren().add(canvasPane);

        CardDisplay cardDisplay = new CardDisplay();
        canvasPane.getChildren().addAll(cardDisplay.getLayers());

        cardDisplay.redraw();

        return new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);
    }

}
