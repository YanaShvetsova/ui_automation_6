package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.Waiter;

import java.util.List;

public class _01_ProjectTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-1");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the heading is “Contact Us”
     * Validate the address is “2860 S River Rd Suite 350, Des Plaines IL 60018”
     * Validate the email is “info@techglobalschool.com"
     * Validate the phone number is “(773) 257-3010”
     */
    @Test (priority = 1)
    public void validateHeading(){
        WebElement heading = driver.findElement(By.cssSelector(".is-size-2"));
        WebElement address = driver.findElement(By.id("address"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement phoneNumber = driver.findElement(By.id("phone-number"));


        Assert.assertTrue(heading.isDisplayed());
        Assert.assertEquals(heading.getText(), "Contact Us");
        Assert.assertTrue(address.isDisplayed());
        Assert.assertEquals(address.getText(), "2860 S River Rd Suite 350, Des Plaines IL 60018");
        Assert.assertTrue(email.isDisplayed());
        Assert.assertEquals(email.getText(), "info@techglobalschool.com");
        Assert.assertTrue(phoneNumber.isDisplayed());
        Assert.assertEquals(phoneNumber.getText(), "(773) 257-3010");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Full name input box is displayed
     * Validate that the Full name input box is required
     * Validate that the label of the Full name input box is “Full name”
     * Validate that the placeholder of the Full name input box is “Enter your name”
     */
    @Test (priority = 2)
    public void validateFullNameInputBox(){
        WebElement fullNameInputBox = driver.findElement(By.xpath("(//input[@class='input'])[1]"));
        WebElement labelFullName = driver.findElement(By.xpath("//label[@for='name']"));
        WebElement fullNamePlaceholder = driver.findElement(By.xpath("//input[@placeholder='Enter your full name']"));

        Assert.assertTrue(fullNameInputBox.isDisplayed());
        boolean isRequired = fullNameInputBox.getAttribute("required") != null;
        Assert.assertTrue(isRequired);
        Assert.assertTrue(labelFullName.isDisplayed());
        Assert.assertEquals(labelFullName.getText(), "Full name");  //Bug-1
        Assert.assertTrue(fullNamePlaceholder.isDisplayed());
        Assert.assertEquals(fullNamePlaceholder.getAttribute("placeholder"), "Enter your name");  //Bug-2
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the label is “Gender”
     * Validate that the Gender is required
     * Validate the options are “Female”, “Male” and “Prefer not to disclose”
     * Validate the options are clickable and not selected
     * Click on the “Male” option and validate it is selected while the others are not selected
     * Click on the “Female” option and validate it is selected while the others are not selected
     */
    @Test (priority = 3)
    public void validateGenderRadioButton() {
        WebElement labelGender = driver.findElement(By.xpath("(//label[@class='label'])[2]"));
        WebElement radioButtonMale = driver.findElement(By.cssSelector("input[type='radio']"));
        List<WebElement> buttonsExist = driver.findElements(By.cssSelector(".radio"));
        List<WebElement> buttonsSelected = driver.findElements(By.cssSelector("input[name='question']"));

        Assert.assertTrue(labelGender.isDisplayed());
        Assert.assertEquals(labelGender.getText(),"Gender"); //Bug-3
        boolean isRequired = radioButtonMale.getAttribute("required") != null;
        Assert.assertTrue(isRequired);
        String[] expectedText = {"Female", "Male", "Prefer not to disclose"};   //Bug-4

        //checking if the radio buttons displayed, text, enabled --- LABEL   and if its not selected --->INPUT
        for (int i = 0; i < expectedText.length; i++) {
            Assert.assertTrue(buttonsExist.get(i).isDisplayed());
            Assert.assertEquals(buttonsExist.get(i).getText(), expectedText[i]);
            Assert.assertTrue(buttonsExist.get(i).isEnabled());
            Assert.assertFalse(buttonsSelected.get(i).isSelected());
        }

        //click Male  and check if its selected using INPUT
        buttonsSelected.get(1).click();
        Assert.assertTrue(buttonsSelected.get(1).isSelected());

        //while others unselected
        for (int i = 0; i < expectedText.length; i++) {
            if (i == 1) continue;
            Assert.assertFalse(buttonsSelected.get(i).isSelected());
        }
        //click Female and check if its selected using INPUT
        buttonsSelected.get(0).click();
        Assert.assertTrue(buttonsSelected.get(0).isSelected());

        //while others unselected
        for (int i = 0; i < expectedText.length; i++) {
            if (i == 0) continue;
            Assert.assertFalse(buttonsSelected.get(i).isSelected());
        }
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Address input box is displayed
     * Validate that the Address input box is not required
     * Validate that the label of the Address input box is “Address”
     * Validate that the placeholder of the Address input box is “Enter your address*”
     */
    @Test (priority = 4)
    public void validateAddressInputBox(){
    WebElement addressInputBox = driver.findElement(By.xpath("(//input[@class='input'])[2]"));
    WebElement labelAddress = driver.findElement(By.xpath("(//label[@class='label'])[3]"));
    WebElement addressPlaceholder = driver.findElement(By.xpath("//input[@placeholder='Enter your address']"));

    Assert.assertTrue(addressInputBox.isDisplayed());
    boolean isRequired = addressPlaceholder.getAttribute("required") != null;
    Assert.assertFalse(isRequired);
    Assert.assertEquals(labelAddress.getText(), "Address");
    Assert.assertEquals(addressPlaceholder.getAttribute("placeholder"), "Enter your address*");   //Bug-5
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Email input box is displayed
     * Validate that the Email input box is required
     * Validate that the label of the Email input box is “Email”
     * Validate that the placeholder of the Email input box is “Enter your email”
     */
    @Test (priority = 5)
    public void validateEmailInputBox() {
        WebElement emailInputBox = driver.findElement(By.xpath("(//input[@class='input'])[3]"));
        WebElement labelEmail = driver.findElement(By.xpath("(//label[@class='label'])[4]"));
        WebElement emailPlaceholder = driver.findElement(By.xpath("//input[@placeholder='Enter your email']"));

        Assert.assertTrue(emailInputBox.isDisplayed());
        boolean isRequired = emailPlaceholder.getAttribute("required") != null;
        Assert.assertTrue(isRequired);
        Assert.assertEquals(labelEmail.getText(), "Email");  //Bug-6
        Assert.assertEquals(emailPlaceholder.getAttribute("placeholder"), "Enter your email");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Phone input box is displayed
     * Validate that the Phone input box is not required
     * Validate that the label of the Phone input box is “Phone”
     * Validate that the placeholder of the Address input box is “Enter your phone number”
     */
    @Test (priority = 6)
    public void validatePhoneInputBox(){
        WebElement phoneInputBox = driver.findElement(By.xpath("(//input[@class='input'])[4]"));
        WebElement labelPhone = driver.findElement(By.xpath("(//label[@class='label'])[5]"));
        WebElement phonePlaceholder = driver.findElement(By.xpath("//input[@placeholder='Enter your phone number']"));

        Assert.assertTrue(phoneInputBox.isDisplayed());
        boolean isRequired = phonePlaceholder.getAttribute("required") != null;
        Assert.assertFalse(isRequired);
        Assert.assertEquals(labelPhone.getText(), "Phone");
        Assert.assertEquals(phonePlaceholder.getAttribute("placeholder"), "Enter your phone number");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Message text area is displayed
     * Validate that the Message text area is not required
     * Validate that the label of the Message text area is “Message”
     * Validate that the placeholder of the Message text area is “Type your message here…”
     */
    @Test (priority = 7)
    public void validateMessageTextArea(){
        WebElement messageTextArea = driver.findElement(By.cssSelector("textarea[class='textarea']"));
        WebElement labelMessage = driver.findElement(By.xpath("(//label[@class='label'])[6]"));
        WebElement messagePlaceholder = driver.findElement(By.xpath("//textarea[@placeholder='Type your message here...']"));

        Assert.assertTrue(messageTextArea.isDisplayed());
        boolean isRequired = messagePlaceholder.getAttribute("required") != null;
        Assert.assertFalse(isRequired);
        Assert.assertEquals(labelMessage.getText(), "Message");
        Assert.assertEquals(messagePlaceholder.getAttribute("placeholder"), "Type your message here..."); //different dots?
    }
    /**
     *Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the label is “I give my consent to be contacted.”
     * Validate that the Consent checkbox is required
     * Validate that the Consent checkbox is clickable
     * Click on the “I give my consent to be contacted.” checkbox and validate it is selected
     * Click on the “I give my consent to be contacted.” checkbox again and validate it is not selected
     */
    @Test (priority = 8)
    public void validateConsentCheckbox(){
        WebElement labelConsentCheckbox = driver.findElement(By.cssSelector("label[class='checkbox']"));
        WebElement consentCheckbox = driver.findElement(By.cssSelector("input[type='checkbox']"));

        Assert.assertEquals(labelConsentCheckbox.getText(), "I give my consent to be contacted.");
        boolean isRequired = consentCheckbox.getAttribute("required") != null;
        Assert.assertTrue(isRequired);
        Assert.assertTrue(consentCheckbox.isEnabled());
        consentCheckbox.click();
        Assert.assertTrue(consentCheckbox.isSelected());
        consentCheckbox.click();
        Assert.assertFalse(consentCheckbox.isSelected());
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the “SUBMIT” button is displayed
     * Validate the “SUBMIT” button is clickable
     * Validate that the button text is “SUBMIT”
     */
    @Test (priority = 9)
    public void validateSubmitButton(){
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
        Assert.assertEquals(submitButton.getText(), "SUBMIT");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Enter a first name
     * Select a gender
     * Enter an address
     * Enter an email
     * Enter a phone number
     * Enter a message
     * Select the “I give my consent to be contacted.” checkbox
     * Click on the “SUBMIT” button
     * Validate the form message “Thanks for submitting!” is displayed under the “SUBMIT” button
     */
    @Test (priority = 10)
    public void validateFormSubmission(){
        WebElement fullNameInputBox = driver.findElement(By.xpath("(//input[@class='input'])[1]"));
        WebElement femaleRadioButton = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement addressInputBox = driver.findElement(By.xpath("(//input[@class='input'])[2]"));
        WebElement emailInputBox = driver.findElement(By.xpath("(//input[@class='input'])[3]"));
        WebElement phoneInputBox = driver.findElement(By.xpath("(//input[@class='input'])[4]"));
        WebElement messageTextArea = driver.findElement(By.cssSelector("textarea[class='textarea']"));
        WebElement consentCheckbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        WebElement submitButton = driver.findElement(By.id("button[type='submit']"));

        fullNameInputBox.sendKeys("Yana");
        femaleRadioButton.click();
        addressInputBox.sendKeys("Chicago Il 60601");
        emailInputBox.sendKeys("yana@gmail.com");
        phoneInputBox.sendKeys("123-32-4021");
        messageTextArea.sendKeys("Hello TechGlobal!");
        consentCheckbox.click();
        submitButton.click();
        //Waiter.pause(2);
        WebElement submissionMessage = driver.findElement(By.cssSelector("strong[class='mt-5']"));
        Assert.assertEquals(submissionMessage.getText(), "Thanks for submitting!");
    }











}
