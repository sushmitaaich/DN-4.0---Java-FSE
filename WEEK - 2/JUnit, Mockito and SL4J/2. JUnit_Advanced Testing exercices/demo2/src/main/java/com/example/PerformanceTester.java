package com.example;

public class PerformanceTester {
    public void performTask() {
        try {
            Thread.sleep(500); // simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
