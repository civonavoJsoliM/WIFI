package data;

import data.customerData.CustomersColumns;
import data.orderData.OrdersColumns;
import data.productData.ProductsColumns;

public class Query {

    public String selectProducts() {
        return "SELECT * FROM " + ProductsColumns.products.name();
    }

    public String selectCustomers() {
        return "SELECT * FROM " + CustomersColumns.customers.name();
    }

    public   String selectOrders() {
        return "SELECT " + OrdersColumns.orderId.name() + ", " + OrdersColumns.orderDate.name() + ", " + CustomersColumns.firstName.name() + ", " +
                CustomersColumns.lastName.name() + ", " + OrdersColumns.amount.name() + ", " + ProductsColumns.title.name() + ", " + ProductsColumns.price.name() + " FROM "
                + OrdersColumns.orders.name() +
                " JOIN customers ON orders.customerId = customers.customerId" +
                " JOIN products ON products.productId = orders.productId";
    }

    public String queryForInsertNewOrder() {
        return "INSERT INTO " + OrdersColumns.orders.name() + " (" + OrdersColumns.customerId.name() + ", " + OrdersColumns.productId.name() +
                ", " + OrdersColumns.amount.name() + ", " + OrdersColumns.orderDate + ") VALUES (?, ?, ?, ?)";
    }
}
