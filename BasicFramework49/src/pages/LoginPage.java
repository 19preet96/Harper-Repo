package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	/*
	 * public WebElement email = driver.findElement(By.id("login-username")); public
	 * WebElement emailNext = driver.findElement(By.id("login-signin")); public
	 * WebElement password = driver.findElement(By.id("login-passwd")); public
	 * WebElement passwordNext = driver.findElement(By.id("login-signin")); public
	 * WebElement passError =
	 * driver.findElement(By.xpath("//p[@class='error-msg']")); public WebElement
	 * emailError = driver.findElement(By.xpath("//p[@id='username-error']"));
	 */
	
	@FindBy(id= "login-username" )
	public static WebElement email;
	
	@FindBy(id= "login-signin" )
	public static WebElement emailNext;
	@FindBy(id= "login-passwd" )
	public static WebElement password;
	@FindBy(id= "login-signin" )
	public static WebElement passwordNext;
	@FindBy(xpath= "//p[@class='error-msg']" )
	public static WebElement passError;
	@FindBy(xpath= "//p[@id='username-error']" )
	public static WebElement emailError;
	
	public void openBrowser() throws IOException {
		
		FileInputStream f = new FileInputStream("C:\\Learning\\testing\\prop.properties"); // get property file and save it to f
		Properties prop = new Properties();												   // makes reference for property class
		prop.load(f);
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:/Learning/Program/SeleniumJars/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Learning/Program/SeleniumJars/chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(!(browser.equals("chrome")) && !(browser.equals("firefox"))) {
			System.out.println("Incompatible browser. Switching to Firefox");
			System.setProperty("webdriver.gecko.driver", "C:/Learning/Program/SeleniumJars/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void openYahoo() {	
		driver.get("https://login.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void enterEmail(String e) {
		 email.sendKeys(e);
		 emailNext.click();
	}
	
	public void enterPassword(String p) {
		password.sendKeys(p); 
		passwordNext.click();
	}
	
	public String readPasswdError() {
		String actualErr = passError.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readEmailError() {
		String actualErr = emailError.getText();
		System.out.println(actualErr);
		return actualErr;
	}

}
