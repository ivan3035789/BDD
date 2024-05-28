package page;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.*;

import static data.Helper.cards;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static page.DashboardPage.cardsBalance;

public class TemplateSteps {
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static VerificationPage verificationPage;
    private int[] cardsBalance;

    @Given("oткрыта страница с формой авторизации {string}")
    public void OpenPageAuthorizationEN(String url) {
        System.setProperty("webdriver.chrome.driver", "chromedriver2-win64/chromedriver.exe");
        loginPage = Selenide.open(url, LoginPage.class);
    }

    @When("пользователь пытается авторизоваться с именем {string} и паролем {string}")
    public void authenticateEN(String login, String password) {
        verificationPage = loginPage.validLogin(login, password);
    }

    @And("пользователь вводит корректный проверочный код из смс {string}")
    public void setValidCodeEN(String verificationCode) {
        dashboardPage = verificationPage.validVerify(verificationCode);
    }

    @Then("происходит успешная авторизация и пользователь попадает на страницу {string}")
    public void pageNameEN(String title) {
        dashboardPage.dashboardPage();
        dashboardPage.titlePage(title);
    }

    @Допустим("пользователь переходит на страницу с формой авторизации {string}")
    public void OpenPageAuthorizationRU(String url) {
        System.setProperty("webdriver.chrome.driver", "chromedriver2-win64/chromedriver.exe");
        loginPage = Selenide.open(url, LoginPage.class);
    }

    @И("появляется страница {string} для ввода логина и пароля от личного кабинета")
    public void pageNameRU(String title) {
        loginPage.titlePage(title);
    }

    @Если("пользователь вводит имя {string} и пароль {string}")
    public void authenticateRU(String login, String password) {
        verificationPage = loginPage.validLogin(login, password);
    }

    @И("пользователь вводит корректный проверочный код 'из смс' {string}")
    public void setValidCode(String verificationCode) {
        dashboardPage = verificationPage.validVerify(verificationCode);
    }

    @То("пользователь попадает на страницу {string} для ввода кода из смс")
    public void personalAccountRU(String title) {
        verificationPage.verifyTitle(title);
    }

    @Если("пользователь вводит некорректное имя {string} и пароль {string}")
    public void invalidAuthenticate(String login, String password) {
        loginPage.invalidValidLogin(login, password);
    }

    @То("на странице появляется сообщение, {string}")
    public void messageErr(String messageErr) {
        loginPage.message(messageErr);
    }

    @And("когда пользователь переводит 5000 рублей с карты с номером {string} на карту 5559 0000 0000 0002")
    public void translation(String card0001) {
        dashboardPage.moneyTransfer(cards[1]).transaction(Integer.toString(5000), card0001);
    }

    @Then("тогда баланс карты 5559 0000 0000 0002 {int} рублей на 5559 0000 0000 0001 {int} рублей")
    public void CardBalance(int card0002, int card0001) {
//        int expectedFirst = cardsBalance[0] - 5000;
//        int expectedSecond = cardsBalance[1] + 5000;
        cardsBalance = cardsBalance();

        assertEquals(card0002, cardsBalance[1]);
        assertEquals(card0001, cardsBalance[0]);
    }
}
