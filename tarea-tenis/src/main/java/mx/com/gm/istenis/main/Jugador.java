package mx.com.gm.istenis.main;
public class Jugador {
    private int puntos=0;


    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void  sumaPuntos(int puntos){
        this.puntos+=puntos;
    }
}
