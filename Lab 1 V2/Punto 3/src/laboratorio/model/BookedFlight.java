package laboratorio.model;

import java.util.Date;

public class BookedFlight{
    private int flightNumber;
    private Date departure;
    private Date arrival;
    private Airport from;
    private Airport to;

    public BookedFlight(Airport from, Airport to) {
        this.from = from;
        this.to = to;
    }

    public BookedFlight(int flightNumber, Date departure) {
        this.flightNumber = flightNumber;
        this.departure = departure;
    }

    public BookedFlight(int flightNumber, Date departure, Date arrival, Airport from, Airport to) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.from = from;
        this.to = to;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public Airport getFrom() {
        return from;
    }

    public void setFrom(Airport from) {
        this.from = from;
    }

    public Airport getTo() {
        return to;
    }

    public void setTo(Airport to) {
        this.to = to;
    }
    
    public String getInfo(){
        return "\nBook flight number: " + this.flightNumber +
               "\nFrom:\n" + this.from.getDescription() +
               "\nTo:\n" + this.to.getDescription() + "\n";
    }
}