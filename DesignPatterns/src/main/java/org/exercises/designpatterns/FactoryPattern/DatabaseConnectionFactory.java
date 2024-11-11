package org.exercises.designpatterns.FactoryPattern;

public class DatabaseConnectionFactory {

    public Connectable  createConnection(String ct) {
        if(ct.equalsIgnoreCase("mysql")) return new MySQLConnection();
        if(ct.equalsIgnoreCase("postgresql")) return new PostgreSQLConnection();
        return null;
    }

}

class MySQLConnection implements Connectable {
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL database...");
        // Here you would add real connection logic if needed
    }
}


// PostgreSQLConnection.java
class PostgreSQLConnection implements Connectable {
    @Override
    public void connect() {
        System.out.println("Connecting to PostgreSQL database...");
        // Here you would add real connection logic if needed
    }
}

// DatabaseConnection.java
interface Connectable {
    void connect();
}
