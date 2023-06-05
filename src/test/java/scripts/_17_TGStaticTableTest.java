package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TableHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _17_TGStaticTableTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-11")).click();
    }

    /**
     * Verify the headers of the table
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Static Tables" card
     * Check that the headers of the table are "Rank", "Company", "Employees", and "Country"
     * Verify the rows of the table
     */
    @Test
    public void validateTableHeaders() {
        List<WebElement> tableHeaders = driver.findElements(By.cssSelector(".header")); // if by className "header"
        String[] expectedTexts = {"Rank", "Company", "Employees", "Country"};

        for (int i = 0; i <= tableHeaders.size()-1; i++) {          //or < tableHeaders.size()
            Assert.assertTrue(tableHeaders.get(i).isDisplayed());
            Assert.assertEquals(tableHeaders.get(i).getText(), expectedTexts[i]);

        }
    }
    /**
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Static Tables" card
     * Check that the first row of the table has the values "1", "Amazon", "1,523,000", and "USA"
     * Verify the columns of the table
     */
    @Test
    public void validateFirstRow() {
        List<WebElement> tableFirstRow = driver.findElements(By.cssSelector("tbody tr:nth-child(1) td")); //or "tr:first-child td"
        String[] expectedTexts = {"1", "Amazon", "1,523,000", "USA"};

        for (int i = 0; i <= tableFirstRow.size()-1; i++) {          //or < tableHeaders.size()
            Assert.assertTrue(tableFirstRow.get(i).isDisplayed());
            Assert.assertEquals(tableFirstRow.get(i).getText(), expectedTexts[i]);
        }
    }
    /**
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Static Tables" card
     * Check that the "Country" column of the table has the values "USA", "China", "USA", "USA", "S. Korea"
     * Verify the entire table
     */
    @Test
    public void validateLastColumn(){
        //List<WebElement> tableLastColumn = driver.findElements(By.cssSelector("tbody td:nth-child(4)")); // OR  "td:last-child" OR td:nth-child(4)"
        List<WebElement> tableLastColumn = TableHandler.getTableColumn(4); //this one is using TableHandler method
        String[] expectedTexts = {"USA", "China", "USA", "USA", "S. Korea"};

        for (int i = 0; i <= tableLastColumn.size()-1; i++) {
            Assert.assertTrue(tableLastColumn.get(i).isDisplayed());
            Assert.assertEquals(tableLastColumn.get(i).getText(), expectedTexts[i]);
        }
    }
    @Test
    public void validateEachCell() {
        WebElement mainTable = driver.findElement(By.id("company_table"));
        List<List<WebElement>> tableData = TableHandler.getTableData(mainTable);

        // Just to debug purposes, we dont need this
//        for(List<WebElement> row: tableData){
//            for(WebElement cell : row){
//                System.out.println(cell.getText());
//            }
//        }

        List<List<String>> table = new ArrayList<>();
        table.add(Arrays.asList("1", "Amazon", "1,523,000", "USA"));
        table.add(Arrays.asList("2", "Alibaba", "245,700", "China"));
        table.add(Arrays.asList("3", "Microsoft", "221,000", "USA"));
        table.add(Arrays.asList("4", "Apple", "154,000", "USA"));
        table.add(Arrays.asList("5", "Samsung", "116,915", "S. Korea"));

        Assert.assertEquals(tableData.get(2).get(1).getText(), table.get(2).get(1));

        for (int i = 0; i < tableData.size(); i++) {
            for (int j = 0; j < tableData.get(i).size(); j++) {
                Assert.assertEquals(tableData.get(i).get(j).getText(), table.get(i).get(j));
            }
        }
    }

}
