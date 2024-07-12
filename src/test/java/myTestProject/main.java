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
        driver.get("http://localhost/Employee-management-system/");
        driver.findElement(By.xpath("//a[@href='employee/dashboard.php']")).click();
        driver.findElement(By.name("email")).sendKeys("hamzakhan@gmail.com");
        driver.findElement(By.name("password")).sendKeys("11");
        driver.findElement(By.name("signin")).click();
        Thread.sleep(2000);
        driver.quit();

    }
}
