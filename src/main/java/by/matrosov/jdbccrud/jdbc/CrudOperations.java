package by.matrosov.jdbccrud.jdbc;

public interface CrudOperations {
    void create(String firstName, String lastName);
    void read();
    void update(String firstName, int userId);
    void delete(int userId);
}
