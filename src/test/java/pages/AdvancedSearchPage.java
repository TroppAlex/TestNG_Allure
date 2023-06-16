package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearchPage extends pages.MainSearchBarPage {
    @FindBy(id = "find_film")
    private WebElement filmNameInput;

    @FindBy(id="year")
    private WebElement filmYearInput;

    @FindBy(id="country")
    private WebElement filmCountyList;

    @FindBy(xpath = "//select[@id='country']//option[@value='1']")
    private WebElement usaCountryOption;

//    @FindBy(xpath = "//form[@id='formSearchMain']//input[@value='поиск']")
    @FindBy(xpath = "//input[contains(@class,'nice_button')]")
    private WebElement mainSearchButton;

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public AdvancedSearchPage fillName(String str){
        filmNameInput.sendKeys(str);
        return this;
    }

    public AdvancedSearchPage fillYear(String str){
        filmYearInput.sendKeys(str);
        return this;
    }

    public AdvancedSearchPage fillCountry(){
        filmCountyList.click();
        usaCountryOption.click();
        return this;
    }

    public AdvancedSearchPage fillCountry2(){
        filmCountyList.click();
        filmCountyList.findElements(By.xpath("./option[@value='1']"));
        return this;
    }


    public pages.SearchResultPage findFilm(){
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",mainSearchButton);
        return new pages.SearchResultPage(driver);
    }



}
