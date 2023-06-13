package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class GoogleSearchPage {

    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);  //constructor
    }

    @FindBy(name = "q")               //locating elements
    public WebElement searchBar;


    public void search(String text){
        searchBar.sendKeys(text + Keys.ENTER);      //useful method
    }
}
