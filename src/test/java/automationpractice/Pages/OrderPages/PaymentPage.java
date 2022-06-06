package automationpractice.Pages.OrderPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PaymentPage {
    private String reference;
    private final SelenideElement bankWire = $x("//a[@class='bankwire']");
    private final SelenideElement confirmOrder = $x("//button[@class='button btn btn-default button-medium']");
    private final SelenideElement orderComplete = $x("//p[@class=\"cheque-indent\"]//strong");


    public String checkPayment() {
        bankWire.click();
        confirmOrder.click();
        return orderComplete.getText();
    }

}
