package model;
import java.util.*;

public class Piso {
    private int pisoActual;
    private Queue <Integer> pisoDestino;

    public Piso( int pisoActual ) {
        this.pisoActual = pisoActual;
        this.pisoDestino = new LinkedList<>();
    }

    public boolean goingDown (){
        if (pisoDestino.size() == 0) return false;
        return pisoDestino.peek() < pisoActual;
    }

    public boolean goingUp (){
        if (pisoDestino.size() == 0) return false;
        return pisoDestino.peek() > pisoActual;
    }
    
    public int popPiso(){
        return pisoDestino.peek();
    }
    
    public void removePersona(){
        pisoDestino.remove();
    }
    
    public boolean addPersona( int piso ){
        return pisoDestino.add(piso);
    }
    
    public int sizePiso(){
        return pisoDestino.size();
    }
    
}
