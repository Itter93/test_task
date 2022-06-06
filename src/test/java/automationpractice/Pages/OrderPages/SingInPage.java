package automationpractice.Pages.OrderPages;

import automationpractice.Pages.AccountPages.AccountPage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SingInPage {
    private final String login = "Itternadya@gmail.com";
    private final String pass = "Itter1007";

    private final SelenideElement email = $x("//input[@id='email']");
    private final SelenideElement password = $x("//input[@id='passwd']");
    private final SelenideElement singIn = $x("//button[@id='SubmitLogin']");

    public AddressPage singInToAddess() {
        email.setValue(login);
        password.setValue(pass);
        singIn.click();
        return new AddressPage();

    }

    public AccountPage singInToAccount() {
        email.setValue(login);
        password.setValue(pass);
        singIn.click();
        return new AccountPage();

    }
}
