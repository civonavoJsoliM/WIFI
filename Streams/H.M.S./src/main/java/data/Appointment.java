package data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record Appointment(UUID id, LocalDate date, LocalTime time, Doctor doctor, Patient patient) {
}
