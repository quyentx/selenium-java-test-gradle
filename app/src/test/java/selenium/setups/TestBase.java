package selenium.setups;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import selenium.WebdriverClient;
import utils.PropertyReader;

public class TestBase {

    static PropertyReader properties = new PropertyReader();
    public static WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        driver = new WebdriverClient().driverInit();
        driver.get(properties.getPropValues("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
    
}
