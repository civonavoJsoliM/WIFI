package logic;

import data.customerData.Customer;
import data.customerData.CustomerColumns;
import logic.db.ResultToList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ResultToList {
    public List<Customer> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        while (resultSet.next()) {
            int customerId  = resultSet.getInt(CustomerColumns.customerId.name());
            String firstName = resultSet.getString(CustomerColumns.firstName.name());
            String lastName = resultSet.getString(CustomerColumns.lastName.name());
            String e_mail = resultSet.getString(CustomerColumns.eMail.name());
            String phoneNumber = resultSet.getString(CustomerColumns.phoneNumber.name());
            customers.add(new Customer(customerId, firstName, lastName, e_mail, phoneNumber));
        }
        return customers;
    }
}