package tests;

import org.testng.annotations.Test;
import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	LoginPage lp = new LoginPage();
	
	DataFile df = new DataFile();
	
  @BeforeMethod
  public void beforeMethod() throws IOException {  	
	  lp.openBrowser();
	  lp.openYahoo();
  }

  @AfterMethod
  public void afterMethod() {
	  lp.closeBrowser();
  }
  
  @Test
  public void loginWithWrongPasswordTest() throws InterruptedException {
	  lp.enterEmail(df.correctEmail); 
	  Thread.sleep(1000);   //use 60000 if captcha comes
	  lp.enterPassword(df.wrongPass); 
	  Assert.assertEquals(lp.readPasswdError(), df.passwordError);	   
  }
  
  @Test
  public void loginWithWrongEmail() throws InterruptedException {
	  lp.enterEmail(df.wrongEmail); 
	  Thread.sleep(1000);
	  Assert.assertEquals(lp.readEmailError(), df.emailError);
  }
  

}
