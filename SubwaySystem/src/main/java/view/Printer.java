package view;

import data.EndStation;
import data.Station;

import java.util.List;

public class Printer {
    public void printRodeStations(List<Station> rodeStations) {
        System.out.println("Stations you have to ride: ");
        for (int i = 0; i < rodeStations.size(); i++) {
            if (rodeStations.get(i).getName().equalsIgnoreCase(EndStation.SIEBENHIRTEN.name()) ||
                    rodeStations.get(i).getName().equalsIgnoreCase(EndStation.FLORIDSDORF.name())) {
                System.out.printf("Terminus: %s\n\n", rodeStations.get(i).getName());
            } else {
                if (i == (rodeStations.size() - 1)) {
                    System.out.printf("Destination: %s\n\n", rodeStations.get(i).getName());
                } else {
                    System.out.printf("Station: %s | Minutes till next station: %d\n", rodeStations.get(i).getName(), rodeStations.get(i).getTimeBetweenStations());
                }
            }
        }
    }

    public void printRodeDuration(int duration) {
        System.out.printf("The total duration of the ride is: %d min\n\n", duration);
    }

    public void printArriveTime(String arriveTime) {
        System.out.printf("You arrive at the destination at: %sh", arriveTime);
    }
}
