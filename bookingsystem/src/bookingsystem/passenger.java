package bookingsystem;

public class passenger {
    private String name;
    private String contact;
    private String id;

    public passenger(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }
    public String getid() {
    	return id;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', contact='" + contact + "'}";
    }
}
