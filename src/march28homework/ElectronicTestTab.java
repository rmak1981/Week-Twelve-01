package march28homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;


public class ElectronicTestTab extends Utility {

    private String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        chromeDriver();
        maximizeWindow();
        implicitWaitSeconds(10);
        openUrl(baseUrl);
    }
    // user mouse hover in electronics - click on camera and photo and check camera and photo page is open
    @Test
    public void UserShouldNavigateToElectronicsPage() throws InterruptedException {

        moveToElement(By.linkText("Electronics"));
       //lickOnElement(By.linkText("Camera & photo"));
        sleepMethod();

        String expectedTxt = "Camera & photo";
        String actualTxt = getTextFromElement(By.linkText("Camera & photo"));
        Assert.assertEquals(expectedTxt, actualTxt);
    }

    // first mouse hover to electronics - click on camera and photo - then select sort price low to high and verify -

    // this second test is not passing as there are some issue with price low to high method line 59
    @Test
    public void sortPriceLowToHigh() throws InterruptedException {
        moveToElement(By.linkText("Electronics"));
        sleepMethod();
        moveToElement(By.linkText("Camera & photo"));
        sleepMethod();
        clickOnElement(By.linkText("Camera & photo"));

        //WebElement Position drop down menu
        // I dont know how to make this method so I left this as it is - i am trying to work on this

        WebElement sortByDropDownMenu = driver.findElement(By.id("products-orderby"));
        Select select = new Select(sortByDropDownMenu);
        select.selectByIndex(3);
        Thread.sleep(2000);

//      I have tried to create this method in utility but having some error

        setPriceLowToHigh(By.className("prices"));
        sleepMethod();

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}

