package com.sample;

import org.junit.*;

public class SetupTeardownTest {
    private Calculator calc;

    @Before
    public void setup() {
        calc = new Calculator();
        System.out.println("Before each test");
    }

    @After
    public void teardown() {
        System.out.println("After each test");
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(10, calc.add(7, 3));
    }
}
