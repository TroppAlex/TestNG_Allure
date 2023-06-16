package pages.CSP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.jupiter.api.Assertions;
import org.json.JSONObject;
import java.util.HashMap;
import java.lang.String;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class SupportPage extends Base.BasePage {
    org.openqa.selenium.WebDriver driver;
    public SupportPage(org.openqa.selenium.WebDriver driver){
        this.driver = driver;
        org.openqa.selenium.support.PageFactory.initElements(driver,this);
    }

//    private By buttonLogin = By.xpath("//*[@class='global-header-v2__nav-desktop']//*[@class='login__wrapper']");
    private By buttonNext = By.xpath("//*[@data-test-automation-id='loginCredentialNext']");
    private By buttonSignIn = By.xpath("//*[@data-test-automation-id='signInBtn']");
//    private By inputEmail = By.xpath("//*[@data-test-automation-id='input']");
//    private By inputPassword = By.xpath("//*[@data-test-automation-id='password']//*[@data-test-automation-id='input']");

    @FindBy(xpath = "//*[@class='global-header-v2__nav-desktop']//*[@class='login__wrapper']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//*[@data-test-automation-id='input']")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@data-test-automation-id='password']//*[@data-test-automation-id='input']")
    private WebElement inputPassword;

    @FindBy(xpath = "//body")
    private WebElement jsonPlan;

    @FindBy(xpath = "//*[@class='case-dashboard__user-name']")
    private WebElement myOwerviewName;

    private By computerSearchButton = By.xpath("//div[@id='actions']//input[@id='searchsubmit']");

    WebElement webElement;
    String baseUrl = "https://support.ringcentral.com";
    String url = baseUrl + "/ca/en/";

    public SupportPage getSupportPage() {
        driver.navigate().to(url);
        io.qameta.allure.Allure.getLifecycle().addAttachment("screenshot", "image/png", "png", ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.BYTES));
        return this;
    }

    public SupportPage clickLogin() {
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        waitVisibilityOfElement(buttonLogin,5);
        buttonLogin.click();
        return this;
    }

    public SupportPage fillEmail() {
        waitVisibilityOfElement(inputEmail,3);
        inputEmail.sendKeys("andrey.gnasevych@ringcentral.com");
        return this;
    }

    public SupportPage clickNext() {
        driver.findElement(buttonNext).click();
        return this;
    }

    public SupportPage clickSignIn() {
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(buttonSignIn).click();
        return this;
    }

    public SupportPage fillPassword() {
        waitVisibilityOfElement(inputPassword,3);
        inputPassword.sendKeys("San1Juan$");
        return this;
    }

    public SupportPage checkTitle(String pageTitle) {
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        waitVisibilityOfElement(myOwerviewName,3);
        String title = driver.getTitle();
        Assertions.assertEquals(pageTitle, title);
        return this;
    }

    public SupportPage checkLogIn() {
        saveScreenshot("1");
        driver.manage().timeouts().implicitlyWait(3, java.util.concurrent.TimeUnit.SECONDS);
        String text = buttonLogin.getText();
        Assertions.assertEquals("Sign out", text);
        return this;
    }

    public void openNewWindow(String newUrl) {
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
        driver.navigate( ).to(baseUrl + newUrl);
    }

    public HashMap<String, String> getBusinessAddressFromServlet() {
        JSONObject serviceServlet = new JSONObject(jsonPlan.getText());
//        HashMap<String, Object> yourHashMap = new com.google.gson.Gson().fromJson(jsonPlan.getText(), HashMap.class);
        JSONObject planService = serviceServlet.getJSONObject("content").getJSONObject("businessAddress");
        HashMap<String, String> businessAddress = new HashMap<String, String>();
        for (String key:planService.keySet()) {
            businessAddress.put(key,planService.get(key).toString());
        }
        return businessAddress;
    }

    public String getCompanyFromServlet() {
        JSONObject serviceServlet = new JSONObject(jsonPlan.getText());
        return serviceServlet.getJSONObject("content").getString("company");
    }

    public void checkCompanyFromServlet() {
        Assertions.assertEquals(getCompanyFromServlet(), "RingCentral");
    }

    @io.qameta.allure.Attachment(value = "{0}")
    public byte[] saveScreenshot(String screenShot) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    //((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES) , type = “image/png”
//    public void setComputerName(String computerName) {
//        driver.findElement(fieldComputerSearch).sendKeys(computerName);
//    }
//
//    public void clickComputerSearch() {
//        driver.findElement(computerSearchButton).click();
//    }
}
