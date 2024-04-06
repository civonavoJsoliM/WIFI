package com.example.WeatherTrackingSystem.logic;

import com.example.WeatherTrackingSystem.data.Record;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
public class RecordService {

    public OptionalDouble getAVGTempForCertainLocation(List<Record> records, String location, LocalDate start, LocalDate end) {
        return records.stream()
                .filter(record -> record.location().equals(location))
                .filter(record -> isDateEqualsOrAfterStart(record, start) && isDateEqualsOrBeginEnd(record, end))
                .mapToDouble(Record::temperature)
                .average();
    }
    private boolean isDateEqualsOrAfterStart(Record record, LocalDate start) {
        return record.date().isAfter(start) || record.date().isEqual(start);
    }
    private boolean isDateEqualsOrBeginEnd(Record record, LocalDate end) {
        return record.date().isBefore(end) || record.date().isEqual(end);
    }

    public Optional<String> getHottestLocation(List<Record> records) {
        return records.stream()
                .sorted(Comparator.comparingDouble(Record::temperature).reversed())
                .map(Record::location)
                .findFirst();
    }

    public List<Record> getRecordsWhereTemperatureAboveCertainThreshold(List<Record> records, double temperature) {
        return records.stream()
                .filter(record -> record.temperature() >= temperature)
                .toList();
    }

}
