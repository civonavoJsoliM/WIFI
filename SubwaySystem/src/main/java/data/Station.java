package data;

public class Station {
    private final int id;
    private final String name;
    private final int timeBetweenStations;
    private Station stationLeft;
    private Station stationRight;

    public Station(int id, String name, int right) {
        this.id = id;
        this.name = name;
        this.timeBetweenStations = right;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTimeBetweenStations() {
        return timeBetweenStations;
    }

    public Station getStationLeft() {
        return stationLeft;
    }

    public void setStationLeft(Station stationLeft) {
        this.stationLeft = stationLeft;
    }

    public Station getStationRight() {
        return stationRight;
    }

    public void setStationRight(Station stationRight) {
        this.stationRight = stationRight;
    }
}
