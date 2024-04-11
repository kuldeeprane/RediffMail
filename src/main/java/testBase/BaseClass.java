package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class BaseClass {
	static public  WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeMethod(groups= {"sanity", "regression", "master"})
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException {
		//loading log4j2 file
		logger  = LogManager.getLogger(this.getClass()); //gtting the name of the curret calss this.getclass
		
		//Config file for common values
		FileReader fil = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(fil);
		
		//driver setup
		switch (br.toLowerCase()){
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		default : System.out.println("No matching browser.....");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("appurl"));
		
	}
	
	@AfterMethod(groups= {"sanity", "regression", "master"})
	public void tearDown() {
		driver.close();
	}
	
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());  //setting timestamp
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;		//screenshot code
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);		//taking file as an output
		
		//setting name of the file
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);	//setting path of the file	
		
		sourceFile.renameTo(targetFile);	//copying source file to the target file
			
		return targetFilePath;

	}

}
