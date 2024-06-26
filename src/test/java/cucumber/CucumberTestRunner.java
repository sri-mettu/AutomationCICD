package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.core.cli.Main;

@CucumberOptions(
features="src\\test\\java\\cucumber",
glue="srimettu.stepDefinitions",
monochrome=true,
plugin= {"html:target/cucumber.html"})

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}
//tags="" can be used to group the tests