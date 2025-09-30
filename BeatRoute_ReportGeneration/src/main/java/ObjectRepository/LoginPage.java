package ObjectRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.BaseClass;

public class LoginPage extends BaseClass{
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Please enter your email']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@value='PROCEED']")
	private WebElement proceedButton;
	
	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//input[@value='Log In']")
	private WebElement logInButton;
	
	@FindBy(xpath = "//body[1]/div[5]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[2]/div[1]/div[1]/i[1]")
	private WebElement activityLog;
	
	@FindBy(xpath = "//a[contains(@href,'/download/CSV/logRequest/type/activity')]")
	private WebElement generateFile;
	
	@FindBy(xpath = "//a[@href='/download/CSV/getLast/type/activity']")
	private WebElement downloadButton;
	
	Date date = new Date();
	public void clikOnDateChange() {
		try {
	        SimpleDateFormat sim = new SimpleDateFormat("dd MMM, yyyy");
	        String day = sim.format(date);

	        WebElement dateChange = driver.findElement(By.xpath(
	            "//div[@id='activityDateFilterTrigger1']//span[@class='printDate'][normalize-space()='" + day + "']"));
	        dateChange.click();
	        
	        System.out.println("Clicked on date");
		}catch (Exception e) {
			System.out.println("Not able to click on date " + e);
		}
	}
	
	public void clickOnReportDate() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd");
	        String day1 = sdf.format(date);
	        WebElement reportDate = driver.findElement(By.xpath("//a[@data-date='" + day1 + "']"));
	        reportDate.click();
			
		}catch (Exception e) {
			System.out.println("Not able to click on date " + e);
		}
	}
	
	public void clickOnsecondReportDate() {
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
	        String day2 = sdf1.format(date);
	        WebElement reportDate1 = driver.findElement(By.xpath("//a[@data-date='" + day2 + "']"));
	        reportDate1.click();
		}catch (Exception e) {
			System.out.println("Not able to click on reportDate " + e);
		}
	}

}
