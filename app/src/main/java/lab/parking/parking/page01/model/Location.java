package lab.parking.parking.page01.model;

public class Location {

    private int id;
    private String name;
    private int distance;
    private int available;

    public Location(int id, String name, int distance, int available) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
