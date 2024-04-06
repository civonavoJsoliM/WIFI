package logic;

import view.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;
    private final Checker checker;
    private final Printer printer;

    public UserInput(Scanner scanner, Checker checker, Printer printer) {
        this.scanner = scanner;
        this.checker = checker;
        this.printer = printer;
    }
    public String getUserInput() {
        return scanner.nextLine();
    }
    public List<String> getDataForNewOrder() {
        List<String> inputs = new ArrayList<>();
        printer.printEnterCustomerId();
        String input = getUserInput();
        inputs.add(input);
        printer.printEnterProduct();
        input = getUserInput();
        inputs.add(input);
        printer.printEnterAmount();
        input = getUserInput();
        inputs.add(input);
        return inputs;
    }
}
