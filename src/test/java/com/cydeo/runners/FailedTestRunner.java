package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt", // It will go straight to the target folder and to the rerun.txt file
        glue = "com/cydeo/step_definitions"


)
public class FailedTestRunner {


}
