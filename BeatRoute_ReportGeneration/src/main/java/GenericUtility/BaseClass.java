package GenericUtility;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import ObjectRepository.LoginPage;





public class BaseClass {

	public static WebDriver driver;
//	public Driverutility driverUtility;
//	public FileUtility fileUtility;
	public LoginPage loginpage;
//	public DashBoardPage dashboardPage;
//	public StageGatePage stageGatePage ;
//	public AddBriefPage addBriefPage;
//	public AddBrief_ProductDetailPage addBrief_ProductDetailPage;
//	public CancelPage cancelPage;
//	public CommercialsPage commercialsPage;
//	public MileStonePage mileStonePage;
//	public OperationsPage operationsPage;
//	public FormReviewPage formReviewPage;
//	public FinanceLeadRequestPage financeLeadRequestPage;
//	public AddLineTrailPage addLineTrailPage;
//	public ConsumerResearchPage  consumerResearchPage;
	
	@BeforeClass
	public void Login() {
		 driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://gtfl-npd-webapp.azurewebsites.net/");
		
//		driverUtility              =new Driverutility(driver);
//		fileUtility                = new FileUtility();
		loginpage                  =new LoginPage(driver);
//		dashboardPage              = new DashBoardPage(driver);
//		stageGatePage              = new StageGatePage(driver);
//		addBriefPage               = new AddBriefPage(driver);
//		addBrief_ProductDetailPage = new AddBrief_ProductDetailPage(driver);
//		cancelPage                 = new CancelPage(driver);
//		commercialsPage            = new CommercialsPage(driver);
//		mileStonePage              = new MileStonePage(driver);
//		operationsPage             = new OperationsPage(driver);
//		formReviewPage             = new FormReviewPage(driver);
//		financeLeadRequestPage     = new FinanceLeadRequestPage(driver);
//		addLineTrailPage           = new AddLineTrailPage(driver);
//		consumerResearchPage       = new ConsumerResearchPage(driver);
	}
	
}
