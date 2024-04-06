package com.example.CustomerFeedbackSystem.configuration;

import com.example.CustomerFeedbackSystem.data.Feedback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FeedbackConfiguration {

    @Bean
    List<Feedback> feedbacks() {
     return new ArrayList<>();
    }
}
