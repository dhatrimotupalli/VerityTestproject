package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class Googlesearch {
	
	WebDriver driver =null;

	@SuppressWarnings("deprecation")
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Step1: Browser is open");
		String projectPath = System.getProperty("user.dir");
		System.out.println("project path is :"+projectPath);
		System.setProperty( "webdriver.chrome.driver",projectPath+"/src/test/java/Drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() throws InterruptedException {
		System.out.println("Step2: Browser shows Google search Page");
		driver.navigate().to("https://google.com");
		Thread.sleep(3000);
	}

	@When("user enters software as a keyword on search textbox")
	public void user_enters_software_as_a_keyword_on_search_textbox() throws InterruptedException {
		System.out.println("Step3: User enters search keyword Software");
		driver.findElement(By.name("q")).sendKeys("Software");
		Thread.sleep(10000);
	}

	@And("user click on search button or hits enter")
	public void user_click_on_search_button_or_hits_enter() throws InterruptedException {
		System.out.println("Step4: User hits enter or clicks on Search button");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(10000);
	}

	@Then("user should be navigated to search results page viewing Wikipedia link as the first result")
	public void user_should_be_navigated_to_search_results_page_viewing_wikipedia_link_as_the_first_result() throws InterruptedException {
		System.out.println("Step5: Browser should display search result - wikipedia as first result");
		driver.getPageSource().contains("Software - Wikipedia");
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();

	}
}







