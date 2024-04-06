package logic;

import data.Appointment;
import data.Doctor;
import data.Patient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class HospitalService {
    public List<Patient> getPatientsWIthAppointmentsBYCertainDoctor(List<Appointment> appointments, Doctor doctor) {
        return appointments.stream()
                .filter(appointment -> appointment.doctor().equals(doctor))
                .map(Appointment::patient)
                .distinct()
                .collect(Collectors.toList());
    }

    public void makeAppointment(Patient patient, Doctor doctor, LocalDate date, LocalTime time) {
        Appointment appointment = new Appointment(UUID.randomUUID(), date, time, doctor, patient);
    }

    public Optional<Patient> patientWithMostAppointments(List<Appointment> appointments) {
        return appointments.stream()
                .collect(Collectors.groupingBy(Appointment::patient, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey);
    }
}
