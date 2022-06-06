package automationpractice.Pages.OrderPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AddressPage {

    private final SelenideElement checkoutAddress = $x("//button[@class='button btn btn-default button-medium']");


    public ShippingPage clickAddress() {
        checkoutAddress.click();
        return new ShippingPage();
    }
}
