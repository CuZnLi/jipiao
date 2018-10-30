

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;




public class TicketScrapy {

    public static final String USER_AGENT = "Mozilla/5.0 (Linux; U; Android 4.3; en-us; SM-N900T Build/JSS15J) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";

    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "D:/idea/chromedriver.exe");
        //System.setProperty ( "webdriver.chrome.bin" , "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe" );
        //WebDriver webDriver=new ChromeDriver();
        System.setProperty("phantomjs.binary.path",
                "D:\\phantomjs\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        //创建无界面浏览器对象
        DesiredCapabilities dcaps=new DesiredCapabilities();
//        dcaps.setCapability("phantomjs.page.settings.userAgent",USER_AGENT);
//        dcaps.setCapability("phantomjs.page.customHeaders.User-Agent",USER_AGENT);
        //ssl证书支持
        dcaps.setCapability("acceptSslCerts", true);
        //截屏支持
        dcaps.setCapability("takesScreenshot", true);
        //css搜索支持
        dcaps.setCapability("cssSelectorsEnabled", true);
        dcaps.setCapability("phantomjs.page.settings.XSSAuditingEnabled",true);
        dcaps.setCapability("phantomjs.page.settings.webSecurityEnabled",false);
        dcaps.setCapability("phantomjs.page.settings.localToRemoteUrlAccessEnabled",true);
        dcaps.setCapability("phantomjs.page.settings.XSSAuditingEnabled",true);

        dcaps.setCapability("phantomjs.page.settings.loadImages",false);
        //js支持
        dcaps.setJavascriptEnabled(true);
        WebDriver webDriver = new PhantomJSDriver(dcaps);

        webDriver.manage().window().setSize(new Dimension(1920,1080));
        //设置隐性等待（作用于全局）

        webDriver.get("http://www.ctrip.com");
        Thread.sleep(2000);
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath(".//*[@id='searchBoxUl']/li[2]/b")).click();



        WebElement startCity = webDriver.findElement(By.xpath(".//*[@id='FD_StartCity']"));
        Thread.sleep(1000);
        startCity.click();
        startCity.clear();
        startCity.sendKeys("西安");
        System.out.println(startCity.isEnabled());
        WebElement desCity = webDriver.findElement(By.xpath(".//*[@id='FD_DestCity']"));
        desCity.sendKeys("盐城");
        Thread.sleep(1000);
        WebElement startTime=webDriver.findElement(By.xpath(".//*[@id='FD_StartDate']"));
        //WebElement endTime=webDriver.findElement(By.xpath(".//*[@id='FD_ReturnDate']"));

        //startCity.click();

        startTime.sendKeys("2018-12-31");
        //desCity.click();


        Thread.sleep(1000);
        webDriver.findElement(By.xpath(".//*[@id='FD_StartSearch']")).click();
        Thread.sleep(2000);
        File src=((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src,new File(".\\screen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        WebElement element = webDriver.findElement(By.xpath(".//*[@id='base_bd']/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div/div[7]/div/span"));
        System.out.println(element.getText());

        webDriver.quit();



    }
}
