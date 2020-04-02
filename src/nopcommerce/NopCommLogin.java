package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import java.util.concurrent.TimeUnit;

public class NopCommLogin extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void openBrowser() {
        chromeDriver(); // chrome browser driver
        maximizeWindow();
        implicitWaitSeconds(10);
        openUrl(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToLoginPage() throws InterruptedException {
        clickOnElement(By.linkText("Log in")); // click on log in button
        sleepMethod();
        String expectedText = "Welcome, Please Sign In!";//  welcome text verification
        String actualText;
        actualText = getTextFromElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1"));
        Assert.assertEquals(expectedText, actualText);
        sendTextToElement(By.xpath("//input[@id='Email']"), "ravee.123@gmail.com");// send text to first name field
        sendTextToElement(By.id("Password"), "bac133"); // send text to password field
        clickOnElement(By.xpath("//input[@class='button-1 login-button']")); // click on log in button
    }

    @After
    public void closeBrowser() throws InterruptedException {
        sleepMethod();
        quitMethod();
    }
}
