package stepDefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import keyWords.ClickOnBasicActions;
import keyWords.ClickOnGreenActions;
import keyWords.DragMeActions;
import keyWords.PopupActions;
import keyWords.RepaintActions;

public class Steps1 {
	WebDriver driver;
	ClickOnBasicActions basiactions;
	ClickOnGreenActions green;
	RepaintActions repaintActions;
	DragMeActions dragMe;
	PopupActions popup;
	@Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
	    
	     String url="http://10.0.1.86/tatoc";
	     System.setProperty("webdriver.chrome.driver", "C:\\Users\\rambhuwanrajpoot\\Downloads\\chromedriver.exe");
	     
	     driver=new ChromeDriver();
	     System.out.println("initialized driver ");
	     driver.get(url);
	     driver.manage().window().maximize();
	     
	      basiactions = new ClickOnBasicActions(driver) ;
	      green=new ClickOnGreenActions(driver);
	      repaintActions=new RepaintActions(driver);
	      dragMe=new DragMeActions(driver);
	      popup=new PopupActions(driver);
	}

	@When("^user click on basic course$")
	public void user_click_on_basic_course() throws Throwable {
		basiactions.clickOnBasic();
		System.out.println("click on basic");
}
	@When("^click on green$")
	public void click_on_green() throws Throwable {
	   green.clickOnGreen();
	}
    @When("^user is on repaint page and click on repaint untill color matches$")
	public void user_is_on_repaint_page_and_click_on_repaint_untill_color_matches() throws Throwable {
	   repaintActions.Repaint();
	}
	@When("^click on dragMe$")
	public void click_on_dragMe() {
		dragMe.dragMe();
	}
	@When("^user is on popup Page$")
	public void user_is_on_popup_Page() throws Throwable {
	   popup.popUp();
	}
    @Then("^user is on complete  page$")
	public void user_is_on_completes_page() throws Throwable {
	    WebElement finish=driver.findElement(By.xpath("//h1[@class=\"finish\"]"));
	    String finishText=finish.getText();
	    assertEquals(finishText, "End");
	    System.out.println("finished");
	}
}
