package by.matrosov.jdbccrud.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class JdbcExample implements CrudOperations, DbConnection{

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcExample.class);

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String CONNECTION = "jdbc:postgresql://localhost:5432/";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    @Override
    public void create(String firstName, String lastName) {
        String insertTableSQL = "insert into users"
                + "(first_name, last_name) values"
                + "(?,?)";

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL)) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            LOGGER.info("Record is inserted into USERS table!");

        } catch (SQLException e) {
            LOGGER.info("Smth going wrong");
            e.printStackTrace();
        }
    }

    @Override
    public void read() {
        String userSelecter = "select * from users";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            LOGGER.info(userSelecter);

            ResultSet resultSet = statement.executeQuery(userSelecter);

            while (resultSet.next()) {
                String userId = resultSet.getString("user_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                LOGGER.info(userId + "::" + firstName + "::" + lastName);
            }

        } catch (SQLException e) {
            LOGGER.info("Smth goin wrong");
            e.printStackTrace();
        }
    }

    @Override
    public void update(String firstName, int userId) {
        String updateTableSQL = "update users set first_name = ? "
                + " where user_id = ?";

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateTableSQL)) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setInt(2, userId);

            // execute update SQL stetement
            preparedStatement.executeUpdate();

            LOGGER.info("Record is updated to DBUSER table!");

        } catch (SQLException e) {
            LOGGER.info("Smth going wrong");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int userId) {
        String deleteSQL = "delete from users where user_id = ?";

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, userId);

            // execute delete SQL stetement
            preparedStatement.executeUpdate();

            LOGGER.info("Record is deleted!");

        } catch (SQLException e) {
            LOGGER.info("Smth going wrong");
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.info("JDBC Driver not found");
            e.printStackTrace();
        }

        LOGGER.info("PostgreSQL JDBC Driver Registered!");

        try {
            connection = DriverManager.getConnection(CONNECTION, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            LOGGER.info("Connection Failed! Check output console");
            e.printStackTrace();
        }

        return connection;
    }
}
