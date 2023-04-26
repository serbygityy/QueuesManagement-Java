package dataModel;

public class Client {
    private final int id;
    private final int arrival;
    private  int service;

    public Client(int id, int arrival, int service) {
        this.id = id;
        this.arrival = arrival;
        this.service = service;
    }

    public int getArrival() {
        return arrival;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", arrival=" + arrival +
                ", service=" + service +
                '}';
    }

}
