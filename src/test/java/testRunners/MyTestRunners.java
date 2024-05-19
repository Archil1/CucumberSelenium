package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { ".\\src\\test\\resource\\com\\features" }, glue = { "stepdefinitions", "AppHooks" }, plugin = {
		"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/"})
public class MyTestRunners {

}
/*with cucumber junit parallel execution happens on feature level not scenario level , which means junit will run each feature on a single browser and the scenarios in those feature file will be run one by one (we can solve this issue with cucumber with testng)
 * 
 */
