package data.optionService;

import data.DBConnection;
import logic.Checker;
import logic.UserInput;
import logic.db.DBManipulateDataService;
import view.Printer;

public record OptionBService(UserInput userInput, DBConnection dbConnection, DBManipulateDataService dbManipulateDataService) {
}
