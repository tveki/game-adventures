/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tveki.games.setgame;

import javafx.scene.image.Image;
import org.tveki.games.setgame.model.Card;

import java.io.InputStream;

/**
 *
 * @author tveki
 */
public class CardImageProvider {

    private CardService cardService = new CardService();
    
    public Image getImage(Card card) {
        return new Image(asStream(card));
    }

    private InputStream asStream(Card card) {
        final String png = cardService.getPng(card);
        return getClass().getClassLoader().getResourceAsStream("images/" + png);
    }

}
