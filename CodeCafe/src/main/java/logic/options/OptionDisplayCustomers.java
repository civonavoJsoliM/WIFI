package logic.options;

import data.customerData.Customer;
import data.optionService.OptionAService;

import java.util.List;

public class OptionDisplayCustomers implements Option {
    private final String name;
    private final OptionAService optionAService;

    public OptionDisplayCustomers(String optionName, OptionAService optionAService) {
        this.name = optionName;
        this.optionAService = optionAService;
    }
    public void option() {
        List<Customer> customers = optionAService.dbReaderService().readFromDB(optionAService.dbConnection(), optionAService.query());
        optionAService.printer().printCustomers(customers);
    }
    public String getName() {
        return name;
    }

    public OptionAService getOptionAService() {
        return optionAService;
    }
}
