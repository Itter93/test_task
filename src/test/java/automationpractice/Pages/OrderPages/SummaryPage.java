package automationpractice.Pages.OrderPages;

import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$x;

public class SummaryPage {
    private String[] prices;

    public SummaryPage(String[] prices) {
        this.prices = prices;
    }

    private final SelenideElement priceOne = $x("(//tbody//td[@class='cart_total']//span[@class='price'])[1]");
    private final SelenideElement priceTwo = $x("(//tbody//td[@class='cart_total']//span[@class='price'])[2]");
    private final SelenideElement checkoutSummary = $x("//a[@class='button btn btn-default standard-checkout button-medium']");

    private boolean countBought() {
        String[] pricesOnSummary = {
                priceOne.getText(),
                priceTwo.getText()
        };

        return Arrays.equals(prices, pricesOnSummary);
    }

    public SingInPage bought() {
        if (countBought()) {
            checkoutSummary.click();
        }
        return new SingInPage();
    }

}
