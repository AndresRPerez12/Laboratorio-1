package laboratorio.model;

import java.util.Date;

public class TravelAgency{
    private String name;
    private Hotel knownHotels[];
    private Airport airports[];
    private Travel offeredTravels[];

    public TravelAgency(String hotelName, String hotelAddress, Date travelStDate, 
                        int travelDuration, String outFrom, String outTo, String retFrom, 
                        String retTo, String firstAir, String secondAir, String thirdAir, 
                        String fourthAir) {
        this.knownHotels = new Hotel[5];
        this.knownHotels[0] = new Hotel(hotelName, hotelAddress);
        this.airports = new Airport[4];
        this.airports[0] = new Airport(firstAir);
        this.airports[1] = new Airport(firstAir);
        this.airports[2] = new Airport(firstAir);
        this.airports[3] = new Airport(firstAir);
        this.offeredTravels = new Travel[10];
        this.offeredTravels[0] = new Travel(travelStDate, travelDuration, 
                                            new Hotel(hotelName, hotelAddress), 
                                            new Airport(outFrom), new Airport(outTo), 
                                            new Airport(retFrom), new Airport(retTo));
    }
    
    public TravelAgency(String hotelName, String hotelAddress, Date travelStDate, 
                        int travelDuration, String outFrom, String outTo, String retFrom, 
                        String retTo, String[] airports) {
        this.knownHotels = new Hotel[5];
        this.knownHotels[0] = new Hotel(hotelName, hotelAddress);
        this.airports = new Airport[4];
        for(int i = 0; i<4; i++)
            if(airports[i] != null)
                this.airports[i] = new Airport(airports[i]);
        this.offeredTravels = new Travel[10];
        this.offeredTravels[0] = new Travel(travelStDate, travelDuration, 
                                            new Hotel(hotelName, hotelAddress), 
                                            new Airport(outFrom), new Airport(outTo), 
                                            new Airport(retFrom), new Airport(retTo));
    }

    public TravelAgency(String name, String hotelName, String hotelAddress, 
                        Date travelStDate, int travelDuration, String outFrom, 
                        String outTo, String retFrom, String retTo, String firstAir, 
                        String secondAir, String thirdAir, String fourthAir) {
        this.name = name;
        this.knownHotels = new Hotel[5];
        this.knownHotels[0] = new Hotel(hotelName, hotelAddress);
        this.airports = new Airport[4];
        this.airports[0] = new Airport(firstAir);
        this.airports[1] = new Airport(firstAir);
        this.airports[2] = new Airport(firstAir);
        this.airports[3] = new Airport(firstAir);
        this.offeredTravels = new Travel[10];
        this.offeredTravels[0] = new Travel(travelStDate, travelDuration, 
                                            new Hotel(hotelName, hotelAddress), 
                                            new Airport(outFrom), new Airport(outTo), 
                                            new Airport(retFrom), new Airport(retTo));
    }
    
    public TravelAgency(String name, String hotelName, String hotelAddress, 
                        Date travelStDate, int travelDuration, String outFrom, 
                        String outTo, String retFrom, String retTo, String[] airports) {
        this.name = name;
        this.knownHotels = new Hotel[5];
        this.knownHotels[0] = new Hotel(hotelName, hotelAddress);
        this.airports = new Airport[4];
        for(int i = 0; i<4; i++)
            if(airports[i] != null)
                this.airports[i] = new Airport(airports[i]);
        this.offeredTravels = new Travel[10];
        this.offeredTravels[0] = new Travel(travelStDate, travelDuration, 
                                            new Hotel(hotelName, hotelAddress), 
                                            new Airport(outFrom), new Airport(outTo), 
                                            new Airport(retFrom), new Airport(retTo));
    }
    
    public TravelAgency(String name, String hotelName, String hotelAddress, 
                        Date travelStDate, int travelDuration, int outFlightNumber, Date outDeparture, Date outArrival, String outFrom, 
                        String outTo, int retFlightNumber, Date retDeparture, Date retArrival, String retFrom, String retTo, String firstAir, 
                        String secondAir, String thirdAir, String fourthAir) {
        this.name = name;
        this.knownHotels = new Hotel[5];
        this.knownHotels[0] = new Hotel(hotelName, hotelAddress);
        this.airports = new Airport[4];
        this.airports[0] = new Airport(firstAir);
        this.airports[1] = new Airport(firstAir);
        this.airports[2] = new Airport(firstAir);
        this.airports[3] = new Airport(firstAir);
        this.offeredTravels = new Travel[10];
        this.offeredTravels[0] = new Travel(travelStDate, travelDuration, 
                                            new Hotel(hotelName, hotelAddress), 
                                            outFlightNumber, outDeparture, outArrival,
                                            new Airport(outFrom), new Airport(outTo),
                                            retFlightNumber, retDeparture, retArrival,
                                            new Airport(retFrom), new Airport(retTo));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hotel[] getKnownHotels() {
        return knownHotels;
    }
    
    public boolean addKnownHotel(String name, String address) {
        boolean ver = false;
        for(int i = 0; i<5; i++)
            if(this.knownHotels[i] == null){
                this.knownHotels[i] = new Hotel(name, address);
                ver = true;
                break;
            }else if(name.equals(this.knownHotels[i].getName()) && address.equals(this.knownHotels[i].getAddress())){
                    break;
            }
        return ver;
    }

    public Airport[] getAirports() {
        return airports;
    }
    
    public Travel[] getOfferedTravels(){
        return this.offeredTravels;
    }
    
    public boolean addOfferedTravel(Date start, int duration, Hotel hotel, 
                                    String outFrom, String outTo, String retFrom, 
                                    String retTo) {
        boolean ver = false;
        for(int i = 0; i<10; i++)
            if(this.offeredTravels[i] == null){
                this.offeredTravels[i] = new Travel(start, duration,
                                                    hotel, new Airport(outFrom), new Airport(outTo),
                                                    new Airport(retFrom), new Airport(retTo));
                ver = true;
                break;
            }else if(this.offeredTravels[i].getStart().equals(start) && this.offeredTravels[i].getDuration() == duration && 
                     this.offeredTravels[i].getHotel().getName().equals(hotel.getName()) && 
                     this.offeredTravels[i].getHotel().getAddress().equals(hotel.getAddress()) && 
                     this.offeredTravels[i].getOutbound_().getFrom().getDescription().equals(outFrom) && 
                     this.offeredTravels[i].getOutbound_().getTo().getDescription().equals(outTo) && 
                     this.offeredTravels[i].getReturn_().getFrom().getDescription().equals(retFrom) && 
                     this.offeredTravels[i].getReturn_().getTo().getDescription().equals(retTo)){
                break;
            }
        return ver;
    }
    
    public boolean addOfferedTravel(Date start, int duration, Hotel hotel, int outFlightNumber, Date outDeparture, Date outArrival, String outFrom, 
                        String outTo, int retFlightNumber, Date retDeparture, Date retArrival, String retFrom, String retTo) {
        boolean ver = false;
        for(int i = 0; i<10; i++)
            if(this.offeredTravels[i] == null){
                this.offeredTravels[i] = new Travel(start, duration,
                                                    hotel,
                                                    outFlightNumber, outDeparture,
                                                    outArrival,
                                                    new Airport(outFrom), new Airport(outTo),
                                                    retFlightNumber, retDeparture,
                                                    retArrival,
                                                    new Airport(retFrom), new Airport(retTo));
                ver = true;
                break;
            }else if(this.offeredTravels[i].getOutbound_().getFlightNumber() == outFlightNumber || this.offeredTravels[i].getReturn_().getFlightNumber() == retFlightNumber){
                break;
            }
        return ver;
    }
    
    public boolean addOfferedTravel(Date start, int duration, 
                                    Hotel hotel, String[] info) {
        boolean ver = false;
        if(info.length == 4)
            for(int i = 0; i<10; i++)
                if(this.offeredTravels[i] == null){
                    this.offeredTravels[i] = new Travel(start, duration,
                                                        hotel, new Airport(info[0]), new Airport(info[1]),
                                                        new Airport(info[2]), new Airport(info[3]));
                    ver = true;
                    break;
                }else if(this.offeredTravels[i].getStart().equals(start) && this.offeredTravels[i].getDuration() == duration && 
                     this.offeredTravels[i].getHotel().getName().equals(hotel.getName()) && 
                     this.offeredTravels[i].getHotel().getAddress().equals(hotel.getAddress()) && 
                     this.offeredTravels[i].getOutbound_().getFrom().getDescription().equals(info[0]) && 
                     this.offeredTravels[i].getOutbound_().getTo().getDescription().equals(info[1]) && 
                     this.offeredTravels[i].getReturn_().getFrom().getDescription().equals(info[2]) && 
                     this.offeredTravels[i].getReturn_().getTo().getDescription().equals(info[3])){
                break;
            }
        return ver;
    }

    public String listTravels(){
        String out = "\nOffered travels.\n\n";
        for(Travel t : this.offeredTravels)
            if(t != null)
                out += t.getInfo();
        return out;
    }

    public String longestDurationS(){
        int i = 0;
	for(int j = 1; j < 10; j++)
            if(offeredTravels[j] != null){
                if(offeredTravels[j].getDuration() > offeredTravels[i].getDuration())
                    i = j;
            }else{
                break;
            }     
        return this.offeredTravels[i].getInfo();
    }

    public Travel longestDurationT(){
        int i = 0;
	for(int j = 1; j < 10; j++)
            if(offeredTravels[j] != null){
                if(offeredTravels[j].getDuration() > offeredTravels[i].getDuration())
                    i = j;
            }else{
                break;
            }     
        return this.offeredTravels[i];
    }
    
    public String shortestDurationS(){
        int i = 0;
        for(int j = 1; j < 10; j++)
            if(offeredTravels[j] != null){
                if(offeredTravels[j].getDuration() < offeredTravels[i].getDuration())
                    i = j;
            }else{
                break;
            }     
        return this.offeredTravels[i].getInfo();
    }
    
    public Travel shortestDurationT(){
        int i = 0;
        for(int j = 1; j < 10; j++)
            if(offeredTravels[j] != null){
                if(offeredTravels[j].getDuration() < offeredTravels[i].getDuration())
                    i = j;
            }else{
                break;
            }     
        return this.offeredTravels[i];
    }
}