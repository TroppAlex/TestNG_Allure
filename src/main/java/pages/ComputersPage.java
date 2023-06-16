//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class ComputersPage {
//    WebDriver driver;
//    public ComputersPage(WebDriver driver){
//        this.driver = driver;
//    }
//    private By addComputerButton = By.xpath("//*[@id='actions']/form/a");
//    private By fieldComputerSearch = By.xpath("//div[@id='actions']//input[@id='searchbox']");
//    private By computerSearchButton = By.xpath("//div[@id='actions']//input[@id='searchsubmit']");
//
//    String url = "http://computer-database.gatling.io/computers";
//
//    public void getComputersPage() {
//        driver.navigate( ).to(url);
//    }
//
//    public void clickAddComputer() {
//        driver.findElement(addComputerButton).click();
//    }
//
//    public void setComputerName(String computerName) {
//        driver.findElement(fieldComputerSearch).sendKeys(computerName);
//    }
//
//    public void clickComputerSearch() {
//        driver.findElement(computerSearchButton).click();
//    }
//}
