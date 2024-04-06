package logic;

import data.customerData.CustomerColumns;
import view.Printer;

import java.util.List;
import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;
    private final Printer printer;
    private final Checker checker;

    public UserInput(Scanner scanner, Printer printer, Checker checker) {
        this.scanner = scanner;
        this.printer = printer;
        this.checker = checker;
    }

    public String userChoice() {
        //printer.usersChoice();
        return scanner.nextLine();
    }

    public String getUserInput() {
        String input = scanner.nextLine();
        while (!checker.checkIfInputNotEmpty(input)) {
            printer.enterValidInput();
            input = scanner.nextLine();
        }
        return input;
    }
    public int getUserInputCustomerId() {
        String input = scanner.nextLine();
        while (!checker.checkIfNumber(input)) {
            printer.enterValidIdNumber();
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }
    public Checker getChecker() {
        return checker;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Printer getPrinter() {
        return printer;
    }
}
