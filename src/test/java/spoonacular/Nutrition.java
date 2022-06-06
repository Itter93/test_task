package spoonacular;

import java.util.ArrayList;

public class Nutrition {
    private ArrayList<Nutrient> nutrients;

    public Nutrition() {
    }

    public Nutrition(ArrayList<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }

    public ArrayList<Nutrient> getNutrients() {
        return nutrients;
    }
}
