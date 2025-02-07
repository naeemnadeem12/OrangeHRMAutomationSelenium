package myTestProject;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.configUtils;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\wajiz.pk\\Downloads\\Chrome\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Properties prop =  configUtils.getProps("data");

        driver.get(prop.getProperty("URL"));
        Thread.sleep(10000);
        LoginPage login = new LoginPage(driver);
        login.loginWithValidEmailValidPassword();

        //verify Login successfully
        String text = driver.findElement(By.className("welcome_menu")).getText();
        if(text.contains("Welcome to Adactin Group of Hotels"))
            System.out.println("successfully Login");

        login.Logout();
        //verify Logout successfully
        String text1 = driver.findElement(By.className("reg_success")).getText();
        if (text1.contains("You have successfully logged out.")){
            System.out.println("Logout succesffully");
        }
        //Get Url in Console
        String url = driver.getCurrentUrl();
        System.out.println(url);

        //Close Selenium Driver
        driver.quit();
    }
}
