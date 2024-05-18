package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { ".\\src\\test\\resource\\com\\features" }, glue = { "stepdefinitions", "AppHooks" }, plugin = {
		"pretty"})
public class MyTestRunners {

}
