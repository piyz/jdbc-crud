package by.matrosov.jdbccrud.jdbc;

public interface CallableStatementOperations {
    void addUser(String firstName, String lastName);
    void getUserById(int userId);
}
