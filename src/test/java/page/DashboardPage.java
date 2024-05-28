package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.common.base.CharMatcher;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static data.Helper.cards;

public class DashboardPage {
    private final SelenideElement heading = $(".heading_size_xl");
    private static final ElementsCollection listItem = $$(".list__item");
    private final SelenideElement titlePage = $("#root > div > h2");

    public void dashboardPage() {
        heading.shouldBe(visible).shouldHave(exactText("Ваши карты"));
    }

    public void titlePage(String title) {
        titlePage.shouldBe(visible).shouldHave(exactText(title));
    }


    public TransferPage moneyTransfer(String number) {
        listItem.find(text(number.substring(15, 19))).$("button").click();
        return new TransferPage();
    }

    public static int[] cardsBalance() {
        int[] result = new int[2];
        String tmp1 = listItem.find(text(cards[0].substring(15, 19))).$("div").getText().substring(20);
        result[0] = Integer.parseInt(CharMatcher.inRange('0', '9').retainFrom(tmp1));
        String tmp2 = listItem.find(text(cards[1].substring(15, 19))).$("div").getText().substring(20);
        result[1] = Integer.parseInt(CharMatcher.inRange('0', '9').retainFrom(tmp2));
        return result;
    }
}