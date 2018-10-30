import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestBaidu {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger("baidu");
        PropertyConfigurator.configure("Log4j.properties");

        System.setProperty("webdriver.gecko.driver", "D:/idea/geckodriver.exe");
        System.setProperty ( "webdriver.firefox.bin" , "E:/firefox/firefox.exe" );

        WebDriver driver = new FirefoxDriver();
        logger.info("启动浏览器");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("隐式等待10秒");

        driver.get("http://www.baidu.com");
        logger.info("打开百度首页");

        driver.findElement(By.id("kw")).sendKeys("selenium");
        logger.info("在搜索框输入selenium");

        driver.quit();
        logger.info("退出");
    }
}
