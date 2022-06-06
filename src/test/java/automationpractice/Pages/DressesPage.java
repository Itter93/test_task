package automationpractice.Pages;

import automationpractice.Pages.OrderPages.SummaryPage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DressesPage {
    private String dressOne = "(//div[@class='product-container'])[1]";
    private String dressTwo = "(//div[@class='product-container'])[2]";

    private final SelenideElement oneDress = $x(dressOne);
    private final SelenideElement oneDressAddToCart = $x(dressOne + "//a[@title='Add to cart']");
    private final SelenideElement oneDressPrice = $x(dressOne + "//span[@class='price product-price']");

    private final SelenideElement twoDress = $x(dressTwo);
    private final SelenideElement twoDressAddToCart = $x(dressTwo + "//a[@title='Add to cart']");
    private final SelenideElement twoDressPrice = $x(dressTwo + "//span[@class='price product-price']");

    private final SelenideElement continueShop = $x("//span[@class='continue btn btn-default button exclusive-medium']");
    private final SelenideElement proceedToCheckout = $x("//a[@class='btn btn-default button button-medium']");


    public SummaryPage addToCart() {
        oneDress.hover();
        String priceOne = oneDressPrice.getText();
        oneDressAddToCart.click();
        continueShop.click();

        twoDress.hover();
        String priceTwo = twoDressPrice.getText();
        twoDressAddToCart.click();
        proceedToCheckout.click();

        String[] prices = {priceOne, priceTwo};

        return new SummaryPage(prices);

    }

}
