package logic;

import data.Appointment;
import data.Doctor;
import data.Patient;
import data.Specialization;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HospitalServiceTest {

    @ParameterizedTest
    @MethodSource("initialParameters")
    void getPatientsWIthAppointmentsBYCertainDoctor(List<Appointment> appointments, Doctor doctor, List<Patient> expected) {
        HospitalService hospitalService = new HospitalService();
        List<Patient> patients = hospitalService.getPatientsWIthAppointmentsBYCertainDoctor(appointments, doctor);
        assertEquals(expected, patients);
    }

    static Stream<Arguments> initialParameters() {
        return Stream.of(
                Arguments.of(List.of(
                                new Appointment(UUID.randomUUID(), LocalDate.now(), LocalTime.now(), new Doctor("Milos", Specialization.CARDIOLOGIST, 5), new Patient(1, "Milos", "1998")),
                                new Appointment(UUID.randomUUID(), LocalDate.now(), LocalTime.now(), new Doctor("Milos", Specialization.CARDIOLOGIST, 5), new Patient(2, "Stefana", "2000")),
                                new Appointment(UUID.randomUUID(), LocalDate.now(), LocalTime.now(), new Doctor("Milos", Specialization.CARDIOLOGIST, 5), new Patient(3, "Marina", "1994")),
                                new Appointment(UUID.randomUUID(), LocalDate.now(), LocalTime.now(), new Doctor("Max", Specialization.NEUROLOGIST, 5), new Patient(4, "Marko", "1987")),
                                new Appointment(UUID.randomUUID(), LocalDate.now(), LocalTime.now(), new Doctor("Max", Specialization.NEUROLOGIST, 5), new Patient(5, "Olja", "1979"))),
                        new Doctor("Milos", Specialization.CARDIOLOGIST, 5),
                        List.of(
                                new Patient(1, "Milos", "1998"),
                                new Patient(2, "Stefana", "2000"),
                                new Patient(3, "Marina", "1994"))),
                Arguments.of(List.of(), new Doctor("Milos", Specialization.CARDIOLOGIST, 5), List.of()),
                Arguments.of(List.of(
                                new Appointment(UUID.randomUUID(), LocalDate.now(), LocalTime.now(), new Doctor("Milos", Specialization.CARDIOLOGIST, 5), new Patient(1, "Milos", "1998")),
                                new Appointment(UUID.randomUUID(), LocalDate.now(), LocalTime.now(), new Doctor("Milos", Specialization.CARDIOLOGIST, 5), new Patient(2, "Stefana", "2000")),
                                new Appointment(UUID.randomUUID(), LocalDate.now(), LocalTime.now(), new Doctor("Milos", Specialization.CARDIOLOGIST, 5), new Patient(3, "Marina", "1994")),
                                new Appointment(UUID.randomUUID(), LocalDate.now(), LocalTime.now(), new Doctor("Max", Specialization.NEUROLOGIST, 5), new Patient(4, "Marko", "1987")),
                                new Appointment(UUID.randomUUID(), LocalDate.now(), LocalTime.now(), new Doctor("Max", Specialization.NEUROLOGIST, 5), new Patient(5, "Olja", "1979"))),
                        new Doctor("Pera", Specialization.DENTIST, 3), List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("initialAppointments")
    void patientWithMostAppointments(List<Appointment> appointments, Optional<Patient> expected) {
        HospitalService hospitalService = new HospitalService();
        Optional<Patient> patient = hospitalService.patientWithMostAppointments(appointments);
        assertEquals(expected, patient);
    }
    static Stream<Arguments> initialAppointments() {
        Patient p1 = new Patient(1, "Milos", "1998");
        Patient p2 = new Patient(2, "Stefana", "2000");
        Patient p3 = new Patient(3, "Marina", "1994");
        return Stream.of(
                Arguments.of(List.of(new Appointment(UUID.randomUUID(), LocalDate.now(), LocalTime.now(), new Doctor("Milos", Specialization.CARDIOLOGIST, 5), p1),
                        new Appointment(UUID.randomUUID(), LocalDate.now(), LocalTime.now(), new Doctor("Milos", Specialization.CARDIOLOGIST, 5), p2),
                        new Appointment(UUID.randomUUID(), LocalDate.now(), LocalTime.now(), new Doctor("Milos", Specialization.CARDIOLOGIST, 5), p3),
                        new Appointment(UUID.randomUUID(), LocalDate.now(), LocalTime.now(), new Doctor("Max", Specialization.NEUROLOGIST, 5), p1),
                        new Appointment(UUID.randomUUID(), LocalDate.now(), LocalTime.now(), new Doctor("Philip", Specialization.DERMATOLOGIST, 5), p1)),
                Optional.of(p1)),
                Arguments.of(List.of(), Optional.empty())
        );
    }
}