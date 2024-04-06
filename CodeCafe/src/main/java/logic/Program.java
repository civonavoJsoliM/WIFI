package logic;

import data.customerData.Customer;
import data.customerData.CustomerColumns;
import data.DBConnection;
import logic.options.*;
import logic.db.DBManipulateDataService;
import logic.db.DBReaderService;
import logic.db.ResultToList;
import data.optionService.OptionAService;
import data.optionService.OptionBService;
import data.optionService.OptionCService;
import data.optionService.OptionDService;
import view.Printer;

import java.util.List;
import java.util.Scanner;

public class Program {
    public void start() {
        DBConnection dbConnection = new DBConnection("jdbc:mysql://localhost/codeCafe", "root", "");
        String query = "SELECT * FROM " + CustomerColumns.customers.name();

        //INSTANZIIERUNGEN VON OBJEKTEN
        ResultToList<Customer> resultToList = new CustomerService();
        DBReaderService<Customer> dbReaderService = new DBReaderService(resultToList);
        DBManipulateDataService dbManipulateDataService = new DBManipulateDataService();
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Checker checker = new Checker();
        UserInput userInput = new UserInput(scanner, printer, checker);
        OptionAService optionAService = new OptionAService(dbReaderService, dbConnection, query, printer);
        OptionBService optionBService = new OptionBService(userInput, dbConnection, dbManipulateDataService);
        OptionDisplayCustomers optionDisplayCustomers = new OptionDisplayCustomers("A", optionAService);
        OptionCService optionCService = new OptionCService(userInput, dbManipulateDataService, dbConnection, optionDisplayCustomers);
        OptionAddCustomer optionAddCustomer = new OptionAddCustomer("B", optionBService);
        OptionDeleteCustomer optionDeleteCustomer = new OptionDeleteCustomer("C", optionCService);
        OptionDService optionDService = new OptionDService(dbManipulateDataService, dbConnection, userInput, optionDisplayCustomers);
        OptionUpdateCustomerData optionUpdateCustomerData = new OptionUpdateCustomerData("D", optionDService);

        //DIE FUNKTION DES PROGRAMMS
        List<Option> options = List.of(optionDisplayCustomers, optionAddCustomer, optionDeleteCustomer, optionUpdateCustomerData);
        printer.printGreeting();
        printer.printOptions();
        String userChoice = userInput.userChoice();
        while (!checker.checkChoice(userChoice)) {
            printer.enterValidInput();
            userChoice = userInput.userChoice();
        }
        for (Option option : options) {
            if (option.getName().equalsIgnoreCase(userChoice))
                option.option();
        }

    }
}
