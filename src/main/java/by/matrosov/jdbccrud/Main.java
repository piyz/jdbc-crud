package by.matrosov.jdbccrud;

import by.matrosov.jdbccrud.jdbc.JdbcExample;

public class Main {
    public static void main(String[] args) {
        JdbcExample jdbc = new JdbcExample();

        jdbc.create("Ivan", "Ivanov");
        jdbc.read();
        jdbc.update("Ivan", 3);
        jdbc.delete(5);
    }
}
