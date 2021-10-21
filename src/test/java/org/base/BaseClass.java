package org.base;


	import java.io.File;
	import java.io.IOException;
	import java.util.Date;
import java.util.List;
import java.util.Scanner;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.opera.OperaDriver;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass{

		public  static WebDriver driver;
			public static WebDriver launchBrowser(String browserName) 
			{
				switch (browserName) {
				case "Chrome":
					WebDriverManager.chromedriver().setup();
					  driver = new ChromeDriver();
					break;
				case "Firefox":
					WebDriverManager.firefoxdriver().setup();
					  driver = new FirefoxDriver();
					break;
				case "Edge":
					WebDriverManager.edgedriver().setup();
					  driver = new EdgeDriver();
					break;
				case "Operamini":
					WebDriverManager.operadriver().setup();
					  driver = new OperaDriver();
					break;
					
				default:
					System.err.println("Invalid browser Name");
					break;
				}
			
				return driver;
		}

			public static void launchUrl(String url) 
			{
				driver.get(url);
			
			}
			
			public static void fillTextBox(WebElement e,String value) 
			{
				e.sendKeys(value);
			}
			public static void clear(WebElement e) 
			{
				e.clear();
			}
			public static void btnClick(WebElement e) 
			{
				e.click();
			}
			public static void quitBrowser( ) 
			{
				driver.quit();
			}
			
			public static String getCurrtentUrl( ) 
			{
				String url1 = driver.getCurrentUrl();
				return url1;
				
			}
			
			public static String getAttribute(WebElement e)
			{
				return e.getAttribute("value");
			}
			public static String getText(WebElement e) 
			{
				return e.getText();
			}
			
			public static void moveToElement(WebElement e) 
			{
				Actions a=new Actions(driver);
				a.moveToElement(e).perform();
			}
			
			public static void dragAndDrop(WebElement src,WebElement des) 
			{
				Actions a=new Actions(driver);
				a.dragAndDrop(src,des).perform();
			}
			public static void clickAndHold(WebElement src,WebElement des) 
			{
				Actions a=new Actions(driver);
				a.clickAndHold(src).moveToElement(des).release().build().perform();
			}
			public static void doubleClick(WebElement e) 
			{
				Actions a=new Actions(driver);
				a.doubleClick(e).perform();
			}
			public static void rightClick(WebElement e) 
			{
				Actions a=new Actions(driver);
				a.contextClick(e).perform();
			}
			public static void selectByIndex(WebElement element,int index) 
			{
				Select s=new Select(element);
				s.selectByIndex(index);
			}
			public static void selectByValue(WebElement element,String value) 
			{
				Select s=new Select(element);
				s.selectByValue(value);
			}
			public static void selectByVisibleText(WebElement element,String value) 
			{
				Select s=new Select(element);
				s.selectByVisibleText(value);
			}
			public static WebElement findElement(String locatename,String locator) 
			{
				WebElement e=null;
				if (locatename.equals("id")) {
		         e = driver.findElement(By.id(locator));
				}
				else if (locatename.equals("name")) {
				    e = driver.findElement(By.name(locator));
				}
				else if (locatename.equals("xpath")) {
				    e = driver.findElement(By.xpath(locator));
				}
				    else if (locatename.equals("tagname")) {
					    e = driver.findElement(By.tagName(locator));
				}
				return e;
		}		

	public static void timeStatic() throws InterruptedException {
		
	Thread.sleep(5000);

	}
	public static void timeDynamic() {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void maximize() {
	driver.manage().window().maximize();
	}

	public static void scrollDown(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		
	}		
	public static void scrollUp(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", e);
		
	}		
	public static void takeScreenShot(String imagename) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des=new File("E:\\TestNg\\src\\test\\resources\\Screenshots\\"+imagename+".png");
		FileUtils.copyFile(src, des);
		}				
	public static void screenshotByScanner() throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		Scanner s = new Scanner(System.in);
		String name = s.next();
		File des=new File("C:\\Users\\HP\\eclipse-workspace\\MavenS\\ScreenShotImage\\"+name+".png");
		FileUtils.copyFile(src, des);
		}				
	public static void screenshotByDate() throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		Date d=new Date();
		int date = d.getDate();
		File des=new File("C:\\Users\\HP\\eclipse-workspace\\MavenS\\ScreenShotImage\\"+date+".png");
		FileUtils.copyFile(src, des);
	}
	public static void screenshotByTime() throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
	long currentTime = System.currentTimeMillis();
		File des=new File("C:\\Users\\HP\\eclipse-workspace\\MavenS\\ScreenShotImage\\"+currentTime+".png");
		FileUtils.copyFile(src, des);
	}
	public static void navigateBack() {
	driver.navigate().back();
	}
	public static void navigateForward() {
	driver.navigate().forward();;
	}
	public static void navigateRefresh() {
	driver.navigate().refresh();;
	}



	}


