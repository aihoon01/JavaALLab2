package org.exercises.testingframeworks.Mockito;

import org.exercises.testingframeworks.DataRepository;
import org.exercises.testingframeworks.FileProcessingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.mockito.Mockito.*;

class FileProcessingServiceTest {

    // Mock the DataRepository dependency
    @Mock
    private DataRepository dataRepository;

    // Inject mock into the service
    @InjectMocks
    private FileProcessingService fileProcessingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessFile() throws IOException, URISyntaxException {
        // Create a test file in resources directory with sample content
        String fileName = "test-file.txt";
        Path testFilePath = Paths.get("src/test/resources/" + fileName);
        Files.write(testFilePath, List.of("line1", "line2", "line3"));

        // Invoke the processFile method
        fileProcessingService.processFile(testFilePath);

        // Verify that the repository's saveData method was called with each line
        verify(dataRepository, times(1)).saveData("line1");
        verify(dataRepository, times(1)).saveData("line2");
        verify(dataRepository, times(1)).saveData("line3");

        // Verify that the repository's saveData method was not called with an unexpected line
        verify(dataRepository, never()).saveData("unexpectedLine");

        // Clean up the test file
        Files.delete(testFilePath);
    }
}
