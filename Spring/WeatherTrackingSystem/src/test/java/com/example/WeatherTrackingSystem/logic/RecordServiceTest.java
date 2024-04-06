package com.example.WeatherTrackingSystem.logic;


import com.example.WeatherTrackingSystem.data.Record;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RecordServiceTest {

    @ParameterizedTest
    @MethodSource
    void getAVGTempForCertainLocation(List<Record> records, String location, LocalDate start, LocalDate end, OptionalDouble expected) {
        RecordService recordService = new RecordService();
        OptionalDouble averageTemperature = recordService.getAVGTempForCertainLocation(records, location, start, end);
        assertEquals(expected, averageTemperature);
    }

    static Stream<Arguments> getAVGTempForCertainLocation() {
        return Stream.of(
                Arguments.of(getRecords(), "Wien", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 7), OptionalDouble.of(-3.0)),
                Arguments.of(getRecords(), "", LocalDate.of(2024, 3, 1), LocalDate.of(2024, 5, 2), OptionalDouble.empty()),
                Arguments.of(getRecords(), "Madrid", LocalDate.of(2023, 12, 29), LocalDate.of(2024, 2, 1), OptionalDouble.empty()),
                Arguments.of(List.of(), "Wien", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 2, 1), OptionalDouble.empty()),
                Arguments.of(List.of(), "", LocalDate.of(2024, 3, 4), LocalDate.of(2024, 6, 1), OptionalDouble.empty())
        );
    }

    @ParameterizedTest
    @MethodSource
    void getHottestLocation(List<Record> records, Optional<String> expected) {
        RecordService recordService = new RecordService();
        Optional<String> hottestLocation = recordService.getHottestLocation(records);
        assertEquals(expected, hottestLocation);
    }

    static Stream<Arguments> getHottestLocation() {
        return Stream.of(
                Arguments.of(getRecords(), Optional.of("Wien")),
                Arguments.of(List.of(), Optional.empty())
        );
    }

    @ParameterizedTest
    @MethodSource
    void getRecordsWhereTemperatureAboveCertainThreshold(List<Record> records, double temperature, List<Record> expected) {
        RecordService recordService = new RecordService();
        List<Record> temperatureAboveCertainThreshold = recordService.getRecordsWhereTemperatureAboveCertainThreshold(records, temperature);
        assertEquals(expected, temperatureAboveCertainThreshold);
    }

    static Stream<Arguments> getRecordsWhereTemperatureAboveCertainThreshold() {
        return Stream.of(
                Arguments.of(getRecordsForHottestLocation(), 25.0, List.of(getRecordsForHottestLocation().get(3), getRecordsForHottestLocation().get(4),
                        getRecordsForHottestLocation().get(8), getRecordsForHottestLocation().get(9), getRecordsForHottestLocation().get(10))),
                Arguments.of(getRecordsForHottestLocation(), 100, List.of()),
                Arguments.of(List.of(), 15, List.of())
        );
    }

    static List<Record> getRecords() {
        return List.of(
                new Record("1", "Moskau", LocalDate.of(2024, 1, 1), -20.0),
                new Record("2", "Berlin", LocalDate.of(2024, 1, 1), -10.0),
                new Record("3", "Marakesh", LocalDate.of(2024, 1, 1), -20.0),
                new Record("4", "Buenos Aires", LocalDate.of(2024, 1, 1), -25.0),
                new Record("11", "Bali", LocalDate.of(2024, 1, 1), -35.0),
                new Record("5", "Wien", LocalDate.of(2024, 1, 1), -3.0),
                new Record("6", "Wien", LocalDate.of(2024, 1, 2), -6.0),
                new Record("7", "Wien", LocalDate.of(2024, 1, 3), -9.0),
                new Record("8", "Wien", LocalDate.of(2024, 1, 4), -20.0),
                new Record("9", "Wien", LocalDate.of(2024, 1, 5), -40.0),
                new Record("10", "Wien", LocalDate.of(2024, 1, 6), -50.0)
        );
    }

    static List<Record> getRecordsForHottestLocation() {
        return List.of(
                new Record("1", "Moskau", LocalDate.of(2024, 1, 1), -20.0),
                new Record("2", "Berlin", LocalDate.of(2024, 1, 1), -10.0),
                new Record("3", "Marakesh", LocalDate.of(2024, 1, 1), 20.0),
                new Record("4", "Buenos Aires", LocalDate.of(2024, 1, 1), 25.0),
                new Record("11", "Bali", LocalDate.of(2024, 1, 1), 35.0),
                new Record("5", "Wien", LocalDate.of(2024, 1, 1), -3.0),
                new Record("6", "Madrid", LocalDate.of(2024, 1, 2), 22.0),
                new Record("7", "Lisbon", LocalDate.of(2024, 1, 3), 23.0),
                new Record("8", "Antalya", LocalDate.of(2024, 1, 4), 25.0),
                new Record("9", "Sydney", LocalDate.of(2024, 1, 5), 30.0),
                new Record("10", "Dubai", LocalDate.of(2024, 1, 6), 35.0)
        );
    }
}