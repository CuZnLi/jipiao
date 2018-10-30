package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JdHomePage {

    //登录按钮
    @FindBy(id="loginsubmit")
    WebElement login_button;

    //登录界面
    @FindBy(xpath = ".//*[@id='ttbar-login']/a[1]")
    WebElement login_link;

    //登录方式切换
    @FindBy(xpath = ".//*[@id='content']/div[2]/div[1]/div/div[3]/a")
    WebElement login_method;

    //输入用户对话框
    @FindBy(id="loginname")
    WebElement inputBox_username;

    //输入密码框
    @FindBy(id="nloginpwd")
    WebElement login_submitBtn;

    //登录
    public void login(String username, String password){
        login_link.click();
        login_method.click();
        inputBox_username.sendKeys(username);
        login_submitBtn.sendKeys(password);
        login_button.click();
    }
}
