package org.exercises.designpatterns.ProxyPattern.Exercise1;

import java.util.HashMap;
import java.util.Map;

public class RemoteServiceProxy implements RemoteService {
    private RealRemoteService realService;
    private Map<String, String> cache;

    public RemoteServiceProxy() {
        this.realService = new RealRemoteService();
        this.cache = new HashMap<>();
    }

    @Override
    public String fetchData(String query) {
        // Check if the response is already in cache
        if (cache.containsKey(query)) {
            System.out.println("Returning cached data for query: " + query);
            return cache.get(query);
        }

        // If not in cache, retrieve from remote service and store in cache
        String data = realService.fetchData(query);
        cache.put(query, data);
        return data;
    }
}

class Main {
    public static void main(String[] args) {
        RemoteService service = new RemoteServiceProxy();

        // First request (fetches from remote and caches the result)
        System.out.println(service.fetchData("exampleQuery1"));

        // Second request (returns cached result)
        System.out.println(service.fetchData("exampleQuery1"));

        // New query (fetches from remote and caches the result)
        System.out.println(service.fetchData("exampleQuery2"));
    }
}

