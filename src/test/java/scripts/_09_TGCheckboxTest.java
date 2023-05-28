package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.IntStream;

public class _09_TGCheckboxTest extends Base{

    /**
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Checkboxes" card
     * Validate "Apple" and "Microsoft" checkboxes are displayed, enabled, and not selected
     * Select both and validate they are both selected
     * Deselect both and validate they are deselected
     */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-7")).click();
    }

    @Test
    public void checkboxTest(){
        List<WebElement> checkboxLabel = driver.findElements(By.cssSelector("#checkbox-button-group_1 label"));
        List<WebElement> checkboxInput = driver.findElements(By.cssSelector("#checkbox-button-group_1 input"));

        checkboxInput.forEach(cb -> {
            Assert.assertTrue(cb.isDisplayed());
            Assert.assertFalse(cb.isSelected());
            Assert.assertTrue(cb.isEnabled());
        });

        for (int i = 0; i < checkboxLabel.size(); i++) {
            checkboxLabel.get(i).click();
            Assert.assertTrue(checkboxInput.get(i).isSelected());
        }

//        for (int i = 0; i < checkboxLabel.size(); i++) {
//            checkboxLabel.get(i).click();
//            Assert.assertFalse(checkboxInput.get(i).isSelected());
//        }

        IntStream.range(0, checkboxLabel.size()).forEach(i -> {
            checkboxLabel.get(i).click();
            Assert.assertFalse(checkboxInput.get(i).isSelected());
        });
    }

    /**
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Checkboxes" card
     * Validate "Tesla" and "SpaceX" checkboxes are displayed, enabled, and not selected
     * Select both and validate they are both selected
     * Deselect both and validate they are deselected
     */

    @Test
    public void checkboxTest2(){
        List<WebElement> checkboxLabel = driver.findElements(By.cssSelector("#checkbox-button-group_2 label"));
        List<WebElement> checkboxInput = driver.findElements(By.cssSelector("#checkbox-button-group_2 input"));

        checkboxInput.forEach(cb -> {
            Assert.assertTrue(cb.isDisplayed());
            Assert.assertFalse(cb.isSelected());
            Assert.assertTrue(cb.isDisplayed());
        });

        for (int i = 0; i <checkboxLabel.size(); i++) {
            checkboxLabel.get(i).click();
            Assert.assertTrue(checkboxInput.get(i).isSelected());
        }

        for (int i = 0; i <checkboxLabel.size(); i++) {
            checkboxLabel.get(i).click();
            Assert.assertFalse(checkboxInput.get(i).isSelected());
        }
    }
}
