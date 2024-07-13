package myTestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public void loginWithValidEmailValidPassword(WebDriver driver) throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("naeemtester");
        driver.findElement(By.name("password")).sendKeys("naeemtester");
        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);
    }

    public void Logout(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.linkText("Logout")).click();
    }

}