import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.DriverFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/idea/chromedriver.exe");
        System.setProperty ( "webdriver.chrome.bin" , "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe" );
        WebDriver driver=new ChromeDriver();
        driver.get("http://flight.qunar.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        WebElement from_inpox = driver
                .findElement(By
                        .xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='fromCity']"));
        WebElement to_inpox = driver
                .findElement(By
                        .xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='toCity']"));
        WebElement from_date = driver
                .findElement(By
                        .xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='fromDate']"));
        WebElement sigleWayCheckBox = driver
                .findElement(By
                        .xpath("//div[@id='js_flighttype_tab_domestic']//input[@class='inp_chk js-searchtype-oneway']"));
        if (!sigleWayCheckBox.isSelected()) {
            sigleWayCheckBox.click();
        }

        from_inpox.clear();
        from_inpox.sendKeys("BJ");
        Thread.sleep(8000);
        By bj = new By.ByXPath(
                "//div[@class='qcbox-fixed js-suggestcontainer']//td[contains(text(),'北京')]");
        if (isElementPresent(driver, bj, 20)) {
            driver.findElement(bj).click();
        }

        to_inpox.clear();
        to_inpox.sendKeys("SH");
        Thread.sleep(8000);
        By sh = new By.ByXPath(
                "//div[@class='qcbox-fixed js-suggestcontainer']//td[contains(text(),'上海')]");
        if (isElementPresent(driver, sh, 20)) {
            driver.findElement(sh).click();
        }

        // Actions actions = new Actions(driver);
        // actions.moveToElement(from_inpox).click().perform();
        // driver.findElement(
        // By.xpath("//div[@data-panel='domesticfrom-flight-hotcity-from']//a[@class='js-hotcitylist' and text()='西安']"))
        // .click();
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        // actions.moveToElement(to_inpox).click().perform();
        // driver.findElement(
        // By.xpath("//div[@data-panel='domesticto-flight-hotcity-to']//a[@class='js-hotcitylist' and text()='北京']"))
        // .click();
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        from_date.clear();
        from_date.sendKeys(getDateAfterToday(7));
        WebElement search = driver
                .findElement(By
                        .xpath("//div[@id='js_flighttype_tab_domestic']//button[@class='btn_search']"));
        search.submit();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        WebElement page2 = driver.findElement(By
                .xpath("//div[@id='hdivPager']/a[@value='2']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", page2);
        page2.click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.findElement(
                By.xpath("(//div[@class='avt_trans']//p[contains(text(),'每段航班均需缴纳税费')]/ancestor::div//div[@class='a_booking']/a)[3]"))
                .click();
        WebElement element=driver.findElement(
                By.xpath("//div[@id='flightbarXI883']//div[@class='t_bk']/a"));
        element.isDisplayed();

    }

    public static String getDateAfterToday(int dateAfterToday) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +dateAfterToday);
        System.out.println(cal.getTime().toString());
        Date date = cal.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(date));
        return df.format(date);
    }


    public static boolean isElementPresent(WebDriver driver, final By by,
                                           int timeOut) throws InterruptedException {
        boolean isPresent = false;
        Thread.sleep(timeOut * 1000);
        List<WebElement> we = driver.findElements(by);
        if (we.size() != 0) {
            isPresent = true;
        }
        return isPresent;
    }
}
