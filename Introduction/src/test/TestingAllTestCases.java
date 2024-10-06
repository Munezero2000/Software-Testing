package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// The test suite is used to organize classes that can be tested together at once

@RunWith(Suite.class)
@SuiteClasses({ CalculationTest.class, QuizTest.class })
public class TestingAllTestCases {

}
