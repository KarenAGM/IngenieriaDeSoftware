package mx.com.gm.istenis.main;

public class Juego {
    private Jugador jugador1=null;
    private Jugador jugador2=null;
    private Jugador ganador=null;
    private Jugador jugadorVentaja=null;
    private boolean ventaja =false;
    private boolean duece = false;
    
    

    public Juego() {
    }
    public Juego(Jugador jugador1, Jugador jugador2){
        this.jugador1=jugador1;
        this.jugador2=jugador2;
    }

    public Jugador getJugadorVentaja() {
        return jugadorVentaja;
    }

    public void setJugadorVentaja(Jugador jugadorVentaja) {
        this.jugadorVentaja = jugadorVentaja;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    public boolean isVentaja() {
        return ventaja;
    }

    public void setVentaja(boolean ventaja) {
        this.ventaja = ventaja;
    }

    public boolean isDuece() {
        return duece;
    }

    public void setDuece(boolean duece) {
        this.duece = duece;
    }

    public boolean duece(){
        if(this.jugador1.getPuntos()==3 && this.getJugador2().getPuntos()==this.getJugador2().getPuntos()){
            this.setDuece(true);

        }else {
            this.setDuece(false);
        }
        return this.isDuece();

    }

    public boolean advantage(){
        if((this.getJugador1().getPuntos()==4 && this.getJugador1().getPuntos()==this.getJugador2().getPuntos()+1)||
            this.getJugador2().getPuntos()==4 && this.getJugador2().getPuntos()==this.getJugador1().getPuntos()+1){

            this.setVentaja(true);
        }else{
            this.setVentaja(false);
        }
        return this.isVentaja();
    }

    public void jugador1Anota(){

        if(!(this.advantage()) && !(this.duece())){
            this.jugador1.sumaPuntos(1);
        }else if(this.duece && !(this.advantage())){
            this.jugador1.sumaPuntos(1);
            this.setJugadorVentaja(this.jugador1);
            this.setVentaja(true);
        }else if(isVentaja()){
            if(this.getJugador2()==this.getJugadorVentaja()){
                this.getJugador2().sumaPuntos(-1);
                this.getJugador1().sumaPuntos(1);
                this.setJugadorVentaja(this.jugador1);
            }else {
                this.setGanador(this.jugador1);
            }
        }
    }
    public void jugador2Anota(){

        if(!(this.advantage()) && !(this.duece())){
            this.jugador2.sumaPuntos(1);
        }else if(this.duece && !(this.advantage())){
            this.jugador2.sumaPuntos(1);
            this.setJugadorVentaja(this.jugador2);
            this.setVentaja(true);
        }else if(isVentaja()){
            if(this.getJugador1()==this.getJugadorVentaja()){
                this.getJugador1().sumaPuntos(-1);
                this.getJugador2().sumaPuntos(1);
                this.setJugadorVentaja(this.jugador2);
            }else {
                this.setGanador(this.jugador2);
            }
        }
    }
}
