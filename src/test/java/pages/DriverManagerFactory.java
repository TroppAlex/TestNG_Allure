package pages;

public class DriverManagerFactory {

    public static DriverManager getDriverManager (DriverType type) {
        DriverManager driverManager = null;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aleksey.tropp\\Automation\\webdriver\\chromedriver.exe");

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
/*            default:
                driverManager = new IEDriverManager();
                break;*/
        }
        return driverManager;
    }
}
