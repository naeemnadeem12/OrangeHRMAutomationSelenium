package myTestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By username = new By.ByName("username");
    By password = new By.ByName("password");
    By loginclick = new By.ByName("login");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void loginWithValidEmailValidPassword() throws InterruptedException {
        driver.findElement(username).sendKeys("naeemtester");
        driver.findElement(password).sendKeys("naeemtester");
        driver.findElement(loginclick).click();
        Thread.sleep(2000);
    }

    public void Logout() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.linkText("Logout")).click();
    }

}
