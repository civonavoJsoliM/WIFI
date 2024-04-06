package logic.option;

import data.DBConnection;
import data.orderData.Order;
import logic.db.DBReaderService;
import view.Printer;

import java.util.List;

public class OptionDisplayOrders implements Option{
    private final String name;
    private final DBConnection dbConnection;
    private final String getOrders;
    private final Printer<Order> printer;
    private final DBReaderService<Order> dbReaderService;

    public OptionDisplayOrders(String name, DBConnection dbConnection, String getOrders, Printer<Order> printer, DBReaderService<Order> dbReaderService) {
        this.name = name;
        this.dbConnection = dbConnection;
        this.getOrders = getOrders;
        this.printer = printer;
        this.dbReaderService = dbReaderService;
    }

    @Override
    public void option() {
        List<Order> orders = getListOdOrders();
        printer.displayList(orders, "Orders");
    }
    public List<Order> getListOdOrders() {
        return dbReaderService.readFromDB(dbConnection, getOrders);
    }

    @Override
    public String getName() {
        return name;
    }
}
