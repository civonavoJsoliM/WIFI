package com.example.CourseRegistrationSystem.logic;

import com.example.CourseRegistrationSystem.data.Course;
import com.example.CourseRegistrationSystem.data.Registration;
import com.example.CourseRegistrationSystem.data.Student;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegistrationServiceTest {

    @ParameterizedTest
    @MethodSource
    void getCoursesFromCertainDepartment(List<Course> courses, String department, List<Course> expected) {
        RegistrationService registrationService = new RegistrationService();
        List<Course> coursesFromCertainDepartment = registrationService.getCoursesFromCertainDepartment(courses, department);
        assertEquals(expected, coursesFromCertainDepartment);
    }

    static Stream<Arguments> getCoursesFromCertainDepartment() {
        return Stream.of(
                Arguments.of(getCourses(), "Mathematik", List.of(getCourses().get(0), getCourses().get(2))),
                Arguments.of(getCourses(), "Naturwissenschaften", List.of(getCourses().get(1), getCourses().get(7), getCourses().get(8))),
                Arguments.of(getCourses(), "", List.of()),
                Arguments.of(List.of(), "", List.of()),
                Arguments.of(getCourses(), "Sprachen", List.of(getCourses().get(4), getCourses().get(5), getCourses().get(6), getCourses().get(9))),
                Arguments.of(getCourses(), "Sport", List.of())
        );
    }

    @ParameterizedTest
    @MethodSource
    void getStudentWithMostCreditsForAGivenSemester(List<Registration> registrations, String semester, Optional<Map.Entry<Student, Integer>> expected) {
        RegistrationService registrationService = new RegistrationService();
        Optional<Map.Entry<Student, Integer>> student = registrationService.getStudentWithMostCreditsForAGivenSemester(registrations, semester);
        assertEquals(expected, student);
    }

    static Stream<Arguments> getStudentWithMostCreditsForAGivenSemester() {
        return Stream.of(
                Arguments.of(getRegistrations(), "WS_2023", Optional.of(new AbstractMap.SimpleEntry<>(getStudents().get(1), 190))),
                Arguments.of(List.of(), "", Optional.empty()),
                Arguments.of(List.of(), "", Optional.empty()),
                Arguments.of(getRegistrations(), "", Optional.empty()),
                Arguments.of(getRegistrations(), "SS_2024", Optional.of(new AbstractMap.SimpleEntry<>(getStudents().get(3), 100) {
                }))
        );
    }

    @ParameterizedTest
    @MethodSource
    void getStudentsRegisteredForCertainCourse(List<Registration> registrations, String course, List<Student> expected) {
        RegistrationService registrationService = new RegistrationService();
        List<Student> students = registrationService.getStudentsRegisteredForCertainCourse(registrations, course);
        assertEquals(expected, students);
    }
    static Stream<Arguments> getStudentsRegisteredForCertainCourse() {
        return Stream.of(
                Arguments.of(getRegistrations(), getCourses().get(0).name(), List.of(getStudents().get(0), getStudents().get(1), getStudents().get(2))),
                Arguments.of(getRegistrations(), "", List.of()),
                Arguments.of(getRegistrations(), "Sport", List.of()),
                Arguments.of(List.of(), "", List.of()),
                Arguments.of(List.of(), getCourses().get(0).name(), List.of()),
                Arguments.of(getRegistrations(), getCourses().get(1).name(), List.of(getStudents().get(3), getStudents().get(4)))
        );
    }

    private static List<Course> getCourses() {
        return List.of(
                new Course("1", "Algebra", "Mathematik", 100),
                new Course("2", "Biologie", "Naturwissenschaften", 30),
                new Course("3", "Angewandte Mathematik", "Mathematik", 80),
                new Course("4", "Proggramieren", "Informatik", 90),
                new Course("5", "Deutsch", "Sprachen", 40),
                new Course("6", "Englisch", "Sprachen", 40),
                new Course("7", "Spanisch", "Sprachen", 40),
                new Course("8", "Chemie", "Naturwissenschaften", 70),
                new Course("9", "Physik", "Naturwissenschaften", 70),
                new Course("10", "Französisch", "Sprachen", 30));
    }
    private static List<Registration> getRegistrations() {
        return List.of(
                new Registration("1", getStudents().get(0), getCourses().get(0),"WS_2023"),
                new Registration("2", getStudents().get(1), getCourses().get(0),"WS_2023"),
                new Registration("3", getStudents().get(2), getCourses().get(0), "WS_2023"),
                new Registration("4", getStudents().get(3), getCourses().get(1), "SS_2024"),
                new Registration("5", getStudents().get(4), getCourses().get(1), "SS_2024"),
                new Registration("6", getStudents().get(5), getCourses().get(2), "WS_2023"),
                new Registration("7", getStudents().get(6), getCourses().get(2), "WS_2023"),
                new Registration("8", getStudents().get(0), getCourses().get(3), "SS_2024"),
                new Registration("9", getStudents().get(1), getCourses().get(3), "WS_2023"),
                new Registration("10", getStudents().get(2), getCourses().get(4), "SS_2024"),
                new Registration("11", getStudents().get(3), getCourses().get(7), "SS_2024"),
                new Registration("12", getStudents().get(4), getCourses().get(4), "WS_2023"),
                new Registration("13", getStudents().get(5), getCourses().get(4), "WS_2023"),
                new Registration("14", getStudents().get(6), getCourses().get(4), "SS_2024")
        );
    }
    private static List<Student> getStudents() {
        return List.of(
                new Student("1", "Max", "Mathematik"),
                new Student("2", "Franz", "Informatik"),
                new Student("3", "Phillip", "Sprachen"),
                new Student("4", "Peter", "Mathematik"),
                new Student("5", "Hans", "Mathematik"),
                new Student("6", "Hans-Peter", "Naturwissenschaften"),
                new Student("7", "Patrick", "Naturwisseschaften")
        );
    }
}