package step_definition;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class admin_allows_access {
	 WebDriver driver;
	@Given("^user should launch the application by entering valid URL and Admit should logged in$")
	public void user_should_launch_the_application_by_entering_valid_URL_and_Admit_should_logged_in() throws Throwable {
		  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://localhost:8585/do/login");
			 

		
	    
	}

	@When("^User gives valid credentials in member login textbox$")
	public void user_gives_valid_credentials_in_member_login_textbox() throws Throwable {
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		  driver.findElement(By.xpath("//input[@value='1']")).click();
		  driver.findElement(By.xpath("//input[@value='2']")).click();
		  driver.findElement(By.xpath("//input[@value='3']")).click();
		  driver.findElement(By.xpath("//input[@value='4']")).click();
		  driver.findElement(By.xpath("//input[@value='Submit']")).click();
		  
		  driver.findElement(By.id("memberUsername")).sendKeys("p");
		  Robot robot = new Robot();
		  Thread.sleep(4000);
		  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		  WebElement element = driver.findElement(By.xpath("//input[@linkurl='changeMemberGroup?memberId=3']"));
		  element.click();
		  //driver.findElement(By.id("newGroupId")).getAttribute("Full Brokers");
		 Select data = new Select(driver.findElement(By.xpath("//*[contains(@name, 'newGroupId')]")));
		 data.selectByIndex(3);
		 
		  driver.findElement(By.name("comments")).sendKeys("hi");
		  driver.findElement(By.xpath("//input[@value='Submit']")).click();
		  String expected = "The member's group was changed";
		 Alert alert = driver.switchTo().alert();
		  String actual = alert.getText();
		  Assert.assertEquals(expected, actual);
		   System.out.println(actual);
		   alert.accept();
		  
		  

		
	    
	}



	@Then("^Click on Submit button and click ok in poppup$")
	public void click_on_Submit_button_and_click_ok_in_poppup() throws Throwable {
	   
	}


}
