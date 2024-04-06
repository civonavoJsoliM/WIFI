package data.optionService;

import data.DBConnection;
import logic.db.DBReaderService;
import view.Printer;

public record OptionAService(DBReaderService dbReaderService, DBConnection dbConnection, String query, Printer printer) {
}
