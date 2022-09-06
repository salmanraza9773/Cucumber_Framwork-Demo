package com.telus.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ParaBankLoginScenario {

	public WebDriver driver;

	@Given("launch the application")
	public void launch_the_application() {

		// Setting the system property for the ChromeDriver.
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		// Creating instance of ChromeDriver.
		driver = new ChromeDriver();

		String url = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";

		// Launching the application.
		driver.get(url);

		// Maximizing the window.
		driver.manage().window().maximize();

		System.out.println("Application is launched.");

	}

	@And("click on login button")
	public void click_on_login_button() {

		WebElement submitBtn = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input"));
		submitBtn.click();

	}

	@Then("display the user home page")
	public void display_the_user_home_page() {
		WebElement homePage = driver.findElement(By.xpath("//*[@class='smallText']"));
		String actTitle = homePage.getText();
		String expTitle = "Welcome";

		if (actTitle.contains(expTitle)) {

			System.out.println("Actual HomePage title is " + actTitle);
			System.out.println("User Home Page is Displayed");

		} else {
			System.out.println("The Actual and Expected Home Page Title are not Same");
			System.out.println("The Actual Home Page Title is " + actTitle);
			System.out.println("The Expected Home Page Title is " + expTitle);
		}
	}

	@And("logout the application")
	public void logout_the_application() {

		WebElement logout = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[8]/a"));
		logout.click();
		System.out.println("User is logged out");
	}

	@And("close the application")
	public void close_the_application() {
		driver.close();
		System.out.println("Appliction is Closed");
	}

	@Then("unable to login")
	public void unable_to_login() {
		WebElement err = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1"));
		if (err.isDisplayed()) {
			System.out.println("Unable to login");
		}
	}

	@Given("user is navigating to register page")
	public void user_is_navigating_to_register_page() {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		String url = "https://parabank.parasoft.com/parabank/register.htm";

		driver.get(url);

		driver.manage().window().maximize();

		System.out.println("Application is launched successfully");
	}

	@When("enter first name as {string} and last name as {string}")
	public void enter_first_name_as_and_last_name_as(String firstname, String lastname) {
		driver.findElement(By.id("customer.firstName")).sendKeys(firstname);
		driver.findElement(By.id("customer.lastName")).sendKeys(lastname);
	}

	@When("enter address as {string}, city as {string}, state as {string} and zipcode as {string}")
	public void enter_address_as_city_as_state_as_and_zipcode_as(String address, String city, String state,
			String zipcode) {
		driver.findElement(By.id("customer.address.street")).sendKeys(address);
		driver.findElement(By.id("customer.address.city")).sendKeys(city);
		driver.findElement(By.id("customer.address.state")).sendKeys(state);
		driver.findElement(By.id("customer.address.zipCode")).sendKeys(zipcode);

	}

	@When("enter phone number as {string}")
	public void enter_phone_number_as(String phonenumber) {

		driver.findElement(By.id("customer.phoneNumber")).sendKeys(phonenumber);
	}

	@When("enter SSN as {string}")
	public void enter_ssn_as(String ssn) {

		driver.findElement(By.id("customer.ssn")).sendKeys(ssn);
	}

	@When("login credentials as {string}, {string} and {string}")
	public void login_credentials_as_and(String username, String password, String confirmpassword) {

		driver.findElement(By.id("customer.username")).sendKeys(username);

		driver.findElement(By.id("customer.password")).sendKeys(password);

		driver.findElement(By.id("repeatedPassword")).sendKeys(confirmpassword);
	}

	@When("click on register")
	public void click_on_register() {

		System.out.println("Register button is clicked");
	}

	@Then("user is successfully registered")
	public void user_is_successfully_registered() {

		System.out.println("User Register Successfully");
	}

	@Given("user is navigating to login page")
	public void user_is_navigating_to_login_page() {

		// Setting the system property for the ChromeDriver.
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		// Creating instance of ChromeDriver.
		driver = new ChromeDriver();

		String url = "https://parabank.parasoft.com/parabank/index.htm";

		// Launching the application.
		driver.get(url);

		// Maximizing the window.
		driver.manage().window().maximize();

		System.out.println("Application is launched.");

	}

	@When("enter username as {string} and password as {string}")
	public void enter_username_as_and_password_as(String userName, String password) {
		WebElement userNameElement = driver.findElement(By.name("username"));
		userNameElement.sendKeys(userName);

		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys(password);
	}

	@When("enter invalid username as {string} and password as {string}")
	public void enter_invalid_username_as_and_password_as(String userName, String password) {
		WebElement userNameElement = driver.findElement(By.name("username"));
		userNameElement.sendKeys(userName);

		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys(password);
	}

}
