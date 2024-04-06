package data;

import java.time.LocalDate;

public record Transaction(TransactionType transactionType, double amount, LocalDate date) {
}
