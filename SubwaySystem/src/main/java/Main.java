import logic.StartProgram;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        StartProgram startProgram = new StartProgram();
        startProgram.run("/Users/ipoce/Desktop/JAVA KURS/Files/FileHandling/SubwaySystem/SubwaySchedule.txt",
                "Floridsdorf",
                "Spittelau",
                LocalTime.now());
    }
}
