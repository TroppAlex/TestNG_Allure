package CSP;

import org.junit.jupiter.api.Assertions;
import pages.CSP.SupportPage;
import pages.CSP.ComputersPage;

@org.junit.jupiter.api.extension.ExtendWith(Base.TestListener.class)
public class CspTest extends Base.BaseTest {


    @org.junit.jupiter.api.Test
    @io.qameta.allure.Owner("Tropp")
    @io.qameta.allure.Description("Manual test 1111")
    public void checkMovieChain() {
        ComputersPage computersPage = new ComputersPage(driver);
        computersPage.getComputersPage()
                .clickAddComputer();
        String title = driver.findElement(org.openqa.selenium.By.xpath("//*[@id='main']/h1")).getText();
        Assertions.assertEquals(title, "Add a computer");
    }

    @org.junit.jupiter.api.Test
    @io.qameta.allure.Owner("Tropp")
    @io.qameta.allure.Description("Manual test 1112")
    public void login(){
        SupportPage supportPage = new SupportPage(driver);
        supportPage.getSupportPage().clickLogin();
        switchTo(1);
        supportPage.fillEmail()
                .clickNext()
                .fillPassword()
                .clickSignIn();
        switchTo(0);
        supportPage.checkTitle("RingCentral Support | Voice, Video, and Messaging Solutions")
                .checkLogIn();
        supportPage.openNewWindow("/services/platform/account/business-address.servlet");
        supportPage.checkCompanyFromServlet();
        closeWindow(driver, driver.getTitle());
    }

//        computersPage.clickAddComputer();
//        String title = driver.findElement(org.openqa.selenium.By.xpath("//*[@id='main']/h1")).getText();
//        Assertions.assertEquals( title, "Add a computer");

//        pages.MainSearchBarPage mainSearchBarPage = new pages.MainSearchBarPage(driver);
//        pages.SearchResultPage searchResultPage = mainSearchBarPage.openMainPage().openSearchPage()
//                .fillName("Batman")
//                .fillYear("2018")
//                .fillCountry()
//                .findFilm();
//        String year = searchResultPage.getFirstYear();
//        java.util.List<String> filmNames = searchResultPage.getFoundFilmNames();
//        int count = searchResultPage.getFoundFilmsCount();
//        filmNames.forEach(x-> System.out.println(x));
//
//        Assertions.assertTrue(filmNames.size()!=0);
//        Assertions.assertEquals("2018", year);
//        Assertions.assertEquals(12, count);


//    @org.junit.jupiter.api.Test
//    public void bigChain(){
//        new pages.MainSearchBarPage(driver).openMainPage()
//                .openSearchPage().fillName("Матрица").findFilm().showFilmNames()
//                .openSearchPage().fillName("Ёлки").findFilm().showFilmNames()
//                .openSearchPage().fillName("Наруто").findFilm().showFilmNames();
//
//    }
//
//    @org.junit.jupiter.api.Test
//    @io.qameta.allure.Owner("QA")
//    @io.qameta.allure.Description("Выполняется поиск фильма с заданными параметрами и проверяется что фильмы найдены")
//    public void checkMovie(){
//        pages.MainSearchBarPage mainSearchBarPage = new pages.MainSearchBarPage(driver);
//        mainSearchBarPage.openMainPage();
//        mainSearchBarPage.openSearchPage();
//
//        pages.AdvancedSearchPage advancedSearchPage = new pages.AdvancedSearchPage(driver);
//        advancedSearchPage.fillName("Spider man");
//        advancedSearchPage.fillYear("2019");
//        advancedSearchPage.findFilm();
////        driver.findElement(org.openqa.selenium.By.xpath("//input[contains(@class,'nice_button')]")).click();
//
//        pages.SearchResultPage searchResultPage = new pages.SearchResultPage(driver);
//        java.util.List<String> filmNames = searchResultPage.getFoundFilmNames();
//
//        filmNames.forEach(System.out::println);
//        org.junit.jupiter.api.Assertions.assertTrue(filmNames.size()!=0);
//    }
//
//    @org.junit.jupiter.api.Test
//    public void shortTest(){
//        org.junit.jupiter.api.Assertions.assertEquals("2018", new pages.MainSearchBarPage(driver).openMainPage()
//                .openSearchPage()
//                .fillName("Batman")
//                .fillYear("2018")
//                .fillCountry()
//                .findFilm()
//                .getFirstYear());
//
//    }
}
