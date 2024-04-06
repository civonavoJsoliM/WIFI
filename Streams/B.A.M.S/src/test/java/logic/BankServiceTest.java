package logic;

import data.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    @ParameterizedTest
    @MethodSource("initialCustomers")
    void accountsWithBalanceGreaterThen(List<Customer> customers, double amount, List<Account> expected) {
        BankService bankService = new BankService();
        List<Account> accounts = bankService.accountsWithBalanceGreaterThen(customers, amount);
        assertEquals(expected, accounts);
    }

    static Stream<Arguments> initialCustomers() {
        Account a1 = new Account(1, AccountType.SAVINGS, 100.0,
                List.of(new Transaction(TransactionType.DEPOSIT, 20.0, LocalDate.now())));
        Account a2 = new Account(2, AccountType.SAVINGS, 200.0,
                List.of(new Transaction(TransactionType.DEPOSIT, 30.0, LocalDate.now())));
        Account a3 = new Account(3, AccountType.SAVINGS, 300.0,
                List.of(new Transaction(TransactionType.DEPOSIT, 40.0, LocalDate.now())));

        Customer c1 = new Customer("Milos", "Wien", 123, List.of(a1));
        Customer c2 = new Customer("Stefana", "Klosterneuburg", 234, List.of(a2));
        Customer c3 = new Customer("Marina", "Kasidol", 345, List.of(a3));

        return Stream.of(Arguments.of(List.of(c1, c2, c3), 150.0, List.of(a2, a3)),
                Arguments.of(List.of(c1, c2, c3), 500.0, List.of()),
                Arguments.of(List.of(), 1000.0, List.of()));
    }

    @ParameterizedTest
    @MethodSource("initialParameters")
    void getMonthlyStatement(List<Customer> customers, Month month, Map<Customer, Double> expected) {
        BankService bankService = new BankService();
        Map<Customer, Double> monthlyStatement = bankService.getMonthlyStatement(customers, month);
        assertEquals(expected, monthlyStatement);
    }
    static Stream<Arguments> initialParameters() {
        Account a1 = new Account(1, AccountType.SAVINGS, 100.0,
                List.of(new Transaction(TransactionType.DEPOSIT, 20.0, LocalDate.now()),
                        new Transaction(TransactionType.DEPOSIT, 30.0, LocalDate.now())));
        Account a2 = new Account(2, AccountType.SAVINGS, 200.0,
                List.of(new Transaction(TransactionType.WITHDRAWAL, -30.0, LocalDate.now()),
                        new Transaction(TransactionType.WITHDRAWAL, -20.0, LocalDate.now())));
        Account a3 = new Account(3, AccountType.SAVINGS, 300.0,
                List.of(new Transaction(TransactionType.DEPOSIT, 40.0, LocalDate.now()),
                        new Transaction(TransactionType.WITHDRAWAL, -40.0, LocalDate.now())));

        Customer c1 = new Customer("Milos", "Wien", 123, List.of(a1));
        Customer c2 = new Customer("Stefana", "Klosterneuburg", 234, List.of(a2));
        Customer c3 = new Customer("Marina", "Kasidol", 345, List.of(a3));

        return Stream.of(Arguments.of(
                List.of(c1, c2, c3), Month.of(1), Map.of(c1, 50.0, c2, -50.0, c3, 0.0)),
                Arguments.of(List.of(), Month.of(1), Map.of()),
                Arguments.of(List.of(c1, c2, c3), Month.of(6), Map.of(c1, 0.0, c2, 0.0, c3, 0.0)));
    }
}