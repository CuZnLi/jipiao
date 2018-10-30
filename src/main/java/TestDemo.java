import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestDemo {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:/idea/chromedriver.exe");
        System.setProperty ( "webdriver.chrome.bin" , "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe" );

        WebDriver webDriver=new ChromeDriver();
        webDriver.get("http://www.baidu.com");
        WebElement element=webDriver.findElement(By.xpath(".//*[@id='kw']"));
        System.out.println(element.isDisplayed());
        System.out.println(element.isEnabled());

        element.sendKeys("java");
        webDriver.findElement(By.xpath(".//*[@id='su']")).click();
        Thread.sleep(2000);
        Actions actions=new Actions(webDriver);
        element=webDriver.findElement(By.xpath(".//*[@id='1']/h3"));
        actions.contextClick(element);





    }
}
