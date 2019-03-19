package by.matrosov.jdbccrud.jdbc;

import java.sql.Connection;

public interface DbConnection {
    Connection getConnection();
}
