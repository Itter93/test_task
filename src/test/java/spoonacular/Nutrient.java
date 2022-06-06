package spoonacular;

public class Nutrient {
    private String name;
    private Double amount;
    private String unit;

    public Nutrient() {
    }

    public Nutrient(String name, Double amount, String unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }
}
