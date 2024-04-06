package logic.option;

import data.DBConnection;
import data.productData.Product;
import logic.db.DBReaderService;
import view.Printer;

import java.util.List;

public class OptionDisplayProducts implements Option{
    private final String name;
    private final DBConnection dbConnection;
    private final String getProducts;
    private final Printer<Product> printer;
    private final DBReaderService<Product> dbReaderService;

    public OptionDisplayProducts(String name, DBConnection dbConnection, String getProducts, Printer<Product> printer, DBReaderService<Product> dbReaderService) {
        this.name = name;
        this.dbConnection = dbConnection;
        this.getProducts = getProducts;
        this.printer = printer;
        this.dbReaderService = dbReaderService;
    }
    @Override
    public void option() {
        List<Product> products = getListOfProducts();
        printer.displayList(products, "Products");
    }

    public List<Product> getListOfProducts() {
        return dbReaderService.readFromDB(dbConnection, getProducts);
    }

    @Override
    public String getName() {
        return name;
    }


}
