package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.opera.OperaDriver;
//import org.openqa.selenium.opera.OperaOptions;


public class BaseTest {

    public WebDriver driver;
    //public OperaOptions options;

    @Before
    public void setup(){
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\Tanja\\OneDrive\\Radna površina\\ISPITQA\\Ispit\\lib\\geckodriver.exe");
        //driver = new FirefoxDriver();

        System.setProperty("webdriver.chromedriver", "C:\\Users\\Tanja\\OneDrive\\Radna površina\\ISPITQA\\Ispit\\lib\\chromedriver.exe");
        driver = new ChromeDriver();
        
        //System.setProperty("webdriver.opera.driver", "C:\\Users\\Tanja\\OneDrive\\Radna površina\\ISPITQA\\Ispit\\lib\\operadriver.exe");
        //options = new OperaOptions();
        //options.addArguments("start-maximized");
        //options.addArguments("headless");
        //driver = new OperaDriver(options);
        
        
        driver.manage().window().maximize();
    }

    @After
    public void teardown(){
        driver.quit();
    }


    
}
