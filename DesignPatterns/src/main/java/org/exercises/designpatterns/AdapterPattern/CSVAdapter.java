package org.exercises.designpatterns.AdapterPattern;

// CSV file reader class (the incompatible data source)
import java.io.*;

// Adapter class to make CSVFileReader compatible with DataSource
class CSVAdapter implements DataSource {
    private final CSVFileReader csvFileReader;

    // Constructor takes a CSVFileReader as a parameter
    public CSVAdapter(CSVFileReader csvFileReader) {
        this.csvFileReader = csvFileReader;
    }

    @Override
    public String fetchData() {
        // Uses CSVFileReader's readCSV method to get the data
        return csvFileReader.readCSV();
    }
}



class CSVFileReader {
    private String fileName;

    public CSVFileReader(String fileName) {
        this.fileName = fileName;
    }

    public String readCSV() {
        StringBuilder csvData = new StringBuilder();
        try (
             InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            if (inputStream == null) {
                throw new IOException("File not found: " + fileName);
            }

            String line;
            while ((line = br.readLine()) != null) {
                csvData.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvData.toString();
    }
}



// Common data source interface used by the application
interface DataSource {
    String fetchData();
}