package scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.AlertHandler;

public class _12_TGAlertsTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-8")).click();
    }
    /**
     * WARNING ALERT
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Alerts" card
     * Click on the "Warning alert" button
     * Validate the alert text equals "You are on TechGlobal Training application."
     * Click on the "OK" button on the alert
     * Validate the result message equals "You accepted warning by clicking OK."
     */
    @Test //With using AlertHandler
    public void warningAlert(){
        WebElement warningAlert = driver.findElement(By.id("warning_alert"));
        warningAlert.click();

        Assert.assertEquals(AlertHandler.getAlertText(), "You are on TechGlobal Training application.");

        AlertHandler.acceptAlert();

        WebElement resultText = driver.findElement(By.id("action"));
        Assert.assertEquals(resultText.getText(), "You accepted warning by clicking OK.");
    }
    /**
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Alerts" card
     * Click on the "Confirmation alert" button
     * Validate the alert text equals "Would you like to stay on TechGlobal Training application?"
     * Click on the "Cancel" button on the alert
     * Validate the result message equals "You rejected the alert by clicking Cancel."
     * Click on the "Confirmation alert" button again
     * Click on the "OK" button on the alert
     * Validate the result message equals "You confirmed the alert by clicking OK."
     */
    @Test
    public void validateConfirmationAlert(){
        WebElement confirmationAlert = driver.findElement(By.id("confirmation_alert"));
        confirmationAlert.click();
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "Would you like to stay on TechGlobal Training application?");
        alert.dismiss();

        WebElement resultText = driver.findElement(By.id("action"));
        Assert.assertEquals(resultText.getText(), "You rejected the alert by clicking Cancel.");

        confirmationAlert.click();
        alert.accept();
        Assert.assertEquals(resultText.getText(), "You confirmed the alert by clicking OK.");
    }
    /**
     * PROMPT ALERT
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Alerts" card
     * Click on the "Prompt alert" button
     * Validate the alert text equals "What would you like to say to TechGlobal?"
     * Click on the "Cancel" button on the alert
     * Validate the result message equals "You rejected the alert by clicking Cancel."
     * Click on the "Prompt alert" button again
     * Click on the "OK" button on the alert
     * Validate the result message equals "You entered "" in the alert and clicked OK."
     * Click on the "Prompt alert" button again
     * Enter "Hello" to alert the input box
     * Click on the "OK" button on the alert
     * Validate the result message equals "You entered "Hello" in the alert and clicked OK."
     */
    @Test
    public void validatePromptAlert(){
        WebElement promptAlert = driver.findElement(By.id("prompt_alert"));
        promptAlert.click();

        Assert.assertEquals(AlertHandler.getAlertText(), "What would you like to say to TechGlobal?");

        AlertHandler.dismissAlert();

        WebElement resultText = driver.findElement(By.id("action"));
        Assert.assertEquals(resultText.getText(), "You rejected the alert by clicking Cancel.");

        promptAlert.click();
        AlertHandler.sendKeys("Hello");
        AlertHandler.acceptAlert();
        Assert.assertEquals(resultText.getText(), "You entered \"Hello\" in the alert and clicked OK.");
    }


}
