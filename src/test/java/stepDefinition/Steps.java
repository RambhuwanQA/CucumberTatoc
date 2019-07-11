package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	WebDriver driver;
	@Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
	    
	    String url="http://10.0.1.86/tatoc";
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\rambhuwanrajpoot\\Downloads\\chromedriver.exe");
	     driver=new ChromeDriver();
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	@When("^user click on basic course$")
	public void user_click_on_basic_course() throws Throwable {
		WebElement basic =driver.findElement(By.xpath("//a[text()=\"Basic Course\"]")) ;
		basic.click();
		System.out.println("click on basic");
		WebElement green = driver.findElement(By.xpath("//div[@class=\"greenbox\"]"));
		green.click();
		System.out.println("click on green");
		driver.switchTo().defaultContent();
		

		driver.switchTo().frame("main");
		System.out.println("Switched to Main frame");
		String color1 = driver.findElement(By.xpath("//div[text()=\"Box 1\"]")).getCssValue("background-color");
		System.out.println("color1: " + color1);
		driver.switchTo().frame("child");
		System.out.println("switched to child frame");

		String color2 = driver.findElement(By.xpath("//div[text()=\"Box 2\"]")).getCssValue("background-color");
		System.out.println("color2 :" + color2);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		WebElement rePaint = driver.findElement(By.xpath("//a [text()=\"Repaint Box 2\"]"));
		System.out.println("running");
		while (true) {
			System.out.println("color1: " + color1 + " color2: " + color2);
			if (color1.contentEquals(color2)) {
				System.out.println("color matched");
				break;
			} else {
				driver.switchTo().defaultContent();
				driver.switchTo().frame("main");
				rePaint.click();
				Thread.sleep(100);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("main");
				driver.switchTo().frame("child");
				color2 = driver.findElement(By.xpath("//div[text()=\"Box 2\"]")).getCssValue("background-color");
			}
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		WebElement proceed = driver.findElement(By.xpath("//a [text()=\"Proceed\"]"));
		proceed.click();
		System.out.println("click on proceed");
		WebElement dragMe = driver.findElement(By.cssSelector(".ui-draggable"));
		System.out.println("drag me");
		WebElement dropBox = driver.findElement(By.xpath("//div[text()=\"DROPBOX\"]"));
		Actions action = new Actions(driver);
		Action dragAndDrop = action.clickAndHold(dragMe).moveToElement(dropBox).release(dropBox).build();
		dragAndDrop.perform();

		WebElement proceed2 = driver.findElement(By.xpath("//a[text()=\"Proceed\"]"));
		proceed2.click();
		WebElement popPup = driver.findElement(By.xpath("//a[text()=\"Launch Popup Window\"]"));
		System.out.println("click on proceed");
		popPup.click();
		Thread.sleep(200);
		//System.out.println("number of windows " + driver.getWindowHandles().size());
       String parent=driver.getWindowHandle();
		Set<String> parentWindow=driver.getWindowHandles();
        System.out.println(parentWindow+"+==============");
        Iterator<String>itr=parentWindow.iterator();
        while(itr.hasNext()) {
        	String childWindow=itr.next();
        	driver.switchTo().window(childWindow);
        
        }
		WebElement message = driver.findElement(By.xpath("//input[@id=\"name\"]"));
		message.click();
		message.sendKeys("Text");
		Thread.sleep(200);
		WebElement submit = driver.findElement(By.xpath("//input[@id=\"submit\"]"));
		submit.click();
		System.out.println("click on submit");
		Thread.sleep(200);
		driver.switchTo().window(parent);
		System.out.println("switched or not");
		
		WebElement proceed3=driver.findElement(By.xpath("//a[text()=\"Proceed\"]"));
		proceed3.click();
		Thread.sleep(200);
		
		WebElement Gentoken=driver.findElement(By.xpath("//a[text()=\"Generate Token\"]"));
		Gentoken.click();
		Thread.sleep(100);
		String token=driver.findElement(By.xpath("//span[@id=\"token\"]")).getText().substring(7);
		System.out.println(token+" :token value");
		Cookie value=new Cookie("Token", token);
		
		driver.manage().addCookie(value);
		driver.findElement(By.xpath("//a[text()=\"Proceed\"]")).click();
		Thread.sleep(200);
	}

	@Then("^user is on grid page$")
	public void user_is_on_grid_page() throws Throwable {
	    WebElement finish=driver.findElement(By.xpath("//span[text()=\"Obstacle Course is Complete!\"]"));
	    assertEquals(finish, "Obstacle Course is Complete!");
	}
	
}
