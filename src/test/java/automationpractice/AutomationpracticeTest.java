package automationpractice;

import automationpractice.Pages.MainPage;
import org.junit.Assert;
import org.junit.Test;

public class AutomationpracticeTest extends BaseTest {
    private final String URL = "http://automationpractice.com/";
    private final String ExpandBuy = "Your order on My Store is complete.";
    private final String ExpandFavorite = "Added to your wishlist.";


    //В этом тесте покупаем 2 платься, оформляем заказ(проверяем, что суммы совпадают), получаем сообшение о том что заказ оформлен
    @Test
    public void checkBuy() {
        Assert.assertTrue(new MainPage(URL)
                .clickDresses()
                .addToCart()
                .bought()
                .singInToAddess()
                .clickAddress()
                .checkShipping()
                .checkPayment()
                .contains(ExpandBuy));
    }

    //В этом тесте добавляем товар в избранное, выбрав нужный цвет и размер, после чего получаем сообшение о том что заказ оформлен
    @Test
    public void addToWishlist() {
        Assert.assertTrue(new MainPage(URL)
                .login()
                .singInToAccount()
                .returnHome()
                .clickClothes()
                .addToFavorite()
                .contains(ExpandFavorite));
    }
}
