package org.exercises.designpatterns.SingletonPattern;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Exercise2 implements Configurer {
    // Step 1: Create a private static instance of ConfigurationManager
    private static Configurer instance;

    // Step 2: Use a Properties object to store configuration values
    private Properties properties = new Properties();

    // Step 3: Make the constructor private to prevent instantiation
    private Exercise2() {
        loadConfigurations();
    }

    // Step 4: Provide a public static method to get the single instance of the class
    public static Configurer getInstance() {
        if (instance == null) {
            synchronized (Exercise2.class) {
                if (instance == null) {
                    instance = new Exercise2();
                }
            }
        }
        return instance;
    }

    // Load configurations from a file, with fallback to environment variables
    private void loadConfigurations() {
        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Configuration file not found. Falling back to environment variables.");
        }
    }

    // Get a configuration value by key, with an optional default
    public String getConfig(String key, String defaultValue) {
        // First, try to get the value from properties file
        String value = properties.getProperty(key);
        if (value == null) {
            // If not found in the file, fall back to environment variable
            value = System.getenv(key);
        }
        // Return value if found, otherwise return the default
        return (value != null) ? value : defaultValue;
    }

    // Overload method to return null if no default is provided and key is not found
    public String getConfig(String key) {
        return getConfig(key, null);
    }

    public static void main(String[] args) {
        Configurer configManager = Exercise2.getInstance();

        // Get configuration values
        String appName = configManager.getConfig("app.name", "DefaultAppName");
        String appVersion = configManager.getConfig("app.version", "0.0.1");

        System.out.println("App Name: " + appName);
        System.out.println("App Version: " + appVersion);

        // Access an environment variable fallback
        String homePath = configManager.getConfig("HOME", "/default/path");
        System.out.println("Home Path: " + homePath);
    }
}

interface Configurer {
    String getConfig(String key, String defaultValue);
    String getConfig(String key);
}
