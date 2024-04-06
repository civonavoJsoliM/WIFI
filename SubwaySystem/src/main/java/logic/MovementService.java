package logic;

import data.Station;
import data.EndStation;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

public class MovementService {
    private final List<Station> stations;
    private List<Station> drivenStations;

    public MovementService(List<Station> stations, List<Station> drivenStations) {
        this.stations = stations;
        this.drivenStations = drivenStations;
    }

    public List<Station> getDrivenStations(String start, String destination) {
        Station startStation = stations.stream().filter(station -> station.getName().equals(start)).findFirst().get();
        Station targetStation = stations.stream().filter(station -> station.getName().equals(destination)).findFirst().get();
            if (startStation.getId() == targetStation.getId()) {
                return drivenStations;
            } else if (startStation.getId() > targetStation.getId()) {
                drivenStations.add(startStation.getStationLeft());
                if (startStation.getStationLeft().equals(targetStation)) {
                    return drivenStations;
                }
                drivenStations = getDrivenStations(startStation.getStationLeft().getName(), destination);
            } else if (startStation.getId() < targetStation.getId()) {
                drivenStations.add(startStation.getStationRight());
                if (startStation.getStationRight().equals(targetStation)) {
                    return drivenStations;
                }
                drivenStations = getDrivenStations(startStation.getStationRight().getName(), destination);
            }
        return drivenStations;
    }
    
    public int getDriveDuration(List<Station> rodeStations) {
        rodeStations.remove(rodeStations.get(rodeStations.size()-1));
        return rodeStations.stream()
                .filter(station -> !station.getName().equalsIgnoreCase(EndStation.FLORIDSDORF.name()))
                .filter(station -> !station.getName().equalsIgnoreCase(EndStation.SIEBENHIRTEN.name()))
                //.peek(System.out::println)
                .mapToInt(station -> station.getTimeBetweenStations() + 1)
                .sum();
    }

    public String getArriveTime(List<Station> rodeStations, LocalTime time) {
        int duration = rodeStations.stream().
                filter(station -> !station.getName().equalsIgnoreCase(EndStation.FLORIDSDORF.name())).
                filter(station -> !station.getName().equalsIgnoreCase(EndStation.SIEBENHIRTEN.name()))
                .mapToInt(station -> station.getTimeBetweenStations() + 1).sum();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        return time.plusMinutes(duration).format(formatter);
    }
}

