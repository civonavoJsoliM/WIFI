package logic.options;

import data.customerData.Customer;
import data.optionService.OptionDService;

import java.util.ArrayList;
import java.util.List;

public class OptionUpdateCustomerData implements Option{
    private final String name;
    private final OptionDService optionDService;
    public OptionUpdateCustomerData(String name, OptionDService optionDService) {
        this.name = name;
        this.optionDService = optionDService;
    }

    @Override
    public void option() {
        List<String> dataForUpdate = getDataForUpdate();
        optionDService.dbManipulateDataService().updateDataInDB(optionDService.dbConnection(), dataForUpdate);
        System.out.println("The data has been successfully updated!");
    }
    private List<String> getDataForUpdate() {
        List<Customer> customers = optionDService.optionDisplayCustomers().getOptionAService().dbReaderService().readFromDB(optionDService.dbConnection(),
                optionDService.optionDisplayCustomers().getOptionAService().query());
        optionDService.userInput().getPrinter().printCustomers(customers);
        List<String> dataForUpdate = new ArrayList<>();
        String input;
        optionDService.userInput().getPrinter().printEnterCustomerId();
        input = String.valueOf(optionDService.userInput().getUserInputCustomerId());
        while (!optionDService.userInput().getChecker().checkIfIDValid(customers, Integer.parseInt(input))) {
            optionDService.userInput().getPrinter().enterValidInput();
            input = String.valueOf(optionDService.userInput().getUserInputCustomerId());
            }
        dataForUpdate.add(input);
        optionDService.userInput().getPrinter().printDataToBeUpdated();
        input = optionDService.userInput().getUserInput();
        while (!optionDService.userInput().getChecker().checkIfColumnValid(input)) {
            optionDService.userInput().getPrinter().enterValidInput();
            input = optionDService.userInput().getUserInput();
        }
        dataForUpdate.add(input);
        optionDService.userInput().getPrinter().printToBeUpdatedInto();
        input = optionDService.userInput().getUserInput();
        dataForUpdate.add(input);
        return dataForUpdate;
    }

    @Override
    public String getName() {
        return name;
    }
}
