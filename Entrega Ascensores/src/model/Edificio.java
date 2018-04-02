package model;
import java.util.*;
import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class Edificio
{    
        public static City objetos;
        public static Robot ascensor1;
        public static Robot ascensor2;
        public static Thing th;
        private static int entradas;
        private static int salidas;
        private static Piso pisos [];
        private static Ascensor a1;
        private static Ascensor a2;
        
	public static void main (String[] args){
            objetos = new City("Field.txt");
	    objetos.showThingCounts(true);
            Scanner keyboard = new Scanner(System.in);
            
            System.out.println("Ingrese el piso inicial y la direccion del primer ascensor: ( true hacia arriba, false hacia abajo ) ");
            int p1 = keyboard.nextInt();
            boolean d1 = keyboard.nextBoolean();
            System.out.println("Ingrese el piso inicial y la direccion del segundo ascensor: ( true hacia arriba, false hacia abajo ) ");
            int p2 = keyboard.nextInt();
            boolean d2 = keyboard.nextBoolean();
            if( d1 ) ascensor1 = new Robot(objetos,9-p1, 0, Direction.NORTH,10);
            else ascensor1 = new Robot(objetos,9-p1, 0, Direction.SOUTH,10);
            if( d2 ) ascensor2 = new Robot(objetos,9-p2, 1, Direction.NORTH,10);
            else ascensor2 = new Robot(objetos,9-p2, 1, Direction.SOUTH,10);
            pisos = new Piso [11];
            for(int i = 0 ; i < 10 ; i ++)
                pisos[i] = new Piso (i);
            entradas = 0;
            salidas = 0;
            a1 = new Ascensor(d1,p1);
            a2 = new Ascensor(d2,p2);
            
            System.out.println("Ingrese el numero de personas que van a entrar al edificio: ");
            int n = keyboard.nextInt();
            System.out.println("Ingrese el piso en el que inicia cada persona y luego al que va cada persona: ");
            for( int i = 0 ; i < n ; i ++ ){
                int pf = keyboard.nextInt();
                int pt = keyboard.nextInt();
                th = new Thing(objetos,9-pf,2 + pisos[pf].sizePiso() );
                pisos[pf].addPersona(pt);
            }
            //System.out.println("ENDS READ");
            runAscensores(n);
	    
	}
        
        static void runAscensores ( int n ){
            while( salidas < n ){
                if( a1.isUp() ){
                    if( a1.getPisoActual() == 9 ){
                        a1.setUp(false);
                        turn(1,2);
                        continue;
                    }
                    for( int i = 0 ; i < a1.getViaje().size() ; i ++ ){
                        if( a1.getViaje().get(i) == a1.getPisoActual() ){
                            a1.eraseViaje(i);
                            i --;
                            leavePersona(1);
                            pisos[a1.getPisoActual()].addPersona(0);
                        }
                    }
                    while( a1.getViaje().size() < 5 && pisos[a1.getPisoActual()].goingUp() ){
                        a1.addViaje( pisos[a1.getPisoActual()].popPiso() );
                        pisos[ a1.getPisoActual() ].removePersona();
                        pickPersona(1);
                    }
                    a1.move();
                    ascensor1.move();
                }else{
                    if( a1.getPisoActual() == 0 ){
                        a1.setUp(true);
                        turn(1,2);
                        salidas += a1.getViaje().size();
                        a1.clearViaje();
                        continue;
                    }
                    for( int i = 0 ; i < a1.getViaje().size() ; i ++ ){
                        if( a1.getViaje().get(i) == a1.getPisoActual() ){
                            a1.eraseViaje(i);
                            i --;
                            leavePersona(1);
                            pisos[a1.getPisoActual()].addPersona(0);
                        }
                    }
                    while( a1.getViaje().size() < 5 && pisos[ a1.getPisoActual() ].goingDown() ){
                        a1.addViaje( pisos[a1.getPisoActual()].popPiso() );
                        pisos[ a1.getPisoActual() ].removePersona();
                        pickPersona(1);
                    }
                    a1.move();
                    ascensor1.move();
                }
                if( a2.isUp() ){
                    if( a2.getPisoActual() == 9 ){
                        a2.setUp(false);
                        turn(2,2);
                        continue;
                    }
                    for( int i = 0 ; i < a2.getViaje().size() ; i ++ ){
                        if( a2.getViaje().get(i) == a2.getPisoActual() ){
                            a2.eraseViaje(i);
                            i --;
                            leavePersona(2);
                            pisos[a2.getPisoActual()].addPersona(0);
                        }
                    }
                    while( a2.getViaje().size() < 5 && pisos[a2.getPisoActual()].goingUp() ){
                        a2.addViaje(pisos[ a2.getPisoActual() ].popPiso());
                        pisos[ a2.getPisoActual() ].removePersona();
                        pickPersona(2);
                    }
                    a2.move();
                    ascensor2.move();
                }else{
                    if( a2.getPisoActual() == 0 ){
                        a2.setUp(true);
                        turn(2,2);
                        salidas += a2.getViaje().size();
                        a2.clearViaje();
                        continue;
                    }
                    for( int i = 0 ; i < a2.getViaje().size() ; i ++ ){
                        if( a2.getViaje().get(i) == a2.getPisoActual() ){
                            a2.eraseViaje(i);
                            i --;
                            leavePersona(2);
                            pisos[a2.getPisoActual()].addPersona(0);
                        }
                    }
                    while( a2.getViaje().size() < 5 && pisos[a2.getPisoActual()].goingDown() ){
                        a2.addViaje(pisos[ a2.getPisoActual() ].popPiso());
                        pisos[ a2.getPisoActual() ].removePersona();
                        pickPersona(2);
                    }
                    a2.move();
                    ascensor2.move();
                }
                
            }
        }
        
        static void pickPersona ( int x ){
            if( x == 1 ){
                int t;
                if( a1.isUp() ) t = 3;
                else t = 1;
                turn(1,t);
                int c = 0;
                while( !ascensor1.canPickThing() ){
                    ascensor1.move();
                    c ++;
                }
                ascensor1.pickThing();
                turn(1,2);
                for( int i = 0 ; i < c ; i ++ )
                    ascensor1.move();
                turn(1,t);
            }else{
                int t;
                if( a2.isUp() ) t = 3;
                else t = 1;
                turn(2,t);
                int c = 0;
                while( !ascensor2.canPickThing() ){
                    ascensor2.move();
                    c ++;
                }
                ascensor2.pickThing();
                turn(2,2);
                for( int i = 0 ; i < c ; i ++ )
                    ascensor2.move();
                turn(2,t);
            }
        }
        
        static void leavePersona ( int x ){
            if( x == 1 ){
                int t;
                if( a1.isUp() ) t = 3;
                else t = 1;
                turn(1,t);
                ascensor1.move();
                ascensor1.move();
                int c = 0;
                while( ascensor1.canPickThing() ){
                    ascensor1.move();
                    c ++;
                }
                ascensor1.putThing();
                turn(1,2);
                for( int i = 0 ; i < c+2 ; i ++ )
                    ascensor1.move();
                turn(1,t);
            }else{
                int t;
                if( a2.isUp() ) t = 3;
                else t = 1;
                turn(2,t);
                ascensor2.move();
                int c = 0;
                while( ascensor2.canPickThing() ){
                    ascensor2.move();
                    c ++;
                }
                ascensor2.putThing();
                turn(2,2);
                for( int i = 0 ; i < c+1 ; i ++ )
                    ascensor2.move();
                turn(2,t);
            }
        }
        
        public static void turn ( int a , int x ){
            if( a == 1 ){
                for( int i = 0 ; i < x ; i ++ )
                    ascensor1.turnLeft();
            }else{
                for( int i = 0 ; i < x ; i ++ )
                    ascensor2.turnLeft();
            }
            
        }
}

