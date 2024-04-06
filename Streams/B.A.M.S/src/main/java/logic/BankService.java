package logic;

import data.Account;
import data.Customer;
import data.Transaction;
import data.TransactionType;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankService {
    public List<Account> accountsWithBalanceGreaterThen(List<Customer> customers, double amount) {
        return customers.stream()
                .flatMap(customer -> customer.accounts().stream()
                        .filter(account -> account.getBalance() > amount))
                .collect(Collectors.toList());
    }

    public void transferMoney(Account sender, Account recipient, double amount) {
        sender.setBalance(sender.getBalance() - amount);
        recipient.setBalance(recipient.getBalance() + amount);
        sender.getTransactions().add(new Transaction(TransactionType.WITHDRAWAL, -amount, LocalDate.now()));
        recipient.getTransactions().add(new Transaction(TransactionType.DEPOSIT, amount, LocalDate.now()));
    }

    public Map<Customer, Double> getMonthlyStatement(List<Customer> customers, Month month) {
        return customers.stream()
                .collect(Collectors.toMap(customer -> customer,
                        customer -> customer.accounts().stream()
                                .flatMap(account -> account.getTransactions().stream())
                                .filter(transaction -> transaction.date().getMonth().equals(month))
                                .mapToDouble(Transaction::amount).sum())
                );

    }
}
