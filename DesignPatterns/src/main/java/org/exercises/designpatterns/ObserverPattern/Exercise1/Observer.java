package org.exercises.designpatterns.ObserverPattern.Exercise1;

public interface Observer {
    void update(float temperature, float humidity, float pressure);
}


class Display implements Observer {
    private String displayId;

    public Display(String displayId) {
        this.displayId = displayId;
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Display " + displayId + " - Updated Weather Data:");
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Pressure: " + pressure + " hPa");
        System.out.println();
    }
}

class DataLogger implements Observer {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("DataLogger - Logging Weather Data:");
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Pressure: " + pressure + " hPa");
        System.out.println("Weather data logged successfully.\n");
    }
}

