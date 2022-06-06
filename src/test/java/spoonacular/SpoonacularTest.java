package spoonacular;

import io.restassured.http.ContentType;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class SpoonacularTest {
    private static final String URL = "https://api.spoonacular.com/recipes/complexSearch";

    //проверка фильтра по максимальному содержанию алкоголя
    @Test
    public void checkFilterMaxAlcohol() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec(200));
        List<Meals> meals = given()
                .when()
                .get("?apiKey=983477874ad343598decb6ab280bca0e&cuisine=italian&maxAlcohol=10&number=10")
                .then()
                .extract().body().jsonPath().getList("results", Meals.class);

        List<ArrayList<Nutrient>> nut = meals.stream().map(Meals::getNutrient).map(Nutrition::getNutrients).collect(Collectors.toList());

        for (ArrayList<Nutrient> s : nut) {
            for (Nutrient n : s) {
                Assert.assertEquals("Alcohol", n.getName());
                Assert.assertTrue(n.getAmount() < 10.0);
            }
        }
    }

    //Проверка поиска по названию блюда
    @Test
    public void checkSearchTitle() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec(200));
        List<Meals> meals = given()
                .when()
                .get("?apiKey=983477874ad343598decb6ab280bca0e&query=Rice Pudding")
                .then()
                .extract().body().jsonPath().getList("results", Meals.class);

               meals.stream().forEach(x-> Assert.assertTrue(x.getTitle().toLowerCase(Locale.ROOT).contains("rice pudding")));
    }

    //Проверка соответствия формата картинки
    @Test
    public void checkImageType() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec(200));
        List<Meals> meals = given()
                .when()
                .get("?apiKey=983477874ad343598decb6ab280bca0e&number=100")
                .then()
                .extract().body().jsonPath().getList("results", Meals.class);

        Assert.assertTrue(meals.stream().allMatch(x -> x.getImage().endsWith(x.getImageType())));
    }

    //Проверка количества возвращаемых записей
    @Test
    public void checkCountMeals() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec(200));
        List<Meals> meals = given()
                .when()
                .get("?apiKey=983477874ad343598decb6ab280bca0e&number=5")
                .then()
                .extract().body().jsonPath().getList("results", Meals.class);

        Assert.assertEquals(5, meals.size());
    }

    //Проверка отправки запроса при отсутствии авторизации
    @Test
    public void checkNotAuthorized() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec(401));
        Error error = given()
                .when()
                .get()
                .then()
                .extract().as(Error.class);
        Assert.assertEquals("You are not authorized. Please read https://spoonacular.com/food-api/docs#Authentication", error.getMessage());
    }

}
