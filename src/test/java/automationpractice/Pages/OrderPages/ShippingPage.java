package automationpractice.Pages.OrderPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ShippingPage {
    private final SelenideElement termsOfService = $x("//input[@id='cgv']");
    private final SelenideElement checkoutShipping = $x("//button[@class='button btn btn-default standard-checkout button-medium']");


    public PaymentPage checkShipping() {
        termsOfService.click();
        checkoutShipping.click();
        return new PaymentPage();
    }
}
