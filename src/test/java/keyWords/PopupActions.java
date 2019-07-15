package keyWords;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.ReadFilee;

public class PopupActions {
	static WebDriver driver;
	public PopupActions(WebDriver driver) {
		this.driver=driver;
	}
	public static void popUp() {
    WebElement popPup = ReadFilee.getElement(driver, "poPup", "locator.txt");
		
		popPup.click();
		 String parent=driver.getWindowHandle();
			Set<String> parentWindow=driver.getWindowHandles();
	        
	        Iterator<String>itr=parentWindow.iterator();
	        while(itr.hasNext()) {
	        	String childWindow=itr.next();
	        	driver.switchTo().window(childWindow);
	        
	        }
			WebElement message = ReadFilee.getElement(driver, "message", "locator.txt");
			message.click();
			message.sendKeys("Text");
			
			WebElement submit = ReadFilee.getElement(driver, "submit", "locator.txt");
			submit.click();
			
		
			driver.switchTo().window(parent);
			
			
			WebElement proceed3=ReadFilee.getElement(driver, "proceed3", "locator.txt");
			proceed3.click();
			
			WebElement Gentoken=ReadFilee.getElement(driver, "gentoken", "locator.txt");
			Gentoken.click();
			
			String token=ReadFilee.getElement(driver, "token", "locator.txt").getText().substring(7);
			System.out.println(token+" :token value");
			Cookie value=new Cookie("Token", token);
			
			driver.manage().addCookie(value);
			driver.findElement(By.xpath("//a[text()=\"Proceed\"]")).click();
	}

}
