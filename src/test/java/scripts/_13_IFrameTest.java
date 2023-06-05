package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _13_IFrameTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/iframes");
    }

    /*
    TEST CASE
    Go to https://techglobal-training.com/frontend/iframes
    Validate the "Please fill out your information below" paragraph
     */

    @Test(priority = 1, description = "TC123: Validate the IFrame Page content paragraph")
    public void validateTheParagraph(){
        //WebElement iframe = driver.findElement(By.id("form_frame"));
        //driver.switchTo().frame(iframe);

        //driver.switchTo().frame(0);

        driver.switchTo().frame("form_frame");

        WebElement paragraph = driver.findElement(By.cssSelector("#name_form>p"));
        Assert.assertTrue(paragraph.isDisplayed());
        Assert.assertEquals(paragraph.getText(), "Please fill out your information below");
    }
    /*
    TEST CASE
    Go to https://techglobal-training.com/frontend/iframes
    Enter name as "John"
    Enter last name as "Doe"
    Click on "SUBMIT" button
    Validate that the Result is "You entered: John Doe"
     */
    @Test(priority = 2, description = "TC345 Validate the form submission")
    public void validateTheFormSubmission(){
        driver.switchTo().frame("form_frame");
        WebElement name = driver.findElement(By.id("first_name"));
        WebElement lastName = driver.findElement(By.id("last_name"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        name.sendKeys("John");
        lastName.sendKeys("Doe");
        submitButton.submit();

        //driver.switchTo().parentFrame(); //parentFrame
        driver.switchTo().defaultContent(); //main HTML frame
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(result.getText(), "You entered: John Doe");


    }

}
