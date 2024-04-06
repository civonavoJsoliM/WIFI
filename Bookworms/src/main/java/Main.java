import data.DBConnection;
import data.Query;
import data.customerData.Customer;
import data.orderData.Order;
import data.productData.Product;
import logic.Checker;
import logic.UserInput;
import logic.db.DBInsertService;
import logic.db.DBReaderService;
import logic.db.ResultToList;
import logic.option.*;
import logic.service.*;
import view.Printer;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection("jdbc:mysql://localhost/bookworms", "root", "");
        Printer printer = new Printer();
        Checker checker = new Checker();
        Scanner scanner = new Scanner(System.in);
        UserInput userInput = new UserInput(scanner, checker, printer);
        DBInsertService dbInsertService = new DBInsertService();
        Query query = new Query();

        //PRODUCTS
        String getProducts = query.selectProducts();
        ResultToList<Product> RTLProduct = new ProductService();
        DBReaderService<Product> DBRSProduct = new DBReaderService<>(RTLProduct);
        Option optionA = new OptionDisplayProducts("A", dbConnection, getProducts, printer, DBRSProduct);

        //ORDERS
        String getOrders = query.selectOrders();
        ResultToList<Order> RTLOrder = new OrderService();
        DBReaderService<Order> DBRSOrder = new DBReaderService<>(RTLOrder);
        Option optionB = new OptionDisplayOrders("B", dbConnection, getOrders, printer, DBRSOrder);

        //NEW ORDER
        String getCustomers = query.selectCustomers();
        String insertNewOrder = query.queryForInsertNewOrder();
        ResultToList<Customer> RTLCustomer = new CustomerService();
        DBReaderService<Customer> DBRSCustomer = new DBReaderService<>(RTLCustomer);
        Option optionC = new OptionAddNewOrder("C", optionA, dbConnection, getCustomers, printer, insertNewOrder, dbInsertService, userInput, DBRSCustomer, checker);

        List<Option> options = List.of(optionA, optionB, optionC);

        printer.printGreeting();
        printer.printOptions();
        String input = userInput.getUserInput();
        while (!checker.validOptionInput(input)) {
            printer.printInvalidInput();
            input = userInput.getUserInput();
        }
        for (Option option : options) {
            if (option.getName().equalsIgnoreCase(input)) {
                option.option();
            }
        }
    }
}