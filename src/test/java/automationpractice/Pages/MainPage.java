package automationpractice.Pages;

import automationpractice.Pages.OrderPages.SingInPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement dresses = $x("(//div[@id='block_top_menu']//a[@title='Dresses'])[2]");
    private final SelenideElement clothe = $x("(//div[@class='product-container'])[1]");
    private final SelenideElement clotheMore = $x("(//div[@class='product-container'])[1]//a[@title='View']");
    private final SelenideElement loginButton = $x("//a[@class='login']");

    public MainPage() {
    }

    public MainPage(String URL) {
        Selenide.open(URL);
    }

    public DressesPage clickDresses() {
        dresses.click();
        return new DressesPage();
    }

    public SingInPage login() {
        loginButton.click();
        return new SingInPage();
    }

    public ClothesPage clickClothes() {
        clothe.hover();
        clotheMore.click();
        return new ClothesPage();
    }

}
