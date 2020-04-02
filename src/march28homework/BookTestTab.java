package march28homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookTestTab extends Utility {
    String baseurl = "https://demo.nopcommerce.com/";
    @Before
    public void openBrowser() {
        chromeDriver();
        maximizeWindow();
        implicitWaitSeconds(10);
        openUrl(baseurl);
    }
    //    Click on the books Page
    //    Navigate to books page successfully
    //    verify the Text Books
    @Test
    public void verifyUserShouldNavigateToBooksPage() throws InterruptedException {
        sleepMethod();
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));
        clickOnElement(By.xpath("//div[@class='page-title']//h1[contains(text(),'Books')]"));
    }
    //    Books Page (sort by)
    //    Select position (A-Z)
    //    arrange the books list in ascending order and verify
    @Test
    public void shortyByAToZ() throws InterruptedException {
        sleepMethod();
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        getTextFromElement(By.xpath("//select[@id='products-orderby']//option[contains(text(),'Name: A to Z')]"));

//this list method I do not know how to create so I have copied form our students -
// apart form everything else is working fine

        ArrayList<String> obtainedList = new ArrayList<>();  // creating the array list for obtain the elements from webpage
        List<WebElement> elementList =driver.findElements(By.tagName("h2"));// finding the elements by tag
        for (WebElement Links :elementList){
            obtainedList.add(Links.getText());
        }
        System.out.println("Obtained Product List :" + obtainedList);
        ArrayList<String> sortedList = new ArrayList<>();
        sortedList.addAll(obtainedList);
        Collections.sort(sortedList);
        Assert.assertTrue(obtainedList.equals(sortedList));
        System.out.println("Sorted Product List :" + sortedList);
    }
    //    Add book Fahrenheit 451 by Ray Bradbury to the wish list
    //    And verify the message "The product has been added to your wish list
    @Test
    public void wistList() throws InterruptedException {

        sleepMethod();
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        getTextFromElement(By.xpath("//select[@id='products-orderby']//option[contains(text(),'Name: A to Z')]"));
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]"));
        String expectedResult = "The product has been added to your wishlist";
        String actualResult = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedResult, actualResult);

    }
    @After
    public void browserClosing() {
        quitMethod();
        //driver.close();
    }

}
