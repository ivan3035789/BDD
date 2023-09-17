package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.common.base.CharMatcher;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static data.Helper.cards;

public class DashboardPage {
    private static final SelenideElement heading = $(".heading_size_xl");
    private static final ElementsCollection listItem = $$(".list__item");


    public void DashboardPage() {
        heading.shouldBe(visible, Duration.ofSeconds(15)).shouldHave(exactText("Ваши карты"));
    }

    public TransferPage moneyTransfer(String number) {
        listItem.find(text(number.substring(15, 19))).$("button").click();
        return new TransferPage();
    }

    public static int[] cardsBalance() {
        int[] result = new int[2];
        String tmp1 = listItem.find(text(cards[0].substring(15, 19))).$("div").getOwnText().substring(20);
        result[0] = Integer.parseInt(CharMatcher.inRange('0', '9').retainFrom(tmp1));
        String tmp2 = listItem.find(text(cards[1].substring(15, 19))).$("div").getOwnText().substring(20);
        result[1] = Integer.parseInt(CharMatcher.inRange('0', '9').retainFrom(tmp2));
        return result;
    }
}