package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Project3Page;
import utils.DropdownHandler;
import utils.Waiter;

import java.util.List;

public class _03_ProjectTest extends Base{

    @BeforeMethod
    public void SetPage(){
        driver.get("https://techglobal-training.com/frontend/project-3");
        actions = new Actions(driver);
        project3Page = new Project3Page();
    }

    @Test(priority = 1, description = "TC01 - Validate the default Book your trip form")
    public void validateDefaultBookYourTripForm(){

        //Trip Type Labels Validation
        project3Page.tripTypeRadioButtonsLabel.forEach(lb -> {
            Assert.assertTrue(lb.isDisplayed());
        });

        String[] expectedText = {"One way", "Round trip"};
        for (int i = 0; i < expectedText.length; i++) {
            Assert.assertEquals(project3Page.tripTypeRadioButtonsLabel.get(i).getText(), expectedText[i]);
        }

        //Trip Type radio Buttons Validation
        for (WebElement webElement : project3Page.tripTypeRadioButtonsInput) {
            Assert.assertTrue(webElement.isDisplayed());
            Assert.assertTrue(webElement.isEnabled());
            Assert.assertTrue(project3Page.tripTypeRadioButtonsInput.get(0).isSelected());
            Assert.assertFalse(project3Page.tripTypeRadioButtonsInput.get(1).isSelected());
        }

        //Cabin Class Label and Dropdown displayed
        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());
        Assert.assertEquals(project3Page.cabinClassLabel.getText(), "Cabin Class");

        //From Label and Dropdown displayed
        Assert.assertTrue(project3Page.fromLabel.isDisplayed());
        Assert.assertTrue(project3Page.fromDropdown.isDisplayed());
        Assert.assertEquals(project3Page.fromLabel.getText(), "From");

        //To Label and Dropdown displayed
        Assert.assertTrue(project3Page.toLabel.isDisplayed());
        Assert.assertTrue(project3Page.toDropdown.isDisplayed());
        Assert.assertEquals(project3Page.toLabel.getText(), "To");

        //Depart Label and Date Picker displayed
        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departDatePicker.isDisplayed());
        Assert.assertEquals(project3Page.departLabel.getText(), "Depart");

        //Return Label and Date Picker displayed and Date Picker disabled
        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isDisplayed());
        Assert.assertEquals(project3Page.returnLabel.getText(), "Return");
        //Assert.assertFalse(returnDatePicker.isEnabled()); //does not work

        //Number of Passengers Label and dropdown displayed and 1 is default
        Assert.assertTrue(project3Page.numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.numberOfPassengersDropdown.isDisplayed());
        Assert.assertEquals(project3Page.numberOfPassengersLabel.getText(), "Number of passengers");
        Assert.assertEquals(project3Page.numbOfPassengersSelected.getAttribute("value"), "1");

        //Passenger 1 Label and dropdown displayed and 16-64 is default
        Assert.assertTrue(project3Page.passenger1Label.isDisplayed());
        Assert.assertTrue(project3Page.passenger1Dropdown.isDisplayed());
        Assert.assertEquals(project3Page.passenger1Label.getText(), "Passenger 1");
        Assert.assertEquals(project3Page.passenger1Selected.getText(), "Adult (16-64)");

        //Book button is displayed and enabled
        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());
        Assert.assertEquals(project3Page.bookButton.getText(), "BOOK");
    }

    @Test(priority = 2, description = "TC02 - Validate the Book your trip form when Round trip is selected")
    public void validateBookYourTripWithRoundTripSelected(){

        //Click on the “Round trip” radio button and validate it is selected

        //Validate that the “One way” radio button is not selected
        project3Page.tripTypeRadioButtonsInput.get(1).click();

        Assert.assertTrue(project3Page.tripTypeRadioButtonsInput.get(1).isSelected());
        Assert.assertFalse(project3Page.tripTypeRadioButtonsInput.get(0).isSelected());

        //Validate that the “Cabin Class” label and dropdown are displayed
        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());
        Assert.assertEquals(project3Page.cabinClassLabel.getText(), "Cabin Class");

        //Validate that the “From” label and dropdown are displayed
        Assert.assertTrue(project3Page.fromLabel.isDisplayed());
        Assert.assertTrue(project3Page.fromDropdown.isDisplayed());
        Assert.assertEquals(project3Page.fromLabel.getText(), "From");

        //Validate that the “To” label and dropdown are displayed
        Assert.assertTrue(project3Page.toLabel.isDisplayed());
        Assert.assertTrue(project3Page.toDropdown.isDisplayed());
        Assert.assertEquals(project3Page.toLabel.getText(), "To");

        //Validate that the “Depart” label and date picker is displayed
        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departDatePicker.isDisplayed());
        Assert.assertEquals(project3Page.departLabel.getText(), "Depart");

        //Validate that the “Return” label and date picker is displayed
        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isDisplayed());
        Assert.assertEquals(project3Page.returnLabel.getText(), "Return");

        //Validate that the “Number of passengers” label and dropdown are displayed and 1 is the default
        Assert.assertTrue(project3Page.numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.numberOfPassengersDropdown.isDisplayed());
        Assert.assertEquals(project3Page.numberOfPassengersLabel.getText(), "Number of passengers");
        Assert.assertEquals(project3Page.numberOfPassengersDropdown.getAttribute("value"), "1");

        //Validate that the “Passenger 1” label and dropdown are displayed and “Adult (16-64)” is the default
        Assert.assertTrue(project3Page.passenger1Label.isDisplayed());
        Assert.assertTrue(project3Page.passenger1Dropdown.isDisplayed());
        Assert.assertEquals(project3Page.passenger1Label.getText(), "Passenger 1");
        Assert.assertEquals(project3Page.passenger1Selected.getText(), "Adult (16-64)");

        //Validate that the “BOOK” button is displayed and enabled
        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());
        Assert.assertEquals(project3Page.bookButton.getText(), "BOOK");

    }

    @Test(priority = 3, description = "TC03 - Validate the booking for 1 passenger and one way")
    public void validateBookingFor1PassengerAndOneWay(){

        //Select the “One way” radio button
        project3Page.tripTypeRadioButtonsInput.get(0).click();

        //Select “Business” for the “Cabin Class” dropdown
        project3Page.cabinClassOptions.get(2).click();

        //Select “Illinois” for the “From” dropdown
        DropdownHandler.selectByVisibleText(project3Page.fromDropdown, "Illinois");

        //Select “Florida” for the “To” dropdown
        DropdownHandler.selectByVisibleText(project3Page.toDropdown, "Florida");

        //Select the next week for the ”Depart”
        //LocalDate currentDate = LocalDate.now();
        project3Page.departMonth.sendKeys("6");
        project3Page.departDay.sendKeys("17");
        project3Page.departYear.sendKeys("2023");

        project3Page.departYear.sendKeys(Keys.ESCAPE);

        //Select “1” for the “Number of passengers” dropdown
        DropdownHandler.selectByIndex(project3Page.numberOfPassengersDropdown, 0);

        //Select “Senior (65+)” for the Passenger 1 dropdown
        DropdownHandler.selectByIndex(project3Page.passenger1Dropdown, 1);

        //Click on the “BOOK” button
        project3Page.bookButton.click();

        /*Validate the booking information displayed below
        DEPART
        IL to FL
        {dynamic date}
        Number of passengers: 1
        Passenger 1: Senior (65+)
        Cabin Class: Business */

        Assert.assertEquals(project3Page.departValidation.getText(), "DEPART");
        Assert.assertEquals(project3Page.departFromToValidation.getText(), "IL to FL");
        Assert.assertEquals(project3Page.departDateValidation.getText(), "Sat Jun 17 2023");

        for (int i = 0; i < project3Page.expectedText.length; i++) {
            Assert.assertEquals(project3Page.passengerDetails.get(i).getText(), project3Page.expectedText[i]);//Bug-1 Class in Cabin Class should be upper case
        }
    }

    @Test(priority = 4, description = "TC04 - Validate the booking for 1 passenger and round trip")
    public void validateBookingFor1PassengerAndRoundTrip(){

        //Select the “Round trip” radio button
        project3Page.tripTypeRadioButtonsInput.get(1).click();

        //Select “First” for the “Cabin Class” dropdown
        project3Page.cabinClassOptions.get(3).click();

        //Select “California” for the “From” dropdown
        DropdownHandler.selectByVisibleText(project3Page.fromDropdown, "California");

        //Select “Illinois” for the “To” dropdown
        DropdownHandler.selectByVisibleText(project3Page.toDropdown, "Illinois");

        //Select the next week for the ”Depart”
        project3Page.departMonth.sendKeys("6");
        project3Page.departDay.sendKeys("17");
        project3Page.departYear.sendKeys("2023");
        project3Page.departYear.sendKeys(Keys.ESCAPE);

        //Select the next month for the “Return”
        project3Page.returnMonth.sendKeys("7");
        project3Page.returnDay.sendKeys("17");
        project3Page.returnYear.sendKeys("2023");
        project3Page.returnYear.sendKeys(Keys.ESCAPE);

        //Select “1” for the “Number of passengers” dropdown
        DropdownHandler.selectByIndex(project3Page.numberOfPassengersDropdown, 0);

        //Select “Adult (16-64)” for the Passenger 1 dropdown
        DropdownHandler.selectByIndex(project3Page.passenger1Dropdown, 0);

        //Click on the “BOOK” button
        project3Page.bookButton.click();

        /*Validate the booking information displayed below
DEPART
CA to IL
{dynamic date}
Number of passengers: 1
Passenger 1: Adult (16-64)
Cabin Class: First

RETURN
IL to CA
{dynamic date} */

        String[] expectedText = {"Number of Passengers: 1", "Passenger 1: Adult (16-64)", "Cabin Class: First"};

        //Depart
        Assert.assertEquals(project3Page.departValidation.getText(), "DEPART");
        Assert.assertEquals(project3Page.departFromToValidation.getText(), "CA to IL");
        Assert.assertEquals(project3Page.departDateValidation.getText(), "Sat Jun 17 2023");

        //Return
        Assert.assertEquals(project3Page.returnValidation.getText(), "RETURN");
        Assert.assertEquals(project3Page.returnFromToValidation.getText(), "IL to CA");
        Assert.assertEquals(project3Page.returnDateValidation.getText(), "Mon Jul 17 2023");

        //Passenger Details
        for (int i = 0; i < expectedText.length; i++) {
            Assert.assertEquals(project3Page.passengerDetails.get(i).getText(), expectedText[i]);//Bug-1 Class in Cabin Class should be upper case
        }
    }

    @Test(priority = 5, description = "TC05 - Validate the booking for 2 passengers and one way")
    public void validateBookingFor2PassengersAndOneWay(){

        //Select the “One way” radio button
        project3Page.tripTypeRadioButtonsInput.get(0).click();

        //Select “Premium Economy” for the “Cabin Class” dropdown
        project3Page.cabinClassOptions.get(1).click();

        //Select “New York” for the “From” dropdown
        DropdownHandler.selectByVisibleText(project3Page.fromDropdown, "New York");

        //Select “Texas” for the “To” dropdown
        DropdownHandler.selectByVisibleText(project3Page.toDropdown, "Texas");

        //Select the next day for the ”Depart”
        project3Page.departMonth.sendKeys("6");
        project3Page.departDay.sendKeys("15");
        project3Page.departYear.sendKeys("2023");
        project3Page.departYear.sendKeys(Keys.ESCAPE);

        //Select “2” for the “Number of passengers” dropdown
        DropdownHandler.selectByIndex(project3Page.numberOfPassengersDropdown, 1);

        //Select “Adult (16-64)” for the Passenger 1 dropdown
        DropdownHandler.selectByIndex(project3Page.passenger1Dropdown, 0);

        WebElement passenger2Dropdown = driver.findElement(By.cssSelector("div[class='field']:nth-child(9)>div>select"));

        //Select “Child (2-11)” for the Passenger 2 dropdown
        DropdownHandler.selectByIndex(passenger2Dropdown, 3);

        //Click on the “BOOK” button
        project3Page.bookButton.click();

        /*Validate the booking information displayed below
DEPART
NY to TX
{dynamic date}
Number of passengers: 2
Passenger 1: Adult (16-64)
Passenger 2: Child (2-11)
Cabin Class: Premium Economy */

        String[] expectedText = {"Number of passengers: 2", "Passenger 1: Adult (16-64)", "Passenger 2: Child (2-11)", "Cabin Class: Premium Economy"};

        Assert.assertEquals(project3Page.departValidation.getText(), "DEPART");
        Assert.assertEquals(project3Page.departFromToValidation.getText(), "NY to TX");
        Assert.assertEquals(project3Page.departDateValidation.getText(), "Thu Jun 15 2023");

        for (int i = 0; i < expectedText.length; i++) {
            Assert.assertEquals(project3Page.passengerDetails.get(i).getText(), expectedText[i]);//Bug-2 passengers in Number of passengers should be lowercase
        }
    }


}
