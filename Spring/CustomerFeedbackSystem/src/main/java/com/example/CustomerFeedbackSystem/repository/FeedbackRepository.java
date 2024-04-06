package com.example.CustomerFeedbackSystem.repository;

import com.example.CustomerFeedbackSystem.data.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedbackRepository {

    private final List<Feedback> feedbacks;

    public FeedbackRepository(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Feedback add(Feedback feedback) {
        feedbacks.add(feedback);
        return feedback;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }
}
