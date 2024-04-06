package logic.db;

import data.DBConnection;
import data.orderData.OrdersColumns;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class DBInsertService {
    public void insertOrderIntoDB(DBConnection dbConnection, List<String> newOrder, String query) {
        try(Connection connection = DriverManager.getConnection(dbConnection.DBUrl(), dbConnection.user(), dbConnection.password());
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1,Integer.parseInt(newOrder.get(0)));
            preparedStatement.setInt(2,Integer.parseInt(newOrder.get(1)));
            preparedStatement.setDouble(3,Double.parseDouble(newOrder.get(2)));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
