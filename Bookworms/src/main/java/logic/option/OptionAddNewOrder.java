package logic.option;

import data.DBConnection;
import data.customerData.Customer;
import data.productData.Product;
import logic.db.DBInsertService;
import logic.db.DBReaderService;
import logic.Checker;
import logic.UserInput;
import view.Printer;

import java.util.ArrayList;
import java.util.List;

public class OptionAddNewOrder implements Option {
    private final String name;
    private final Option option;
    private final DBConnection dbConnection;
    private final String getCustomers;
    private final Printer printer;
    private final String queryForInsertNewOrder;
    private final DBInsertService dbInsertService;
    private final UserInput userInput;
    private final DBReaderService dbReaderService;
    private final Checker checker;

    public OptionAddNewOrder(String name, Option optionDisplayProducts, DBConnection dbConnection, String getCustomers, Printer printer, String queryForInsert, DBInsertService dbInsertService, UserInput userInput, DBReaderService dbReaderService, Checker checker) {
        this.name = name;
        this.option = optionDisplayProducts;
        this.dbConnection = dbConnection;
        this.getCustomers = getCustomers;
        this.printer = printer;
        this.queryForInsertNewOrder = queryForInsert;
        this.dbInsertService = dbInsertService;
        this.userInput = userInput;
        this.dbReaderService = dbReaderService;
        this.checker = checker;
    }

    @Override
    public void option() {
        List<String> newOrder = getNewOrder();
        dbInsertService.insertOrderIntoDB(dbConnection, newOrder, queryForInsertNewOrder);
    }

    private List<String> getNewOrder() {
        String input;
        List<String> newOrder = new ArrayList<>();
        List<Customer> customers = getListOfCustomers();
        input = getCustomerForNewOrder(customers, "Customers");
        newOrder.add(input);
        OptionDisplayProducts optionDisplayProducts = (OptionDisplayProducts) option;
        List<Product> products = optionDisplayProducts.getListOfProducts();
        input = getProductForNewOrder(products, "Products");
        newOrder.add(input);
        input = getAmountForNewOrder();
        newOrder.add(input);
        return newOrder;
    }

    private String getCustomerForNewOrder(List<Customer> customers, String name) {
        String input;
        List<Integer> customersId = customers.stream().map(customer -> customer.customerId()).toList();
        printer.displayList(customers, name);
        printer.printEnterCustomerId();
        input = userInput.getUserInput();
        while (!checker.validInputNumber(input) || validId(customersId, input)) {
            printer.printInvalidInput();
            input = userInput.getUserInput();
        }
        return input;
    }
    private String getProductForNewOrder(List<Product> products, String name) {
        String input;
        List<Integer> productsId = products.stream().map(product -> product.productId()).toList();
        printer.displayList(products, name);
        printer.printEnterProduct();
        input = userInput.getUserInput();
        while (!checker.validInputNumber(input) || validId(productsId, input)) {
            printer.printInvalidInput();
            input = userInput.getUserInput();
        }
        return input;
    }
    private String getAmountForNewOrder() {
        String input;
        printer.printEnterAmount();
        input = userInput.getUserInput();
        while (!checker.validInputNumber(input)) {
            printer.printInvalidInput();
            input = userInput.getUserInput();
        }
        return input;
    }

    private List<Customer> getListOfCustomers() {
        return dbReaderService.readFromDB(dbConnection, getCustomers);
    }

    private boolean validId(List<Integer> list, String input) {
        return list.stream().noneMatch(number -> number == Integer.parseInt(input));
    }

    @Override
    public String getName() {
        return name;
    }
}
