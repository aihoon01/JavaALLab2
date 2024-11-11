package org.exercises.designpatterns.AdapterPattern;

public class Exercise2 {
    public static void main(String[] args) {
        // Path to the CSV file (make sure this file exists for testing)
        String filePath = "data.csv";

        // Create an instance of the CSVFileReader
        CSVFileReader csvFileReader = new CSVFileReader(filePath);

        // Create the adapter to make CSVFileReader compatible with DataSource
        DataSource dataSource = new CSVAdapter(csvFileReader);

        // Fetch data using the common DataSource interface
        String data = dataSource.fetchData();
        System.out.println("Data fetched from CSV:");
        System.out.println(data);
    }
}
