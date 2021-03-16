package org.tveki.games.setgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        Game game = new Game();
        game.start();

        launch(args);
    }

    @Override
    public void start(Stage stage) {
        SceneComposer composer = new SceneComposer();
        Scene scene = composer.compose();
        stage.setTitle("The Set Card Game");
        stage.setScene(scene);
        stage.show();
    }
}
