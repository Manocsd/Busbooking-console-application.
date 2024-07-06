package bookingsystem;
import java.util.*;

public class demo {
    private ArrayList<Bus> bus;

    public demo() {
        bus = new ArrayList<>();
    }
    public void add(Bus b) {
        bus.add(b);
    }

    public void view() {
        for (Bus b : bus) {
            System.out.println("BUS NUMBER: " + b.busnum() + "    BUS CAPACITY: " + b.max() + "   BUS AVAILABLE SEATS: " + b.remseats());
        }
    }

    public boolean book(String num, passenger customer) {
        for (Bus b : bus) {
            if (num.equals(b.busnum())) {
                return b.book(customer);
            }
        }
        return false;
    }

    public void available(String num) {
        for (Bus b : bus) {
            if (num.equals(b.busnum())) {
                System.out.println("BUS NUMBER: " + num + " AVAILABLE SEATS: " + b.remseats());
                return;
            }
        }
        System.out.println("BUS NUMBER NOT FOUND.............");
    }

    public void viewCustomers(String num) {
        for (Bus b : bus) {
            if (num.equals(b.busnum())) {
                ArrayList<passenger> customers = b.getCustomers();
                if (customers.isEmpty()) {
                    System.out.println("No customers booked on bus number " + num);
                } else {
                    System.out.println("Customers on bus number " + num + ":");
                    for (passenger c : customers) {
                        System.out.println(c.toString());
                    }
                }
                return;
            }
        }
        System.out.println("BUS NUMBER NOT FOUND.............");
    }

    public static void main(String[] args) {
        demo access = new demo();
        Scanner in = new Scanner(System.in);
        access.add(new Bus("A101", 50));
        access.add(new Bus("A102", 60));
        access.add(new Bus("B101", 80));
        access.add(new Bus("B102", 30));

        boolean flag = true;
        while (flag) {
            System.out.println("1. View Buses.");
            System.out.println("2. Book Ticket.");
            System.out.println("3. Available Ticket.");
            System.out.println("4. View Booked Customers.");
            System.out.println("5. Exit.");
            System.out.print("Enter the option: ");
            String n = in.nextLine();
//            in.nextLine(); 
            switch (n) {
                case "1": {
                    access.view();
                    break;
                }
                case "2": {
                    System.out.println("ENTER THE BUS NUMBER TO BOOK SEATS: ");
                    String num = in.nextLine();
                    System.out.println("ENTER CUSTOMER NAME: ");
                    String name = in.nextLine();
                    System.out.println("ENTER CUSTOMER CONTACT: ");
                    String contact = in.nextLine();
                    passenger customer = new passenger(name, contact);
                    if (access.book(num, customer)) {
                        System.out.println("Booked successfully............");
                    } else {
                        System.out.println("Error....try again later or check bus number or available seats.");
                    }
                    break;
                }
                case "3": {
                    System.out.println("ENTER THE BUS NUMBER TO SEE THE AVAILABLE SEATS: ");
                    String num = in.nextLine();
                    access.available(num);
                    break;
                }
                case "4": {
                    System.out.println("ENTER THE BUS NUMBER TO SEE THE BOOKED CUSTOMERS: ");
                    String num = in.nextLine();
                    access.viewCustomers(num);
                    break;
                }
                case "5": {
                    System.out.println("Exited..........");
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("You have entered an Invalid option");
                    System.out.println("Try again");
                }
            }
        }
        in.close();
    }
}
