package org.exercises.designpatterns.ProxyPattern.Exercise1;

public interface RemoteService {
    String fetchData(String query);
}

class RealRemoteService implements RemoteService {
    @Override
    public String fetchData(String query) {
        // Simulate network latency
        System.out.println("Fetching data from remote service for query: " + query);
        try {
            Thread.sleep(2000); // simulate 2 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Data for " + query;
    }
}
