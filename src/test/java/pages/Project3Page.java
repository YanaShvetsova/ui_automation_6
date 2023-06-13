package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class Project3Page {
    public Project3Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".radio")
    public List<WebElement> tripTypeRadioButtonsLabel;

    @FindBy(css = ".mr-1")
    public List<WebElement> tripTypeRadioButtonsInput;

    @FindBy(css = "div[class='field']:nth-child(2)>label")
    public WebElement cabinClassLabel;

    @FindBy(css = "div[class='field']:nth-child(2)>div>select>option")
    public WebElement cabinClassDropdown;

    @FindBy(css = "div[class='field']:nth-child(2)>div>select>option")
    public List<WebElement> cabinClassOptions;

    @FindBy(css = "div[class='field']:nth-child(3)>label")
    public WebElement fromLabel;

    @FindBy(css = "div[class='field']:nth-child(3)>div>select")
    public WebElement fromDropdown;

    @FindBy(css = "div[class='field']:nth-child(4)>label")
    public WebElement toLabel;

    @FindBy(css = "div[class='field']:nth-child(4)>div>select")
    public WebElement toDropdown;

    @FindBy(css = "div[class='field']:nth-child(5)>label")
    public WebElement departLabel;

    @FindBy(css = "div[class='field']:nth-child(5)>div")
    public WebElement departDatePicker;

    @FindBy(css = "div[class='field']:nth-child(6)>label")
    public WebElement returnLabel;

    @FindBy(css = "div[class='field']:nth-child(6)>div")
    public WebElement returnDatePicker;

    @FindBy(css = "div[class='field']:nth-child(7)>label")
    public WebElement numberOfPassengersLabel;

    @FindBy(css = "div[class='field']:nth-child(7)>div>select")
    public WebElement numberOfPassengersDropdown;

    @FindBy(css = "div[class='field']:nth-child(7)>div>select>option")
    public WebElement numbOfPassengersSelected;

    @FindBy(css = "div[class='field']:nth-child(8)>label")
    public WebElement passenger1Label;

    @FindBy(css = "div[class='field']:nth-child(8)>div>select")
    public WebElement passenger1Dropdown;

    @FindBy(css = "div[class='field']:nth-child(8)>div>select>option")
    public WebElement passenger1Selected;

    @FindBy(css = "button[type='submit']")
    public WebElement bookButton;

    @FindBy(xpath = "(//input[@name='month'])[1]")
    public WebElement departMonth;

    @FindBy(xpath = "(//input[@name='day'])[1]")
    public WebElement departDay;

    @FindBy(xpath = "(//input[@name='year'])[1]")
    public WebElement departYear;

    @FindBy(xpath = "(//input[@name='month'])[2]")
    public WebElement returnMonth;

    @FindBy(xpath = "(//input[@name='day'])[2]")
    public WebElement returnDay;

    @FindBy(xpath = "(//input[@name='year'])[2]")
    public WebElement returnYear;

    @FindBy(css = ".is-underlined")
    public WebElement departValidation;

    @FindBy(css = ".is-italic")
    public WebElement departFromToValidation;

    @FindBy(css = "div.ml-3>div.field.is-flex>div>p")
    public WebElement departDateValidation;

    @FindBy(xpath = "(//h1[@class='is-underlined'])[2]")
    public WebElement returnValidation;

    @FindBy(xpath = "(//h3[@class='is-italic'])[2]")
    public WebElement returnFromToValidation;

    @FindBy(css = "div.ml-3>div.field.is-flex>div:nth-child(2)>div>p")
    public WebElement returnDateValidation;

    @FindBy(css = "div:nth-child(2)>p")
    public List<WebElement> passengerDetails;


    public String[] expectedText = {"Number of Passengers: 1", "Passenger 1: Senior (65+)", "Cabin Class: Business"};









}
