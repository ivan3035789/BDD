package stepPictures;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;

public class AfterStep {

    @After
    public void setUp() {
        WebDriverRunner.getWebDriver().close();
    }

    @io.cucumber.java.AfterStep
    public void screenshot() {
        Selenide.screenshot(System.currentTimeMillis() + "step");
    }
}
