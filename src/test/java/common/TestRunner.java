package common;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue={"steps"},
        plugin={ "pretty", "html:target/cucumber-reports/test-report.html" },
        monochrome=true,
        dryRun=false
)


public class TestRunner { }
