package logic.service;

import data.productData.Product;
import data.productData.ProductsColumns;
import logic.db.ResultToList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements ResultToList {

    @Override
    public List<Product> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            int productId = resultSet.getInt(ProductsColumns.productId.name());
            String title = resultSet.getString(ProductsColumns.title.name());
            String author = resultSet.getString(ProductsColumns.author.name());
            double price = resultSet.getDouble(ProductsColumns.price.name());
            products.add(new Product(productId, title, author, price));
        }
        return products;
    }
}
