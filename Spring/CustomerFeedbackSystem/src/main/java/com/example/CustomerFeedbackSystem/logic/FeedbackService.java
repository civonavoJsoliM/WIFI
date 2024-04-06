package com.example.CustomerFeedbackSystem.logic;

import com.example.CustomerFeedbackSystem.data.Feedback;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FeedbackService {

    public List<Feedback> getFeedbacksAboveCertainRating(List<Feedback> feedbacks, int rating) {
        return feedbacks.stream()
                .filter(feedback -> feedback.rating() >= rating)
                .toList();
    }

    public OptionalDouble getAverageRatingForCertainCategory(List<Feedback> feedbacks, String category) {
        return feedbacks.stream()
                .filter(feedback -> feedback.category().equals(category))
                .mapToDouble(Feedback::rating)
                .average();
    }

    public List<String> getTopFiveMostCommonWordsInComments(List<Feedback> feedbacks) {
        return feedbacks.stream()
                .map(Feedback::comment)
                .map(this::replaceSpecialCharacters)
                .map(this::replaceUpperCaseForLowerCase)
                .map(comment -> Arrays.stream(comment.split(" ")).toList())
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(str -> str, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    private String replaceSpecialCharacters(String comment) {
        return comment.replaceAll("[!,.\"?%$/]", "");
    }
    private String replaceUpperCaseForLowerCase(String comment) {
        return comment.replaceAll(comment, comment.toLowerCase());
    }
}
