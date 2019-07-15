package keyWords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.ReadFilee;

public class ClickOnGreenActions {
    static WebDriver driver;
     public ClickOnGreenActions(WebDriver driver) {
    	 this.driver=driver;
     }
	public static void clickOnGreen() {
		WebElement green = ReadFilee.getElement(driver, "clickOnGreen", "locator.txt");
		green.click();
	}

}
