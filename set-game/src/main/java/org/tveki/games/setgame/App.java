package org.tveki.games.setgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        Game.getInstance().start();
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Table table = new Table();
        table.updateCards(Game.getInstance().getCardsOnTable());
        SceneComposer composer = new SceneComposer();
        Scene scene = composer.compose(table);
        stage.setTitle("The Set Card Game");
        stage.setScene(scene);
        stage.show();
    }
}
