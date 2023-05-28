package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Driver;
import utils.Waiter;

public class _08_TGWaitsTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-4")).click();
    }

    /**
     * TEST CASE 1
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Waits" card
     * Click on the "Click on me to see a red box" button
     * Validate that a red box is displayed
     */

    @Test
    public void waitForRedBox(){
        WebElement redBoxButton = driver.findElement(By.cssSelector("button[id='red']"));

        redBoxButton.click();

        WebElement redBoxShown = driver.findElement(By.cssSelector("button[class*='Box']"));
        Assert.assertTrue(redBoxShown.isDisplayed());
    }

    /**
     * TEST CASE 2
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Waits" card
     * Click on the "Click on me to see a blue box" button
     * Validate that a blue box is displayed
     */

    @Test
    public void waitForBlueBox(){
        WebElement blueBoxButton = driver.findElement(By.id("blue"));
        blueBoxButton.click();

        WebElement blueBox = driver.findElement(By.cssSelector("button[class*='blue_box']"));

        Waiter.waitForVisibilityOfElement(blueBox, 40);

        Assert.assertTrue(blueBox.isDisplayed());
    }
}
