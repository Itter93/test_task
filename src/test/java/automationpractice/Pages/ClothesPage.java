package automationpractice.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ClothesPage {
    private final SelenideElement size = $x("//select[@class='form-control attribute_select no-print']//option[@title='M']");
    private final SelenideElement color = $x("//a[@id='color_14']");
    private final SelenideElement favorite = $x("//a[@id='wishlist_button']");
    private final SelenideElement messageAddFavorite = $x("//p[@class='fancybox-error']");

    public String addToFavorite() {
        size.click();
        color.click();
        favorite.click();
        return messageAddFavorite.getText();
    }
}
