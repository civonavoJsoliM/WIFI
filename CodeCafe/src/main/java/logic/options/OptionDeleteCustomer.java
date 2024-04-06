package logic.options;

import data.customerData.Customer;
import data.optionService.OptionCService;

import java.util.List;

public class OptionDeleteCustomer implements Option {
    private final String name;
    private final OptionCService optionCService;

    public OptionDeleteCustomer(String name, OptionCService optionCService) {
        this.name = name;
        this.optionCService = optionCService;
    }

    public void option() {
        List<Customer> customers = optionCService.optionDisplayCustomers().getOptionAService().dbReaderService()
                .readFromDB(optionCService.optionDisplayCustomers().getOptionAService().dbConnection(),
                        optionCService.optionDisplayCustomers().getOptionAService().query());
        optionCService.optionDisplayCustomers().option();
        optionCService.userInput().getPrinter().askWhichCustomerToDelete();
        int customerId = optionCService.userInput().getUserInputCustomerId();
        while (!optionCService.userInput().getChecker().checkIfIDValid(customers, customerId)) {
            optionCService.userInput().getPrinter().enterValidIdNumber();
            customerId = optionCService.userInput().getUserInputCustomerId();
        }
        optionCService.dbManipulateDataService().deleteFromDB(optionCService.dbConnection(), customerId);
        optionCService.userInput().getPrinter().customerDeletedSuccessfully();
    }

    public String getName() {
        return name;
    }
}
