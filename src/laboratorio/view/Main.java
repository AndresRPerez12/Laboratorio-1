package laboratorio.view;

import laboratorio.model.TravelAgency;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        String nombreAgencia = null;
        String nombrePrimerHotel = null;
        String direccionPrimerHotel = null;
        Date fechaInicioPrimerViaje = null;
        int duracionPV = 0;
        int numeroAgendaInicioPV = 0;
        Date fechaInicioSalidaPV = null;
        Date fechaInicioLlegadaPV = null;
        String aeropuertoInicioSalida = null;
        String aeropuertoInicioLlegada = null;
        int numeroAgendaVueltaPV = 0;
        Date fechaVueltaSalidaPV = null;
        Date fechaVueltaLlegadaPV = null;
        String aeropuertoVueltaSalida = null;
        String aeropuertoVueltaLlegada = null;
        String aeroUno = null;
        String aeroDos = null;
        String aeroTres = null;
        String aeroCuatro = null;
        
        Scanner sk = new Scanner(System.in);
        
        System.out.println("Ingrese el nombre de su agencia de viajes");
        nombreAgencia = readString(sk);
        System.out.println("Ingrese el primer hotel conocido de " + nombreAgencia);
        nombrePrimerHotel = readString(sk);
        System.out.println("Ingrese la dirección del hotel " + nombrePrimerHotel);
        direccionPrimerHotel = readString(sk);
        System.out.println("A continuación ingrese la fecha del primer viaje que ofrece " + nombreAgencia);
        fechaInicioPrimerViaje = readDate(sk);
        System.out.println("Ingrese la duración del primer viaje ofrecido por " + nombreAgencia);
        duracionPV = readInt(sk);
        System.out.println("Ingrese el número de vuelo para el primer viaje que ofrecerá " + nombreAgencia);
        numeroAgendaInicioPV = readInt(sk);
        System.out.println("A continuación ingrese la fecha de salida en ida para el vuelo " + numeroAgendaInicioPV);
        fechaInicioSalidaPV = readDate(sk);
        System.out.println("A continuación ingrese la fecha de llegada en ida para el vuelo " + numeroAgendaInicioPV);
        fechaInicioLlegadaPV = readDate(sk);
        System.out.println("Ingrese el aeropuerto de salida para el vuelo " + numeroAgendaInicioPV);
        aeropuertoInicioSalida = readString(sk);
        aeroUno = aeropuertoInicioSalida;
        System.out.println("Ingrese el aeropuerto de llegada para el vuelo " + numeroAgendaInicioPV);
        aeropuertoInicioLlegada = readString(sk);
        aeroDos = aeropuertoInicioLlegada;
        
        //TravelAgency agencia = new TravelAgency("Aviatur", "Fontanar",
        //                       "Cra. 21a #159a-28", getDate(22,03,2017), 30, 
        //                       1345, getDate(22,03,2017), getDate(22,03, 2017),
        //                       "José María Cordoba", "El Dorado",
        //                       0, null, null,
        //                       null, null, 
        //                       "José María Cordoba", "El Dorado", 
        //                       null, null);
        
        TravelAgency agencia = new TravelAgency(nombreAgencia, nombrePrimerHotel,
                               direccionPrimerHotel, fechaInicioPrimerViaje, duracionPV, 
                               numeroAgendaInicioPV, fechaInicioSalidaPV, fechaInicioLlegadaPV,
                               aeropuertoInicioSalida, aeropuertoInicioLlegada,
                               numeroAgendaVueltaPV, fechaVueltaSalidaPV, fechaVueltaLlegadaPV,
                               aeropuertoVueltaSalida, aeropuertoVueltaLlegada, 
                               aeroUno, aeroDos, 
                               aeroTres, aeroCuatro);
        
        System.out.println(agencia.listTravels());
        System.out.println("Longest : \n" + agencia.longestDurationS());
        System.out.println("Shortest : \n" + agencia.shortestDurationS());
    }
    
    public static String readString(Scanner sk){
        String str = "";
        while(str.equals(""))
            str = sk.nextLine();
        return str;
    }
    
    public static int readInt(Scanner sk){
        int i = -1;
        while(i == -1)
            try{
                i = sk.nextInt();
            }catch(Exception e){
                i = -1;
            }
        return i;
    }
    
    public static Date readDate(Scanner sk){
        int day;
        int month;
        int year;
        System.out.println("Ingrese el día");
        day = sk.nextInt();
        System.out.println("Ingrese el mes");
        month  = sk.nextInt();
        System.out.println("Ingrese el año");
        year  = sk.nextInt();
        return getDate(day, month, year);
    }
    
    public static Date getDate(int day, int month, int year){
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day);
        return new Date(c.getTimeInMillis());
    }
}