package org.exercises.designpatterns.StrategyPattern.Exercise1;

import java.util.Arrays;
import java.util.List;

public class Sorter {
    private SortingStrategy strategy;

    // Set the sorting strategy at runtime
    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    // Execute the sorting with the selected strategy
    public void sort(List<Integer> data) {
        if (strategy == null) {
            throw new IllegalStateException("No sorting strategy set.");
        }
        strategy.sort(data);
    }
}

class Main {
    public static void main(String[] args) {
        // Sample data
        List<Integer> data = Arrays.asList(64, 25, 12, 22, 11);

        // Create the Sorter context
        Sorter sorter = new Sorter();

        // Choose Bubble Sort
        System.out.println("Using Bubble Sort:");
        sorter.setStrategy(new BubbleSort());
        sorter.sort(data);

        // Reset data for the next sort
        data = Arrays.asList(64, 25, 12, 22, 11);

        // Choose Selection Sort
        System.out.println("\nUsing Selection Sort:");
        sorter.setStrategy(new SelectionSort());
        sorter.sort(data);
    }
}