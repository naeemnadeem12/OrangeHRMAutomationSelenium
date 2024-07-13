package myTestProject;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\wajiz.pk\\Downloads\\Chrome\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://adactinhotelapp.com/index.php");
        Thread.sleep(10000);
        LoginPage login = new LoginPage();
        login.loginWithValidEmailValidPassword(driver);

        //verification
        String text = driver.findElement(By.className("welcome_menu")).getText();
        if(text.contains("Welcome to Adactin Group of Hotels"))
            System.out.println("successfully Login");

        login.Logout(driver);

        String url = driver.getCurrentUrl();
        System.out.println(url);
        driver.quit();
    }
}
