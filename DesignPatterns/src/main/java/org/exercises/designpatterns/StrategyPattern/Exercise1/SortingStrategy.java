package org.exercises.designpatterns.StrategyPattern.Exercise1;

import java.util.List;

public interface SortingStrategy {
    void sort(List<Integer> data);
}

class BubbleSort implements SortingStrategy {
    @Override
    public void sort(List<Integer> data) {
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data.get(j) > data.get(j + 1)) {
                    // Swap data[j] and data[j+1]
                    int temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                }
            }
        }
        System.out.println("Sorted using Bubble Sort: " + data);
    }
}

class SelectionSort implements SortingStrategy {
    @Override
    public void sort(List<Integer> data) {
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (data.get(j) < data.get(minIndex)) {
                    minIndex = j;
                }
            }
            // Swap data[i] and data[minIndex]
            int temp = data.get(minIndex);
            data.set(minIndex, data.get(i));
            data.set(i, temp);
        }
        System.out.println("Sorted using Selection Sort: " + data);
    }
}
