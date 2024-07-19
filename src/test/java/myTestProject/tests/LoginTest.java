package myTestProject.tests;

import myTestProject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.configUtils;

import java.util.Properties;

public class LoginTest {

    LoginPage login;
    WebDriver driver;
    @BeforeClass
    public void openPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\wajiz.pk\\Downloads\\Chrome\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        Properties prop =  configUtils.getProps("data");

        driver.get(prop.getProperty("URL"));
        Thread.sleep(10000);
    }
    @Test(description = "TestCase1 Login",priority =1)
    public void Login() throws InterruptedException {

        login = new LoginPage(driver);
        login.loginWithValidEmailValidPassword();

        //verify Login successfully
        String text = driver.findElement(By.className("welcome_menu")).getText();
        Assert.assertEquals(text,"Welcome to Adactin Group of Hotels");
        Assert.assertNotEquals(text,"123");
        Assert.assertTrue(text.contains("Welcome to Adactin Group of Hotels"));
    }

    @Test(description = "TestCase2 Logout", priority = 2)
    public void Logout() throws InterruptedException {
        login.Logout();
        //verify Logout successfully
        String text1 = driver.findElement(By.className("reg_success")).getText();
        if (text1.contains("You have successfully logged out.")){
            System.out.println("Logout succesffully");
        }
        //Get Url in Console
        String url = driver.getCurrentUrl();
        System.out.println(url);

    }

    @AfterClass
    public void closePage(){
        //Close Selenium Driver
        driver.quit();
    }
}
