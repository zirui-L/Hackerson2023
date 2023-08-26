import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Database {
    private static final String DB_NAME = "childhood.db";
    private Connection connection;

    private void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);
    }
    private void ensureKindsTable() throws SQLException {
        String sql =
                "CREATE TABLE IF NOT EXISTS childhood (id INT PRIMARY KEY NOT NULL, description VARCHAR(50) NOT NULL, health INT)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private void deleteChildhoodTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS childhood";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }


    public void addScenario(Integer id, String description, Integer health, Integer wealth, Integer charm, Integer IQ, Integer happiness) throws SQLException {
        String sql = "INSERT INTO childhood (id, description, health, wealth, charm, IQ, happiness) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(4, health);
            preparedStatement.setInt(4, wealth);
            preparedStatement.setInt(4, charm);
            preparedStatement.setInt(4, IQ);
            preparedStatement.setInt(4, happiness);

            preparedStatement.executeUpdate();
        }
    }

    public void updateScenario(Integer id, String description, Integer health, Integer wealth, Integer charm, Integer IQ, Integer happiness) throws SQLException {
        String sql = "UPDATE childhood set description = ?,  WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(2, name);
            preparedStatement.setDouble(1, price);
            preparedStatement.executeUpdate();
        }
    }


    public void rmScenario(Integer id) throws SQLException {
        String sql = "DELETE FROM childhood WHERE id IS ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public Map<String, Double> getKinds() throws SQLException {
        String query = "SELECT name, price FROM kinds";
        Map<String,Double> kinds = new HashMap<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            kinds.put(name, price);
        }
        return kinds;
    }

    public Double getKind(String name) throws SQLException {
        String sql = "SELECT price FROM kinds WHERE name = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            double price = resultSet.getDouble("price");
            return price;
        }
        return null;
    }

    public Database() throws SQLException {
        connect();
        ensureKindsTable();
    }

}


}
