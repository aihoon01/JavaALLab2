package org.exercises.designpatterns.ProxyPattern.Exercise2;

public interface FileDownloader {
    void downloadFile(String fileName);
}

class RealFileDownloader implements FileDownloader {
    @Override
    public void downloadFile(String fileName) {
        System.out.println("Downloading file: " + fileName);

        // Simulate file download with progress
        for (int i = 0; i <= 100; i += 20) {
            try {
                Thread.sleep(500); // simulate download time for each progress step
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Download progress: " + i + "%");
        }

        System.out.println("Download completed: " + fileName);
    }
}
