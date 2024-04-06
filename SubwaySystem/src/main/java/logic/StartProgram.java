package logic;

import data.Station;
import logic.SubwayService.StationService;
import logic.FileService.FileReaderService;
import view.Printer;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StartProgram {
    public void run(String path, String start, String destination, LocalTime time) {

        FileReaderService fileReaderService = new FileReaderService();
        List<String> content = fileReaderService.readFile(path);
        StationService stationService = new StationService();
        List<Station> stations = stationService.getStation(content);
        stationService.getLeftAndRightChild(stations);
        List<Station> drivenStations = new ArrayList<>();
        MovementService movementService = new MovementService(stations, drivenStations);
        Printer printer = new Printer();
        List<Station> rodeStations;

        try {
            rodeStations = movementService.getDrivenStations(start, destination);
            printer.printRodeStations(rodeStations);
            int duration = movementService.getDriveDuration(rodeStations);
            printer.printRodeDuration(duration);
            String arriveTime = movementService.getArriveTime(rodeStations, time);
            printer.printArriveTime(arriveTime);
        } catch (NoSuchElementException e) {
            System.out.println("The stations you entered are not in the U6 schedule!");
        }

    }
}
