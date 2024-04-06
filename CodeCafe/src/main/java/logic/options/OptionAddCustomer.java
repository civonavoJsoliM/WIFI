package logic.options;
import data.customerData.CustomerColumns;
import data.optionService.OptionBService;

import java.util.List;

public class OptionAddCustomer implements Option {
    private final String name;
    private final OptionBService optionBService;

    public OptionAddCustomer(String name, OptionBService optionBService) {
        this.name = name;
        this.optionBService = optionBService;
    }
    public void option() {
        List<String> newCustomer = getNewCustomer();
        String input = withOrWithoutPhoneNumber();
        if (optionBService.userInput().getChecker().checkIfUserWantToInputPhoneNumber(input)) {
            optionBService.userInput().getPrinter().printEnterPhoneNumber();
            newCustomer.add(optionBService.userInput().getUserInput());
            optionBService.dbManipulateDataService().insertIntoDB(optionBService.dbConnection(),
                    newCustomer.get(0), newCustomer.get(1),
                    newCustomer.get(2), newCustomer.get(3));
        } else {
            optionBService.dbManipulateDataService().insertIntoDB(optionBService.dbConnection(),
                    newCustomer.get(0), newCustomer.get(1),
                    newCustomer.get(2));
        }
            optionBService.userInput().getPrinter().customerAddedSuccessfully();
    }
    private List<String> getNewCustomer() {
        optionBService.userInput().getPrinter().printEnter(CustomerColumns.firstName.name());
        String firstName = optionBService.userInput().getUserInput();
        optionBService.userInput().getPrinter().printEnter(CustomerColumns.lastName.name());
        String lastName = optionBService.userInput().getUserInput();
        optionBService.userInput().getPrinter().printEnter(CustomerColumns.eMail.name());
        String e_mail = optionBService.userInput().getUserInput();
        return List.of(firstName, lastName, e_mail);
    }
    private String withOrWithoutPhoneNumber() {
        optionBService.userInput().getPrinter().askIfToEnterPhoneNumber();
        return optionBService.userInput().getScanner().nextLine();
    }

    public String getName() {
        return name;
    }
}
