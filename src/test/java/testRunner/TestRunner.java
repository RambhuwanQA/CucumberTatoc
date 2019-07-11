package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)				
@CucumberOptions(
		features="C:\\Users\\rambhuwanrajpoot\\eclipse-workspace\\cucumber_tatoc\\feature\\abc.feature",
		glue={"src/test/java/stepDefinition"}
		
		)

public class TestRunner {

}
