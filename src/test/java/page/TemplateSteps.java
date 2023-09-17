package page;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;

import static data.Helper.cards;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static page.DashboardPage.cardsBalance;

public class TemplateSteps {
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static VerificationPage verificationPage;
    private int[] cardsBalance;

    @Пусть("oткрыта страница с формой авторизации {string}")
    public void OpenPageAuthorization(String url) {
        loginPage = Selenide.open(url, LoginPage.class);
    }

    @Когда("пользователь пытается авторизоваться с именем {string} и паролем {string}")
    public void authenticate(String login, String password) {
        verificationPage = loginPage.validLogin(login, password);
    }

    @И("пользователь вводит корректный проверочный код 'из смс' {string}")
    public void setValidCode(String verificationCode) {
        dashboardPage = verificationPage.validVerify(verificationCode);
    }
    @Тогда("происходит успешная авторизация и пользователь попадает на страницу 'Личный кабинет'")
    public void verifyDashboardPage() {
        dashboardPage.DashboardPage();
        cardsBalance = cardsBalance();
    }

    @And("когда пользователь переводит 5000 рублей с карты с номером {string} на свою 1 карту с главной страницы")
    public void translation(String card) {
        dashboardPage.moneyTransfer(card).transaction(Integer.toString(5000), cards[0]);
    }

    @Then("тогда баланс его карты из списка на главной странице должен стать 15000 рублей.")
    public void CardBalance() {
        int expectedFirst = cardsBalance[0] - 5000;
        int expectedSecond = cardsBalance[1] + 5000;
        cardsBalance = cardsBalance();

        assertEquals(expectedFirst, cardsBalance[0]);
        assertEquals(expectedSecond, cardsBalance[1]);
    }
}
