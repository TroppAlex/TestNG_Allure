package pages.CSP;

public class ComputersPage {
    org.openqa.selenium.WebDriver driver;
    public ComputersPage(org.openqa.selenium.WebDriver driver){
        this.driver = driver;
    }
    private org.openqa.selenium.By addComputerButton = org.openqa.selenium.By.xpath("//*[@id='actions']/form/a");
    private org.openqa.selenium.By fieldComputerSearch = org.openqa.selenium.By.xpath("//div[@id='actions']//input[@id='searchbox']");
    private org.openqa.selenium.By computerSearchButton = org.openqa.selenium.By.xpath("//div[@id='actions']//input[@id='searchsubmit']");

    String url = "http://computer-database.gatling.io/computers";

    public ComputersPage getComputersPage() {
        driver.navigate().to(url);
        return this;
    }

    public ComputersPage clickAddComputer() {
        driver.findElement(addComputerButton).click();
        return this;
    }

    public void setComputerName(String computerName) {
        driver.findElement(fieldComputerSearch).sendKeys(computerName);
    }

    public void clickComputerSearch() {
        driver.findElement(computerSearchButton).click();
    }
}
