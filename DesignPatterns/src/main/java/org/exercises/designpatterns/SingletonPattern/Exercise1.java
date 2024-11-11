package org.exercises.designpatterns.SingletonPattern;

import java.util.logging.Logger;

public class Exercise1 implements SystemLogger  {
    // Step 1: Create a private static instance of Logger
    private static SystemLogger instance;

    // Step 2: Make the constructor private to prevent instantiation
    private Exercise1() {
        System.out.println("System Logger Active: System is Online");
    }

    // Step 3: Provide a public static method to get the single instance of the class
    public synchronized static SystemLogger getInstance() {
        if (instance == null) {
            instance = new Exercise1();
        }
        return instance;
    }

    // Step 4: Create a log method to handle logging messages
    public void log(String message) {
        System.out.println("Log message: " + message);
    }

    public static void main(String[] args) {
        SystemLogger logger1 = Exercise1.getInstance();

        // Log a message
        logger1.log("Application started");

        // Trying to get another instance will return the same instance
        SystemLogger logger2 = Exercise1.getInstance();
        logger2.log("System Ready for action!");

        // Both log messages are handled by the same Logger instance
    }
}

interface SystemLogger {
    public void log(String message);
}