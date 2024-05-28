package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginField = $("[data-test-id=login] input");
    private final SelenideElement passwordField = $("[data-test-id=password] input");
    private final SelenideElement loginButton = $("[data-test-id=action-login]");
    private final SelenideElement loginPage = $("#root > div > h2");
    private final SelenideElement messageErr = $("#root > div > div > div > div.notification__content");

    public void titlePage(String title) {
        loginPage.shouldBe(visible).shouldHave(exactText(title));
    }

    public void message(String errorMessage) {
        messageErr.shouldBe(visible).shouldHave(exactText(errorMessage));
    }

    public VerificationPage validLogin(String login, String password) {
        loginField.setValue(login);
        passwordField.setValue(password);
        loginButton.click();
        return new VerificationPage();
    }

    public void invalidValidLogin(String login, String password) {
        loginField.setValue(login);
        passwordField.setValue(password);
        loginButton.click();
    }
}
