package logic.SubwayService;

import data.Station;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StationService {
    public List<Station> getStation(List<String> content) {
        String jointContent = String.join("\n", content);
        String[] contentInArray = jointContent.split("\n{2}");
        return Arrays.stream(contentInArray)
                .map(cont -> new Station(Integer.parseInt(cont.split(":\\s\"|\"\\s|\"$")[1]),
                        cont.split(":\\s\"|\"\\s|\"$")[3],
                        Integer.parseInt(cont.split(":\\s\"|\"\\s|\"$")[9])))
                .collect(Collectors.toList());
    }

    public void getLeftAndRightChild(List<Station> stations) {
        for (int i = 0; i < stations.size(); i++) {
            if (i == 0) {
                stations.get(i).setStationLeft(null);
                stations.get(i).setStationRight(stations.get(i + 1));
            } else if (i == (stations.size() - 1)) {
                stations.get(i).setStationLeft(stations.get(i - 1));
                stations.get(i).setStationRight(null);
            } else {
                stations.get(i).setStationLeft(stations.get(i - 1));
                stations.get(i).setStationRight(stations.get(i + 1));
            }
        }
    }

}