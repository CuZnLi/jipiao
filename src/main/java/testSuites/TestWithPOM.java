package testSuites;

import org.openqa.selenium.WebDriver;;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.JdHomePage;

import java.util.concurrent.TimeUnit;

public class TestWithPOM {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "D:/idea/chromedriver.exe");
        System.setProperty ( "webdriver.chrome.bin" , "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe" );

        driver = new ChromeDriver();
        driver.get("https://www.jd.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);



    }

    @Test
    public void test(){
        JdHomePage jh = PageFactory.initElements(driver,JdHomePage.class);
        jh.login("abcc","123345");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
