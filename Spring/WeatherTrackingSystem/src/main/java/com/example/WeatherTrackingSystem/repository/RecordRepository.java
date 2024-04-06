package com.example.WeatherTrackingSystem.repository;

import com.example.WeatherTrackingSystem.data.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordRepository {

    private final List<Record> records;

    public RecordRepository(List<Record> records) {
        this.records = records;
    }

    public Record add(Record record) {
        records.add(record);
        return record;
    }

    public List<Record> getRecords() {
        return records;
    }
}
