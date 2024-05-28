package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class VerificationPage {
    private final SelenideElement codeField = $("[data-test-id=code] input");
    private final SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private final SelenideElement verifyTitle = $("#root > div > p");

    public void verifyTitle(String title) {
        verifyTitle.shouldBe(visible).shouldHave(exactText(title));
    }

    public DashboardPage validVerify(String code) {
        codeField.setValue(code);
        verifyButton.click();
        return new DashboardPage();
    }
}