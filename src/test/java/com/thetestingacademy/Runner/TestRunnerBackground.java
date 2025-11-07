package com.thetestingacademy.base.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/feature/BackgroundDemo/BackgroundDemo.feature",
        glue={"com/thetestingacademy/StepDefinitionBackground",
                "com.thetestingacademy.base"},
        monochrome=true ,
        plugin={"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunnerBackground extends AbstractTestNGCucumberTests {
}

