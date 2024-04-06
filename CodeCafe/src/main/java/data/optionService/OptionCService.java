package data.optionService;
import data.DBConnection;
import logic.UserInput;
import logic.db.DBManipulateDataService;
import logic.options.OptionDisplayCustomers;
import view.Printer;

public record OptionCService(UserInput userInput, DBManipulateDataService dbManipulateDataService,
                             DBConnection dbConnection, OptionDisplayCustomers optionDisplayCustomers) {
}
