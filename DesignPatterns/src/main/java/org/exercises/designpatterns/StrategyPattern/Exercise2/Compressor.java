package org.exercises.designpatterns.StrategyPattern.Exercise2;

import java.io.File;

public class Compressor {
    private CompressionStrategy strategy;

    // Set the compression strategy at runtime
    public void setCompressionStrategy(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    // Compress the file using the chosen strategy
    public void compressFile(File file) {
        if (strategy == null) {
            throw new IllegalStateException("Compression strategy not set.");
        }
        strategy.compress(file);
    }
}

class Main {
    public static void main(String[] args) {
        // Example file to compress
        File file = new File("example.txt");

        // Create a Compressor instance
        Compressor compressor = new Compressor();

        // User selects ZIP compression
        System.out.println("Using ZIP compression:");
        compressor.setCompressionStrategy(new ZipCompression());
        compressor.compressFile(file);

        // User selects GZIP compression
        System.out.println("\nUsing GZIP compression:");
        compressor.setCompressionStrategy(new GzipCompression());
        compressor.compressFile(file);
    }
}
