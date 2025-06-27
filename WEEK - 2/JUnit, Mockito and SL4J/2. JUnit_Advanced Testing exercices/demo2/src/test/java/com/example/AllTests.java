package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    EvenCheckerTest.class,
    OrderedTests.class
})
public class AllTests {
    // This class remains empty, used only as a holder for the above annotations
}
