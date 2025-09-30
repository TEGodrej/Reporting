package test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LiquidationReport {

	
	@Test
	public void liquidationReport() throws InterruptedException {
		 // 🔹 Set custom download path before launching browser
		

//        String downloadFilepath1 = System.getProperty("user.dir") + "/Reports";
        
        String today1 = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String downloadFilepath1 = System.getProperty("user.dir") + "/Reports"+today1;

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilepath1);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        
       
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		 
		 WebDriver driver = new ChromeDriver(options); // ✅ use this driver everywhere

	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        // Login
	        driver.get("https://gavl.uniqid.io");
	        String user = "PowerBI";
	        String paswrd = "Ganpati#123456";
	        
		WebElement userName= driver.findElement(By.id("Username"));
		userName.sendKeys(user);
		
		WebElement password= driver.findElement(By.id("Password"));
		password.sendKeys(paswrd);
		
		WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		
		Thread.sleep(Duration.ofSeconds(4));
		
		WebElement scanTab=driver.findElement(By.xpath("//mat-label[text()='Scan']"));
		scanTab.click();
		
		Thread.sleep(Duration.ofSeconds(4));
		WebElement liquidatonTab=driver.findElement(By.xpath("//mat-label[text()='Liquidation']"));
		liquidatonTab.click();
		
		Thread.sleep(Duration.ofSeconds(6));
		
		WebElement filter=driver.findElement(By.xpath("(//span[@title='Advanced filters'])[1]"));
		filter.click();
		
		WebElement customeDateRange=driver.findElement(By.xpath("//li[text()=' Custom date range ']"));
		customeDateRange.click();
		
		Thread.sleep(Duration.ofSeconds(4));
		
		LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        System.out.println("Today: " + today);
        System.out.println("Yesterday: " + yesterday);
        
        int day=yesterday.getDayOfMonth();
        
        WebElement yesterdays = driver.findElement(By.xpath("//div[text()=' "+day+" ']"));
        yesterdays.click();
        
        WebElement toDate=driver.findElement(By.xpath("//input[@value='toDate']"));
        toDate.click();
        
        WebElement yesterday1 = driver.findElement(By.xpath("//div[text()=' "+day+" ']"));
        yesterday1.click();
        
        WebElement applyButton=driver.findElement(By.xpath("//button[text()='Apply ']"));
        applyButton.click();
        
        WebElement downloadTab=driver.findElement(By.xpath("//i[@class='fa fa-download scASFIconStyle scCMCenterXY']"));
        downloadTab.click();
        
//        WebElement overAllLiquidation=driver.findElement(By.xpath("//div[@class='scASFDropdownListItems']/child::span[text()='Overall liquidation']"));
//        overAllLiquidation.click();   //div[@class='scASFDropdownListItems']/child::span[text()='Liquidation log']
        
        WebElement liquidationLog=driver.findElement(By.xpath("//div[@class='scASFDropdownListItems']/child::span[text()='Liquidation log']"));
        liquidationLog.click();
        
        WebElement downloadButton=driver.findElement(By.xpath("//button[text()='Download ']"));
        downloadButton.click();
        
        
        
        
        
		
		
	}
}
