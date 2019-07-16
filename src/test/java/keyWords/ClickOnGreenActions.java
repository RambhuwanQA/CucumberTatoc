package keyWords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.ReadFilee;

public class ClickOnGreenActions {
     WebDriver driver;
     public ClickOnGreenActions(WebDriver driver) {
    	 this.driver=driver;
     }
	public void clickOnGreen() {
		WebElement green = ReadFilee.getElement(driver, "GreenBox", "locator.txt");
		green.click();
	}

}
