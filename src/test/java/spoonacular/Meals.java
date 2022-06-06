package spoonacular;


public class Meals {
    private Integer id;
    private String title;
    private String image;
    private String imageType;
    public Nutrition nutrition;

    public Meals() {
    }

    public Meals(Integer id, String title, String image, String imageType, Nutrition nutrition) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.imageType = imageType;
        this.nutrition = nutrition;
    }

    public Meals(Integer id, String title, String image, String imageType) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.imageType = imageType;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getImageType() {
        return imageType;
    }

    public Nutrition getNutrient() {
        return nutrition;
    }
}
