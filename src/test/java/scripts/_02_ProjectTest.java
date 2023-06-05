package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class _02_ProjectTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-2");
    }

    @Test (priority = 1, description = "TC01 - Validate the login form")
    public void validateLoginForm(){
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement usernameLabel = driver.findElement(By.cssSelector("label[for='username']"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement passwordLabel = driver.findElement(By.cssSelector("label[for='password']"));
        WebElement loginButton= driver.findElement(By.id("login_btn"));
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));

        Assert.assertTrue(usernameInput.isDisplayed());
        Assert.assertEquals(usernameInput.getAttribute("required"), null);
        Assert.assertEquals(usernameLabel.getText(), "Please enter your username");

        Assert.assertTrue(passwordInput.isDisplayed());
        Assert.assertEquals(passwordInput.getAttribute("required"), null);
        Assert.assertEquals(passwordLabel.getText(), "Please enter your password");

        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertEquals(loginButton.getText(), "LOGIN");

        Assert.assertTrue(forgotPasswordLink.isDisplayed());
        Assert.assertTrue(forgotPasswordLink.isEnabled());
        Assert.assertEquals(forgotPasswordLink.getText(), "Forgot Password?");
    }

    @Test (priority = 2, description = "TC02- Validate the valid login")
    public void validateTheValidLogin(){
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton= driver.findElement(By.id("login_btn"));


        usernameInput.sendKeys("TechGlobal");
        passwordInput.sendKeys("Test1234");
        loginButton.click();

        WebElement successMessage = driver.findElement(By.id("success_lgn"));
        WebElement logoutButton = driver.findElement(By.id("logout"));

        Assert.assertEquals(successMessage.getText(), "You are logged in");
        Assert.assertTrue(logoutButton.isDisplayed());
        Assert.assertEquals(logoutButton.getText(), "LOGOUT");
    }

    @Test (priority = 3, description = "TC03 - Validate the logout")
    public void validateLogout() {
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));


        usernameInput.sendKeys("TechGlobal");
        passwordInput.sendKeys("Test1234");
        loginButton.click();

        WebElement logoutButton = driver.findElement(By.id("logout"));

        logoutButton.click();

        //if check again input boxes I get StaleElementReferenceException, so I am using labels to validate login form
        WebElement usernameLabel = driver.findElement(By.cssSelector("label[for='username']"));
        WebElement passwordLabel = driver.findElement(By.cssSelector("label[for='password']"));


        Assert.assertTrue(usernameLabel.isDisplayed());
        Assert.assertTrue(passwordLabel.isDisplayed());
    }
        @Test (priority = 4, description = "TC04 - Validate the Forgot Password? Link and Reset Password modal")
        public void validateForgotPassword(){
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));

        forgotPasswordLink.click();
            WebElement resetPasswordTitle = driver.findElement(By.id("modal_title"));
            WebElement resetPasswordHeader = driver.findElement(By.id("sub_heading"));
            WebElement closeButton = driver.findElement(By.cssSelector(".delete"));
            WebElement emailInputBox = driver.findElement(By.id("email"));
            WebElement emailLabel = driver.findElement(By.cssSelector("label[for='email']"));
            WebElement submitButton = driver.findElement(By.id("submit"));

            Assert.assertTrue(resetPasswordTitle.isDisplayed());
            Assert.assertTrue(resetPasswordHeader.isDisplayed());
            Assert.assertTrue(closeButton.isDisplayed());
            Assert.assertTrue(emailInputBox.isDisplayed());
            Assert.assertTrue(emailLabel.isDisplayed());
            Assert.assertEquals(emailLabel.getText(), "Enter your email address and we'll send you a link to reset your password.");

            Assert.assertTrue(submitButton.isDisplayed());
            Assert.assertTrue(submitButton.isEnabled());
            Assert.assertEquals(submitButton.getText(), "SUBMIT");

    }

    @Test (priority = 5, description = "TC05 - Validate the Reset Password modal close button")
    public void validateResetModalCloseButton(){
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));

        forgotPasswordLink.click();
        WebElement resetPasswordTitle = driver.findElement(By.id("modal_title"));
        WebElement closeButton = driver.findElement(By.cssSelector(".delete"));

        Assert.assertTrue(resetPasswordTitle.isDisplayed());
        closeButton.click();
        //don't know how to validate module is closed
    }

    @Test (priority = 6, description = "TC06 - Validate the Reset Password form submission")
    public void validateResetPasswordFormSubmission(){
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        forgotPasswordLink.click();

        WebElement emailInputBox = driver.findElement(By.id("email"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        emailInputBox.sendKeys("hello@gmail.com");
        submitButton.click();

        WebElement resetPasswordMessage = driver.findElement(By.id("confirmation_message"));

        Assert.assertEquals(resetPasswordMessage.getText(), "A link to reset your password has been sent to your email address.");

    }

    @Test (priority = 7, description = "TC07 - Validate the invalid login with the empty credentials")
    public void validateInvalidLoginWithEmptyCredentials(){
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        loginButton.click();

        WebElement failureMessage = driver.findElement(By.id("error_message"));

        Assert.assertTrue(failureMessage.isDisplayed());
        Assert.assertEquals(failureMessage.getText(), "Invalid Username entered!");
    }

    @Test (priority = 8, description = "TC08 - Validate the invalid login with the wrong username")
    public void validateInvalidLoginWithWrongUsername(){
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        usernameInput.sendKeys("John");
        passwordInput.sendKeys("Test1234");
        loginButton.click();

        WebElement failureMessage = driver.findElement(By.id("error_message"));

        Assert.assertTrue(failureMessage.isDisplayed());
        Assert.assertEquals(failureMessage.getText(), "Invalid Username entered!");
    }

    @Test (priority = 9, description = "TC09 - Validate the invalid login with the wrong password")
    public void validateInvalidLoginWithWrongPassword(){
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));


        usernameInput.sendKeys("TechGlobal");
        passwordInput.sendKeys("1234");
        loginButton.click();

        WebElement failureMessage = driver.findElement(By.id("error_message"));

        Assert.assertTrue(failureMessage.isDisplayed());
        Assert.assertEquals(failureMessage.getText(), "Invalid Password entered!");

    }

    @Test (priority = 10, description = "TC10 - Validate the invalid login with the wrong username and password")
    public void validateInvalidLoginWithWrongUsernameAndPassword(){
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));


        usernameInput.sendKeys("John");
        passwordInput.sendKeys("1234");
        loginButton.click();

        WebElement failureMessage = driver.findElement(By.id("error_message"));

        Assert.assertTrue(failureMessage.isDisplayed());
        Assert.assertEquals(failureMessage.getText(), "Invalid Username entered!");

    }




}
