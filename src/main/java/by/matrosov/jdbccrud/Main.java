package by.matrosov.jdbccrud;

import by.matrosov.jdbccrud.jdbc.JdbcExample;

public class Main {
    public static void main(String[] args) {
        JdbcExample jdbc = new JdbcExample();

        //crud operations
        jdbc.create("Ivan", "Ivanov");
        jdbc.read();
        jdbc.update("Ivan", 3);
        jdbc.delete(5);

        //procedures call
        //you can find procedure.sql in resources
        jdbc.addUser("Cat", "Cat");
        jdbc.getUserById(1);
    }
}
