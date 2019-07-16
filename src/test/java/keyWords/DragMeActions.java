package keyWords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.ReadFilee;

public class DragMeActions {
    WebDriver driver;
	
	public DragMeActions(WebDriver driver) {
		this.driver=driver;
	}
	public  void dragMe() {
		    WebElement dragMe =ReadFilee.getElement(driver, "dragMe", "locator.txt");
			
			WebElement dropBox = ReadFilee.getElement(driver, "dropBox", "locator.txt");
			Actions action = new Actions(driver);
			Action dragAndDrop = action.clickAndHold(dragMe).moveToElement(dropBox).release(dropBox).build();
			dragAndDrop.perform();

			WebElement proceed2 = ReadFilee.getElement(driver, "proCeed2", "locator.txt");
			proceed2.click();
	}

}
