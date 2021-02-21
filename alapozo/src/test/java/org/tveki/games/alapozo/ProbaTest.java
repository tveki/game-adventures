package org.tveki.games.alapozo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbaTest {

    Proba proba;

    @BeforeEach
    public void setUp() {
        proba = new Proba();
    }

    @Test
    public void testHelloBandi() {
        assertEquals("Hello Bandi!", proba.hello("Bandi"));
    }

    @Test
    public void testHelloMate() {
        assertEquals("Hello Máté!", proba.hello("Máté"));
    }

    @Test
    public void testHelloTerka() {
        assertEquals("Hello Ember!", proba.hello("Ember"));
    }

    @Test
    public void testHelloKrumplibogar() {
        assertEquals("Hello Krumplibogár!", proba.hello("Krumplibogár"));
    }

    @Test
    public void testSziaBori() {
        assertEquals("Szia Bori!", proba.szia("Bori"));
    }

}