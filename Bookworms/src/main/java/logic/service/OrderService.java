package logic.service;

import data.customerData.CustomersColumns;
import data.orderData.Order;
import data.orderData.OrdersColumns;
import data.productData.ProductsColumns;
import logic.db.ResultToList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements ResultToList {
    @Override
    public List<Order> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Order> orders = new ArrayList<>();
        while (resultSet.next()) {
            int orderId = resultSet.getInt(OrdersColumns.orderId.name());
            LocalDate orderDate = resultSet.getDate(OrdersColumns.orderDate.name()).toLocalDate();
            String firstName = resultSet.getString(CustomersColumns.firstName.name());
            String lastName = resultSet.getString(CustomersColumns.lastName.name());
            int amount = resultSet.getInt(OrdersColumns.amount.name());
            String title = resultSet.getString(ProductsColumns.title.name());
            double price = resultSet.getDouble(ProductsColumns.price.name());
            orders.add(new Order(orderId, orderDate, firstName, lastName, amount, title, price));
        }
        return orders;
    }
}
