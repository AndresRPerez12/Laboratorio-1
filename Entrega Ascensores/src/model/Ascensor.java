package model;
import java.util.*;

public class Ascensor {
    private ArrayList <Integer> viaje;
    private boolean up;
    private int pisoActual;

    public Ascensor(boolean up, int pisoActual) {
        this.up = up;
        this.pisoActual = pisoActual;
        viaje = new ArrayList<>();
    }

    public ArrayList<Integer> getViaje() {
        return viaje;
    }

    public boolean isUp() {
        return up;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void move(){
        if( this.up ) this.pisoActual ++;
        else this.pisoActual --;
    }
    
    public boolean addViaje( int p ){
        return this.viaje.add(p);
    }
    
    public void eraseViaje( int pos ){
        this.viaje.remove(pos);
    }
    
    public void clearViaje(){
        this.viaje.clear();
    }
    
}
