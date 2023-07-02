package selenium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.PropertyReader;

public class WebdriverClient {

    public static WebDriver driver;
	static PropertyReader properties = new PropertyReader();


    public WebdriverClient(){}
    
    public WebDriver driverInit() throws IOException {
        String browserName = properties.getPropValues("browser");
        if (browserName == "chrome"){
            driver = new ChromeDriver();    
        }else if(browserName == "firefox"){
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }
}
