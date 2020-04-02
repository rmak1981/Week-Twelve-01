package utility;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class Utility {

    public WebDriver driver;
    private JavascriptExecutor jse;


    // this method will click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();

        // this method will send text on element
    }
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    //this method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    // this method is for mouse hover (move to element)

    public void moveToElement(By by) {
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(by));
        act.perform();
    }
    // this method is select by visible text
    public void selectByvisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    // this method is for select by value
    public void selectByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }
    // this method is for select by index
    public void selectByIndex(By by, int x) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(x);
    }
    // this mehtod is implicit wait in seconds
    public void implicitWaitSeconds(int y) {
        driver.manage().timeouts().implicitlyWait(y, TimeUnit.SECONDS);
    }
    // this method is thread sleep 2 seconds wait
    public void sleepMethod () throws InterruptedException {
        Thread.sleep(2000);
    }
    // this method is quit method
    public void quitMethod (){
        driver.quit();
    }
    public void closeMethod(){
        driver.close();
    }
    public void chromeDriver (){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    public void maximizeWindow (){
        driver.manage().window().maximize();
    }
    public void openUrl(String a){
        driver.get(a);
    }
    public void javaScriptExecuter (int x,int y){
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollBy(0,500);");
    }
    public void selectDropDown (By by,String text){
        WebElement productDropDown = driver.findElement(by);
    }

    // radio button selection methods
    public void radioButtonIsEnabled (By by){
        driver.findElement(by).isEnabled();
    }
    public void radioButtonIsDisplayed (By by){
        driver.findElement(by).isDisplayed();
    }
    public void radioButtonIsSelected (By by){
        driver.findElement(by).isSelected();
    }
    public void radioButtonClick(By by){
        driver.findElement(by).click();
    }

    // check box selection methods

    public  void checkBoxClick (By by){
        driver.findElement(by).click();
    }
    public void checkBoxIsSelected (By by){
        driver.findElement(by).isSelected();
    }
    public void checkBoxIsDisplayed (By by){
        driver.findElement(by).isDisplayed();
    }
    public void checkBoxIsEnabled (By by){
        driver.findElement(by).isEnabled();
    }

    //random method to generate email

    public void generateRandomEmail(By by){

        Random random = new Random();
        char c = (char) (random.nextInt(26) + 'a');
        String strEmail =  c + "ravee123@gmail.com";

        WebElement emailField = driver.findElement(by);
        emailField.sendKeys(strEmail);
    }
    // compare list of array
    public boolean compareList(String strSortingLink, String strSortText, String strBookList) {

        List<String> booksNames = new ArrayList<>();

        Select select = new Select(By.id(strSortingLink).findElement(driver));
        select.selectByVisibleText(strSortText);
        List<WebElement> booksList = driver.findElements(By.xpath(strBookList));

        for (WebElement ele : booksList) {
            booksNames.add(ele.getText());
        }
        List<String> tempList = new ArrayList<>();
        tempList.addAll(booksNames);
        Collections.sort(tempList);

        return booksNames.equals(tempList);
    }
    public void setPriceLowToHigh (By by) {
        List<WebElement> elements = driver.findElements(By.className("prices"));
        // "elements" is a WebElement so sout will print all the Html text from console from the webpage
        // System.out.println(elements);

        List<String> webSortedPrices = elements.stream().map(WebElement::getText).collect(toList());
        System.out.println("Expected result: " + webSortedPrices);

        List<String> mySortedPrices = new ArrayList<>();
        for (WebElement element : elements) {
            String text = element.getText();
            mySortedPrices.add(text);

            System.out.println("Actual result: " + mySortedPrices);

            //mySortedPrices.sort(Comparator.comparingInt(s -> Integer.valueOf(s)));
            Assert.assertEquals(webSortedPrices, mySortedPrices);

        }

    }
    }
