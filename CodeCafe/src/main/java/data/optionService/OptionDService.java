package data.optionService;

import data.DBConnection;
import logic.UserInput;
import logic.db.DBManipulateDataService;
import logic.options.OptionDisplayCustomers;

public record OptionDService(DBManipulateDataService dbManipulateDataService, DBConnection dbConnection, UserInput userInput, OptionDisplayCustomers optionDisplayCustomers) {
}
