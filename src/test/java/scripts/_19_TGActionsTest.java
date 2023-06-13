package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

import java.time.Duration;

public class _19_TGActionsTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-15")).click();
        actions = new Actions(driver);
    }

    /**
     * TEST CASE 1
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the user is redirected to the Actions page
     * Verify that the first three web elements are present and labeled as "Click on me", "Right-Click on me", and "Double-Click on me"
     * Perform a click action on the first web element labeled "Click on me"
     * Verify that a message appears next to the element stating, "You clicked on a button!"
     * Perform a right-click action on the second web element labeled "Right-Click on me"
     * Verify that the message appears next to the element stating, "You right-clicked on a button!"
     * Perform a double-click action on the third web element labeled "Double-Click on me"
     * Verify that the message appears next to the element stating, "You double-clicked on a button!"
     */

    @Test
    public void mouseActions(){
        WebElement clickOnMeButton = driver.findElement(By.id("click"));
        WebElement rightClickButton = driver.findElement(By.id("right-click"));
        WebElement doubleClickButton = driver.findElement(By.id("double-click"));

        actions.moveToElement(clickOnMeButton).click().perform();
        actions.moveToElement(rightClickButton).contextClick().perform();
        actions.moveToElement(doubleClickButton).doubleClick().perform();

        WebElement clickResult = driver.findElement(By.id("click_result"));
        WebElement rightClickResult = driver.findElement(By.id("right_click_result"));
        WebElement doubleClickResult = driver.findElement(By.id("double_click_result"));


        Assert.assertEquals(clickResult.getText(), "You clicked on a button!");
        Assert.assertEquals(rightClickResult.getText(), "You right-clicked on a button!");
        Assert.assertEquals(doubleClickResult.getText(), "You double-clicked on a button!");

        Waiter.pause(3);
    }

    /**
     * TEST CASE 2
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here", -- skip here
     * Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
     * Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
     * Verify that a message appears next to the  web element stating, "An element dropped here!"
     */

    @Test
    public void dragAndDrop(){
        WebElement dragElementButton = driver.findElement(By.id("drag_element"));
        WebElement dropElementButton = driver.findElement(By.id("drop_element"));

//        actions.dragAndDrop(dragElementButton, dropElementButton).perform();

        actions.moveToElement(dragElementButton).clickAndHold().moveToElement(dropElementButton).release().perform();

        WebElement dragAndDropResult = driver.findElement(By.id("drag_and_drop_result"));
        Waiter.waitForVisibilityOfElement(dragAndDropResult, 30);
        Assert.assertEquals(dragAndDropResult.getText(), "An element dropped here!");
        Waiter.pause(3);

    }

    /**
     * TEST CASE 3
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Go to the input box
     * First, enter “h” to the input box in upper case using keyboard actions
     * Then complete the word by sending “ello” as a key
     * Validate value attribute of the input box is “Hello”
     */
    @Test
    public void keyboardActions(){

        WebElement inputBox = driver.findElement(By.id("input_box"));

        actions.keyDown(Keys.SHIFT)
                .sendKeys(inputBox, "h")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(2))
                .sendKeys("ello")
                .pause(Duration.ofSeconds(2))
                .perform();

        Assert.assertEquals(inputBox.getAttribute("value"), "Hello");
    }
    /**
     * TEST CASE 4
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Go to the input box
     * Enter “techglobal” to input the box with uppercases
     * Then, copy the text and paste it again
     * Validate the value attribute for the search input box is “TECHGLOBALTECHGLOBAL”
     */

    @Test
    public void moreKeyboardActions(){
        WebElement inputBox = driver.findElement(By.id("input_box"));

        actions.keyDown(Keys.SHIFT)
                .sendKeys(inputBox, "techglobal")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.CONTROL)
                .sendKeys("acvv")
                .pause(Duration.ofSeconds(2))
                .perform();

        Assert.assertEquals(inputBox.getAttribute("value"), "TECHGLOBALTECHGLOBAL");

    }
}
