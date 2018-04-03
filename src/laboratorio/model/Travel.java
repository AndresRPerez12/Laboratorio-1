package laboratorio.model;

import java.util.Date;

public class Travel{
    private Date start;
    private int duration;
    private Hotel hotel;
    private BookedFlight outbound_;
    private BookedFlight return_;

    public Travel(Airport outFrom, Airport outTo, Airport retFrom, Airport retTo) {
        this.outbound_ = new BookedFlight(outFrom, outTo);
        this.return_ = new BookedFlight(retFrom, retTo);
    }

    public Travel(Date start, int duration, Hotel hotel, Airport outFrom, Airport outTo, Airport retFrom, Airport retTo) {
        this.start = start;
        this.duration = duration;
        this.hotel = hotel;
        this.outbound_ = new BookedFlight(outFrom, outTo);
        this.return_ = new BookedFlight(retFrom, retTo);
    }
    
    public Travel(Date start, int duration, Hotel hotel, int outFlightNumber, Date outDeparture, Date outArrival, Airport outFrom, 
                        Airport outTo, int retFlightNumber, Date retDeparture, Date retArrival, Airport retFrom, Airport retTo) {
        this.start = start;
        this.duration = duration;
        this.hotel = hotel;
        this.outbound_ = new BookedFlight(outFlightNumber, outDeparture, outArrival, outFrom, outTo);
        this.return_ = new BookedFlight(retFlightNumber, retDeparture, retArrival, retFrom, retTo);
    }
    
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public BookedFlight getOutbound_() {
        return outbound_;
    }

    public void setOutbound_(int flightNumber, Date departure, Date arrival, Airport from, Airport to) {
        this.outbound_ = new BookedFlight(flightNumber, departure, arrival, from, to);
    }
    
    public void setOutbound_(int flightNumber, Date departure) {
        this.outbound_ = new BookedFlight(flightNumber, departure);
    }

    public BookedFlight getReturn_() {
        return return_;
    }

    public void setReturn_(int flightNumber, Date departure, Date arrival, Airport from, Airport to) {
        this.return_ = new BookedFlight(flightNumber, departure, arrival, from, to);
    }
    
    public void setReturn_(int flightNumber, Date departure) {
        this.return_ = new BookedFlight(flightNumber, departure);
    }
    
    public String getInfo(){
        return "\nStart Date : " + this.start.toString() +
               "\nTravel Duration : " + this.duration + "min" +
               "\nHotel info : " +
               "\nName : " + this.hotel.getName() +
               "\nAddress : " + this.hotel.getAddress() +
               "\nOut Bound Book: " + this.outbound_.getInfo() +
               "\nReturn book: " + this.return_.getInfo() + "\n";
    }
}