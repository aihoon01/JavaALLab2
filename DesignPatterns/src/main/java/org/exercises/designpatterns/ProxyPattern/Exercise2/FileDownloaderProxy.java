package org.exercises.designpatterns.ProxyPattern.Exercise2;

public class FileDownloaderProxy implements FileDownloader {
    private RealFileDownloader realDownloader;
    private String authorizedUser;

    public FileDownloaderProxy(String authorizedUser) {
        this.realDownloader = new RealFileDownloader();
        this.authorizedUser = authorizedUser;
    }

    private boolean isAuthorized(String user) {
        // Simulate an authorization check
        return user.equals(authorizedUser);
    }

    @Override
    public void downloadFile(String fileName) {
        String currentUser = getCurrentUser();
        if (isAuthorized(currentUser)) {
            System.out.println("User " + currentUser + " is authorized. Starting download...");
            realDownloader.downloadFile(fileName);
        } else {
            System.out.println("User " + currentUser + " is not authorized to download this file.");
        }
    }

    // Simulates retrieving the current user
    private String getCurrentUser() {
        // For this example, let's assume the current user is hardcoded.
        return "user1"; // Change this value to test authorization failure.
    }
}

class Main {
    public static void main(String[] args) {
        // Only "user1" is authorized to download files in this example
        FileDownloader fileDownloader = new FileDownloaderProxy("user1");

        // Attempt to download a file
        fileDownloader.downloadFile("exampleFile.zip");

        // To test an unauthorized user, change the `authorizedUser` in the `FileDownloaderProxy` constructor
    }
}

