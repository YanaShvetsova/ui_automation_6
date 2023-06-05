package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _15_TGFileUpload extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-13")).click();
    }

    /**
     *Go to https://techglobal-training.com/frontend/
     * Click on the "File Upload" card
     * Send the path of the file as keys to the "Choose File" input box
     * Click on the "UPLOAD" button
     * Validate the result message equals "You Uploaded 'hello.txt'"
     */
    @Test
    public void validateFileUpload(){
        WebElement fileUploadInput = driver.findElement(By.id("file_upload"));
        WebElement submitButton = driver.findElement(By.id("file_submit"));

        String filePath = "C:/Users/jane6/IdeaProjects/ui_automation_6/hello.txt";

        fileUploadInput.sendKeys(filePath);
        submitButton.click();

        WebElement resultMessage = driver.findElement(By.id("result"));
        Assert.assertEquals(resultMessage.getText(), "You Uploaded '" + filePath.substring(filePath.lastIndexOf('/') +1) + "'");
        Waiter.pause(3);
    }
}
