package com.example;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public void pushData(String data) {
        api.sendData(data);
    }

    public String processData(String input) {
        return api.process(input);
    }
    
}
