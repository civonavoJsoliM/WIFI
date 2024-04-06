package com.example.CustomerFeedbackSystem;

import com.example.CustomerFeedbackSystem.data.Feedback;
import com.example.CustomerFeedbackSystem.logic.FeedbackService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CustomerFeedbackSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerFeedbackSystemApplication.class, args);
	}

}
