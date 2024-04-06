package logic.db;

import data.customerData.CustomerColumns;
import data.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DBManipulateDataService {
    public void insertIntoDB(DBConnection dbConnection, String firstName, String lastName, String e_mail, String phoneNumber) {
        String query = "INSERT INTO " + CustomerColumns.customers.name() + " (" + CustomerColumns.firstName.name() + ", " + CustomerColumns.lastName.name() + ", "
                + CustomerColumns.eMail.name() + ", " + CustomerColumns.phoneNumber.name() + ") VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(dbConnection.DBUrl(), dbConnection.user(), dbConnection.password());
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, e_mail);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertIntoDB(DBConnection dbConnection, String firstName, String lastName, String e_mail) {
        String query = "INSERT INTO " + CustomerColumns.customers.name() + " (" + CustomerColumns.firstName.name() + ", " + CustomerColumns.lastName.name() + ", "
                + CustomerColumns.eMail.name() + ") VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(dbConnection.DBUrl(), dbConnection.user(), dbConnection.password());
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, e_mail);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteFromDB(DBConnection dbConnection, int customerId) {
        String query = "DELETE FROM " + CustomerColumns.customers + " WHERE " + CustomerColumns.customerId + " = " + customerId;
        try (Connection connection = DriverManager.getConnection(dbConnection.DBUrl(), dbConnection.user(), dbConnection.password());
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDataInDB(DBConnection dbConnection, List<String> inputs) {
        String query = "UPDATE " + CustomerColumns.customers.name() + " SET " + inputs.get(1) + " = ? WHERE " + CustomerColumns.customerId + " = ?";
        try (Connection connection = DriverManager.getConnection(dbConnection.DBUrl(), dbConnection.user(), dbConnection.password());
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, inputs.get(2));
            preparedStatement.setInt(2, Integer.parseInt(inputs.get(0)));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
