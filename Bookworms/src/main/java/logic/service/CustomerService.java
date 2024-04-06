package logic.service;

import data.customerData.Customer;
import data.customerData.CustomersColumns;
import logic.db.ResultToList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ResultToList {
    @Override
    public List<Customer> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        while(resultSet.next()) {
            int customerId = resultSet.getInt(CustomersColumns.customerId.name());
            String firstName = resultSet.getString(CustomersColumns.firstName.name());
            String lastName = resultSet.getString(CustomersColumns.lastName.name());
            String eMail = resultSet.getString(CustomersColumns.eMail.name());
            String address = resultSet.getString(CustomersColumns.address.name());
            String phoneNumber = resultSet.getString(CustomersColumns.phoneNumber.name());
            customers.add(new Customer(customerId, firstName, lastName, eMail, address, phoneNumber));
        }
        return customers;
    }
}
