package org.exercises.testingframeworks;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class FileProcessingService {

    private final DataRepository dataRepository;

    // Constructor with repository dependency
    public FileProcessingService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    // Method to process file and store content in repository
    public void processFile(Path filePath) throws IOException, URISyntaxException {

        // Read lines from file
        List<String> lines = Files.readAllLines(filePath);

        // Store each line in the repository
        for (String line : lines) {
            dataRepository.saveData(line);
        }
    }
}
