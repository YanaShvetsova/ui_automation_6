package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DropdownHandler;
import utils.Waiter;

import java.util.List;

public class _11_TGDropdownsTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-5")).click();
    }

    @Test
    public void productDropdownTest(){
        Select select = new Select(driver.findElement(By.id("product_dropdown")));
        select.selectByVisibleText("iPhone 14 Pro Max");
    }

    @Test
    public void productColorTest(){
        Select select = new Select(driver.findElement(By.id("color_dropdown")));
        select.selectByIndex(2);
    }

    @Test
    public void productDeliveryTest(){
        WebElement dropdown = driver.findElement(By.id("shipment_dropdown"));
        dropdown.click();

        Waiter.pause(2);
        WebElement dropdownOption = driver.findElement(By.cssSelector("#shipment_dropdown span:last-child"));
        dropdownOption.click();

        Waiter.pause(2);
    }
/**
Go to https://techglobal-training.com/frontend/
Click on the "Dropdown" card
Select the "MacBook Pro 13" option from the "Product" dropdown.
Select the "Green" option from the "Color" dropdown.
Open the "Shipping" dropdown and click on the "Delivery" option.
Click on the "Submit" button.
Validate result message displays "Your Green MacBook Pro 13 will be delivered to you."
 */
 @Test //this test is using DropdownHandler class
 public void dropdownsTest(){
     WebElement productDropdown = driver.findElement(By.id("product_dropdown"));
     DropdownHandler.selectByVisibleText(productDropdown, "MacBook Pro 13");

     WebElement colorDropdown = driver.findElement(By.id("color_dropdown"));
     DropdownHandler.selectByIndex(colorDropdown, 2);

     WebElement dropdown = driver.findElement(By.id("shipment_dropdown"));
     dropdown.click();

     WebElement dropdownOption = driver.findElement(By.cssSelector("#shipment_dropdown span:first-child"));
     dropdownOption.click();

     WebElement submitButton = driver.findElement(By.id("submit"));
     submitButton.click();

     WebElement result = driver.findElement(By.id("result"));
     Assert.assertTrue(result.isDisplayed());
     Assert.assertEquals(result.getText(), "Your Green MacBook Pro 13 will be delivered to you.");

 }



}