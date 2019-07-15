package keyWords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.ReadFilee;

public class ClickOnBasicActions {
	static WebDriver driver;
	
	
	public ClickOnBasicActions(WebDriver driver) {
		this.driver=driver;
	}
	
	public static void clickOnBasic() {
		WebElement basic =ReadFilee.getElement(driver, "clickOnBasic", "locator.txt") ;
		basic.click();
   }
}
