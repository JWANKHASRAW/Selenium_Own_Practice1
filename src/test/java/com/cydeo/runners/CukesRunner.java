package com.cydeo.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {

                "html:target/cucumber-reports.html", //generating .html reports
                "rerun:target/rerun.txt", // generating .txt reports
                "me.jvt.cucumber.report.PrettyReports:target/cucumber" // generating cucumber reports (target//cucumber//overview.features



        },

        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false,
        tags = "@AllModules"




)




public class CukesRunner {






}
