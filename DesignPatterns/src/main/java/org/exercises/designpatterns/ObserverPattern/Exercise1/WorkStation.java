package org.exercises.designpatterns.ObserverPattern.Exercise1;

public class WorkStation {
    public static void main(String[] args) {
        // Create a WeatherStation
        WeatherStation weatherStation = new WeatherStation();

        // Create observers
        Display display1 = new Display("Display1");
        Display display2 = new Display("Display2");
        DataLogger dataLogger = new DataLogger();

        // Register observers with the weather station
        weatherStation.addObserver(display1);
        weatherStation.addObserver(display2);
        weatherStation.addObserver(dataLogger);

        // Simulate weather data updates
        System.out.println("Setting weather data...");
        weatherStation.setWeatherData(25.3f, 65.0f, 1013.1f);

        System.out.println("Setting new weather data...");
        weatherStation.setWeatherData(28.7f, 70.0f, 1009.5f);

        // Optionally, remove an observer and update data again
        weatherStation.removeObserver(display2);

        System.out.println("Setting new weather data after removing Display2...");
        weatherStation.setWeatherData(22.0f, 60.0f, 1015.2f);
    }
}
