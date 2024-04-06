package com.example.CustomerFeedbackSystem.logic;



import com.example.CustomerFeedbackSystem.data.Feedback;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackServiceTest {

    @ParameterizedTest
    @MethodSource
    void getFeedbacksAboveCertainRating(List<Feedback> feedbacks, int rating, List<Feedback> expected) {
        FeedbackService feedbackService = new FeedbackService();
        List<Feedback> feedbacksAboveRating = feedbackService.getFeedbacksAboveCertainRating(feedbacks, rating);
        assertEquals(expected, feedbacksAboveRating);
    }

    static Stream<Arguments> getFeedbacksAboveCertainRating() {
        return Stream.of(
                Arguments.of(getFeedbacks(), 4, List.of(getFeedbacks().get(0), getFeedbacks().get(1),
                        getFeedbacks().get(4))),
                Arguments.of(getFeedbacks(), 5, List.of(getFeedbacks().get(0), getFeedbacks().get(4))),
                Arguments.of(List.of(), 3, List.of())
        );
    }

    @ParameterizedTest
    @MethodSource
    void getAverageRatingForCertainCategory(List<Feedback> feedbacks, String category, OptionalDouble expected) {
        FeedbackService feedbackService = new FeedbackService();
        OptionalDouble averageRating = feedbackService.getAverageRatingForCertainCategory(feedbacks, category);
        assertEquals(expected, averageRating);
    }

    static Stream<Arguments> getAverageRatingForCertainCategory() {
        return Stream.of(
                Arguments.of(getFeedbacks(), "Produkt", OptionalDouble.of(4.5)),
                Arguments.of(getFeedbacks(), "Service", OptionalDouble.of(2.2)),
                Arguments.of(List.of(), "Produkt", OptionalDouble.empty()),
                Arguments.of(List.of(), "", OptionalDouble.empty()),
                Arguments.of(getFeedbacks(), "", OptionalDouble.empty())
        );
    }

    @ParameterizedTest
    @MethodSource
    void getTopFiveMostCommonWordsInComments(List<Feedback> feedbacks, List<String> expected) {
        FeedbackService feedbackService = new FeedbackService();
        List<String> mostCommonWords = feedbackService.getTopFiveMostCommonWordsInComments(feedbacks);
        assertEquals(expected, mostCommonWords);
    }

    static Stream<Arguments> getTopFiveMostCommonWordsInComments() {
        return Stream.of(
                Arguments.of(getFeedbacks(), List.of("super", "besser", "schlecht", "sehr", "ist")),
                Arguments.of(List.of(), List.of())
        );
    }

    static List<Feedback> getFeedbacks() {
        return List.of(
                new Feedback("1", "Max", 5, "Das Produkt ist super!", "Produkt"),
                new Feedback("2", "Phillip", 4, "Super!", "Produkt"),
                new Feedback("3", "Patrick", 2, "Nicht so super", "Service"),
                new Feedback("4", "Sebastian", 1, "Schlecht!", "Service"),
                new Feedback("5", "Hans", 5, "Wahnsinn", "Produkt"),
                new Feedback("6", "Franz", 3, "Geht besser! Schlecht", "Service"),
                new Feedback("7", "Moritz", 4, "Sehr gut! Ganz super", "Produkt"),
                new Feedback("8", "Joseph", 2, "Sehr schlecht! Hatte gedacht, dass es besser wäre", "Service"),
                new Feedback("9", "Christoph", 3, "Dachte das es besser ist", "Service")
        );
    }
}