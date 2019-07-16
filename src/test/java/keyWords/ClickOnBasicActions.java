package keyWords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.ReadFilee;

public class ClickOnBasicActions {
	 WebDriver driver;
	
	
	public ClickOnBasicActions(WebDriver driver) {
		this.driver=driver;
	}
	
	public  void clickOnBasic() {
		WebElement basic =ReadFilee.getElement(driver, "Basic", "locator.txt") ;
		basic.click();
		// Inserting a comment line on Automation_Ram Branch
   }
}
