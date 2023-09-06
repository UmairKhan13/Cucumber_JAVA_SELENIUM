package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
                    glue = {"org.example.stepDefinitions"},
                    plugin = {"pretty", "html:cucumber-report/report.html", "json:cucumber-report/cucumber.json"},
                    monochrome = true,
                    publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}