package march28homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import utility.Utility;

public class ComputerTestTab extends Utility {

    private String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        chromeDriver();
        maximizeWindow();
        implicitWaitSeconds(10);
        openUrl(baseUrl);
    }

    // User should navigate to Computers page & Assert text "Computers"

    @Test
    public void UserShouldNavigateToComputerPage() {
        clickOnElement(By.linkText("Computers"));
        String actualTxt;
        actualTxt = getTextFromElement(By.xpath("//div[@class='page-title']/h1 "));
        String expectedTxt = "Computers";
        Assert.assertEquals(actualTxt, expectedTxt);
    }
    /*
    TEST - User should navigate to Computers page, select Build your own computer,
    select 400gb HDD option radio button, select Add to cart & Assert message "The product has been added to your shopping cart"
     */
    @Test
    public void addProductToShoppingCart() throws InterruptedException {
        clickOnElement(By.linkText("Computers"));
        //element for desktop
        clickOnElement(By.xpath("//li[@class='inactive']//a[@href='/desktops']"));
        sleepMethod();
        //to scrool the page down
        //element for build your own computer
        clickOnElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-2 div.page.category-page div.page-body div.product-grid div.item-grid div.item-box:nth-child(1) div.product-item div.details h2.product-title > a:nth-child(1)"));
        sleepMethod();
        //element for 400gb hdd hard drive radio button
        radioButtonClick(By.id("product_attribute_3_7"));
        //element for add to cart button
        clickOnElement(By.id("add-to-cart-button-1"));
        //element for message for add to cart
        String actualMsg;
        String expectedMsg = "The product has been added to your shopping cart";
        actualMsg = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(actualMsg, expectedMsg);
    }
    @After
    public void closeBrowser() throws InterruptedException {
        sleepMethod();
        quitMethod();
}

}

