package org.exercises.designpatterns.StrategyPattern.Exercise2;

import java.io.File;

public interface CompressionStrategy {
    void compress(File file);
}

class ZipCompression implements CompressionStrategy {
    @Override
    public void compress(File file) {
        System.out.println("Compressing " + file.getName() + " using ZIP compression.");
        // Here you would add actual ZIP compression logic.
    }
}

class GzipCompression implements CompressionStrategy {
    @Override
    public void compress(File file) {
        System.out.println("Compressing " + file.getName() + " using GZIP compression.");
        // Here you would add actual GZIP compression logic.
    }
}

