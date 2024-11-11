package org.exercises.designpatterns.FactoryPattern;

public class Exercise2 {
    public static void main(String[] args) {
        // Create an instance of the factory
        DatabaseConnectionFactory factory = new DatabaseConnectionFactory();

        // Get a MySQL connection and connect
        Connectable mysqlConnection = factory.createConnection("MYSQL");
        if (mysqlConnection != null) mysqlConnection.connect();


        // Get a PostgreSQL connection and connect
        Connectable postgresConnection = factory.createConnection("POSTGRESQL");
        if (postgresConnection != null) postgresConnection.connect();

        // Attempt to create a connection with an unsupported type
        Connectable unknownConnection = factory.createConnection("ORACLE");
        if (unknownConnection == null) System.out.println("Database type not supported.");
    }

}

