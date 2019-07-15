package keyWords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.ReadFilee;

public class RepaintActions {
	
	static WebDriver driver;
	public RepaintActions(WebDriver driver) {
		this.driver=driver;
	}
	
	public static void Repaint() {
	driver .switchTo().defaultContent();
	driver .switchTo().frame("main");
	
	
	String color1 = ReadFilee.getElement(driver, "color1", "locator.txt").getCssValue("background-color");
	System.out.println("color1: " + color1);
	driver.switchTo().frame("child");
	
    
	String color2 = ReadFilee.getElement(driver, "color2", "locator.txt").getCssValue("background-color");
	System.out.println("color2 :" + color2);
	
	driver.switchTo().defaultContent();
	driver.switchTo().frame("main");
	WebElement rePaint = ReadFilee.getElement(driver, "rePaint","locator.txt");
	System.out.println("running");
	while (true) {
		System.out.println("color1: " + color1 + " color2: " + color2);
		if (color1.contentEquals(color2)) {
			
			break;
		} else {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			rePaint.click();
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			driver.switchTo().frame("child");
			color2 = ReadFilee.getElement(driver, "color2", "locator.txt") .getCssValue("background-color");
		}
	}

	driver.switchTo().defaultContent();
	driver.switchTo().frame("main");
	WebElement proceed =  ReadFilee.getElement(driver, "proceed1", "locator.txt");
	proceed.click();

}
}

