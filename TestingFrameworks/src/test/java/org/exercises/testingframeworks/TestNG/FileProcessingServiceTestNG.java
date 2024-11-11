package org.exercises.testingframeworks.TestNG;

import static org.mockito.Mockito.*; // Import Mockito static methods

import org.exercises.testingframeworks.DataRepository;
import org.exercises.testingframeworks.FileProcessingService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileProcessingServiceTestNG {

    // Mock the DataRepository dependency
    @Mock
    private DataRepository dataRepository;


    private FileProcessingService fileProcessingService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Manually inject the mock
        fileProcessingService = new FileProcessingService(dataRepository);
    }

    //DataProvider provides different data sets for testing multiple scenarios
    //Of a test case without having to duplicate test codes.
    @DataProvider(name = "fileContentProvider")
    public Object[][] fileContentProvider() {
        return new Object[][]{
                { "test-file-1.txt", List.of("alpha", "beta", "gamma", "delta") },
                { "test-file-2.txt", List.of("Red", "Yellow", "Green", "White") },
                { "test-file-empty.txt", List.of() } // Testing with an empty file
        };
    }

    @Test(dataProvider = "fileContentProvider")
    public void testProcessFileWithDifferentContents(String fileName, List<String> fileContent) throws IOException, URISyntaxException {
        // Create a test file in the resources directory with the provided content
        Path testFilePath = Paths.get("src/test/resources/" + fileName);
        Files.write(testFilePath, fileContent);

        // Invoke the processFile method with the current file
        fileProcessingService.processFile(testFilePath);

        // Verify that the repository's saveData method was called with each line
        for (String line : fileContent) {
            verify(dataRepository, times(1)).saveData(line);
        }

        // Verify no unexpected interactions
        verifyNoMoreInteractions(dataRepository);

        // Clean up the test file after each test run
        Files.delete(testFilePath);
    }
}
