package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)				
@CucumberOptions(
		
		features="src/resources/java/feature",
		glue={"src/test/java/stepDefinition"}
	    
		)

public class TestRunner {

}
