package automationpractice.Pages.AccountPages;

import automationpractice.Pages.MainPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AccountPage {
    private final SelenideElement returnToHome = $x("//a[@title='Return to Home']");

    public MainPage returnHome() {
        returnToHome.click();
        return new MainPage();
    }

}
