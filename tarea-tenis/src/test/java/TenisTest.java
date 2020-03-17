

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import mx.com.gm.istenis.main.Juego;
import mx.com.gm.istenis.main.Jugador;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 *
 */
public class TenisTest {

    public TenisTest() {
    }

    @Test
    public void isDuce() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Juego tenis = new Juego(jugador1, jugador2);

        for (int i = 0; i < 3; i++) {
            tenis.jugador1Anota();
            tenis.jugador2Anota();

        }
        assertEquals(3, jugador1.getPuntos());
        assertEquals(3, jugador2.getPuntos());
        assertFalse(tenis.advantage());
        assertTrue(tenis.duece());

    }

    @Test
    public void isVentaja() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Juego tenis = new Juego(jugador1, jugador2);
        for (int i = 0; i < 3; i++) {
            tenis.jugador1Anota();
            tenis.jugador2Anota();

        }
        tenis.jugador1Anota();
        assertEquals(4, jugador1.getPuntos());
        assertEquals(3, jugador2.getPuntos());
        assertFalse(tenis.duece());
        assertTrue(tenis.advantage());

    }

    @Test
    public void jugadorUnoVentaja() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Juego tenis = new Juego(jugador1, jugador2);

        for (int i = 0; i < 3; i++) {
            tenis.jugador1Anota();
            tenis.jugador2Anota();

        }
        tenis.jugador1Anota();

        assertSame(jugador1, tenis.getJugadorVentaja());

    }

    @Test
    public void jugadorDosVentaja() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Juego tenis = new Juego(jugador1, jugador2);

        for (int i = 0; i < 3; i++) {
            tenis.jugador1Anota();
            tenis.jugador2Anota();

        }
        tenis.jugador2Anota();

        assertSame(jugador2, tenis.getJugadorVentaja());

    }

    @Test
    public void jugadorUnoPierdeVentaja() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Juego tenis = new Juego(jugador1, jugador2);

        for (int i = 0; i < 3; i++) {
            tenis.jugador1Anota();
            tenis.jugador2Anota();

        }
        tenis.jugador1Anota();//Jugador uno gana la ventaja
        assertSame(jugador1, tenis.getJugadorVentaja());
        assertEquals(4, jugador1.getPuntos());
        assertEquals(3, jugador2.getPuntos());

        tenis.jugador2Anota();//jugador 1 pierde la ventaja y un punto
        assertEquals(3, jugador1.getPuntos());
        assertEquals(4, jugador2.getPuntos());
        assertSame(jugador2, tenis.getJugadorVentaja());

    }
    
    @Test
    public void jugadorUnoGana(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Juego tenis = new Juego(jugador1, jugador2);

        for (int i = 0; i < 3; i++) {
            tenis.jugador1Anota();
            tenis.jugador2Anota();

        }
        tenis.jugador1Anota();//Jugador uno gana la ventaja
        assertSame(jugador1, tenis.getJugadorVentaja());
        assertEquals(4, jugador1.getPuntos());
        assertEquals(3, jugador2.getPuntos());

        tenis.jugador2Anota();//jugador 1 pierde la ventaja y un punto
        assertEquals(3, jugador1.getPuntos());
        assertEquals(4, jugador2.getPuntos());
        assertSame(jugador2, tenis.getJugadorVentaja());
        
         tenis.jugador1Anota();//Jugador uno gana la ventaja otra vez
        assertSame(jugador1, tenis.getJugadorVentaja());
        assertEquals(4, jugador1.getPuntos());
        assertEquals(3, jugador2.getPuntos());
        
        tenis.jugador1Anota();//remata
         assertSame(jugador1, tenis.getGanador());

        
        

    }
}
