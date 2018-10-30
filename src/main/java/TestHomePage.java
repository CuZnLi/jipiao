import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestHomePage {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:/idea/chromedriver.exe");
        System.setProperty ( "webdriver.chrome.bin" , "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe" );
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();
    }
}
