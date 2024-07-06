package bookingsystem;
import java.util.ArrayList;

public class Bus {
    private String busNumber;
    private int maxSeats;
    private int bookedSeats;
    private ArrayList<passenger> customers;

    public Bus(String busNumber, int maxSeats) {
        this.busNumber = busNumber;
        this.maxSeats = maxSeats;
        this.bookedSeats = 0;
        this.customers = new ArrayList<>();
    }

    public String busnum() {
        return busNumber;
    }

    public int max() {
        return maxSeats;
    }

    public int remseats() {
        return maxSeats - bookedSeats;
    }

    public boolean book(passenger customer) {
        if (bookedSeats < maxSeats) {
            bookedSeats++;
            customers.add(customer);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<passenger> getCustomers() {
        return customers;
    }
}
