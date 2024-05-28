package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class TransferPage {

    private final SelenideElement heading = $(" .heading heading_size_xl heading_theme_alfa-on-white");
    private final SelenideElement totField = $(".money-input .input__control");
    private final SelenideElement sourceCardField = $("[data-test-id='from'] .input__control");
    private final SelenideElement addFundsButton = $("[data-test-id='action-transfer'] .button__text");

    public void transferPage() {
        heading.shouldBe(visible).shouldHave(exactText("Пополнение карты"));
    }

    public void transaction(String value, String source) {
        totField.doubleClick().append(value);
        sourceCardField.doubleClick().append(source);
        addFundsButton.click();

    }
}
