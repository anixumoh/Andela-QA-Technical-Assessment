//package ugo;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class AddSkill {
	static WebDriver driver;
	
	
 @BeforeMethod
 public void setup() {
	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
   driver = new ChromeDriver ();
 

 }
  
 
 @Test
 public void addSkill1() {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
  driver.get("https://qa.my.andela.com/");
  driver.findElement(By.cssSelector("#okta-signin-username")).clear();
  driver.findElement(By.cssSelector("#okta-signin-username")).sendKeys("test-engineer@andela.com");
  driver.findElement(By.xpath("//input[@name='password']")).clear();
  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Wonder_123");
  driver.findElement(By.cssSelector("#okta-signin-submit")).click();
  driver.manage().window().maximize();
  
  WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-resume[1]/app-tabs[1]/app-engineer-about[1]/div[1]/app-skills-and-tools[1]/section[1]/div[1]/span[1]/app-button[2]/button[1]"));
  JavascriptExecutor js = (JavascriptExecutor) driver;
  js.executeScript("arguments[0].scrollIntoView();", element);
  
  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-resume[1]/app-tabs[1]/app-engineer-about[1]/div[1]/app-skills-and-tools[1]/section[1]/div[1]/span[1]/app-button[2]/button[1]")).click();
  driver.findElement(By.cssSelector("#skillname")).sendKeys("Selenium");
  driver.findElement(By.xpath("//span[@class='mat-option-text']")).click();
  driver.findElement(By.xpath("//div[@class='mat-select-value']")).click();
  driver.findElement(By.xpath("//span[contains(text(),'Expert')]")).click();
  driver.findElement(By.cssSelector("#years-label")).sendKeys("7");
 
  driver.findElement(By.xpath("//span[contains(text(),'Add Skill')]")).click();
  
  
  
  //TO VERIFY IF SKILL WAS SUCCESSFULL ADDED 
  if (driver.getPageSource().contains("Selenium"))
  {
  	System.out.println("Skill has been successfully added");
  }
  else
  {
  	System.out.println("Adding new skill was unsuccessful");
  }
  }
  
 
 @AfterMethod
 public void after1() throws InterruptedException  {
	 Thread.sleep(4000);
	 driver.quit();
	 
 }
 
 
}