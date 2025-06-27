package com.example;

public class ApiService {
    private RestClient client;

    public ApiService(RestClient client) {
        this.client = client;
    }

    public String fetchData() {
        return "Fetched " + client.getResponse();
    }
}
