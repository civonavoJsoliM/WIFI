package logic.db;

import data.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class DBReaderService<T> {
    private final ResultToList<T> resultToList;

    public DBReaderService(ResultToList<T> resultToList) {
        this.resultToList = resultToList;
    }

    public List<T> readFromDB(DBConnection dbConnection, String query) {
        try (Connection connection = DriverManager.getConnection(dbConnection.DBUrl(), dbConnection.user(), dbConnection.password());
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            return resultToList.resultSetToList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
