// THIS CLASS IS USED WITH Main_v4
public class Fruit {
    private String name;
    private String family;
    private double calories;
    private double carbohydrates;
    private double protein;
    private double fat;
    private double sugar;

    // Constructor
    public Fruit(String name, String family, double calories, double carbohydrates, double protein, double fat, double sugar) {
        this.name = name;
        this.family = family;
        this.calories = calories;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
        this.fat = fat;
        this.sugar = sugar;
    }

    // Getters
    public String getName() { return name; }
    public String getFamily() { return family; }
    public double getCalories() {
        return calories;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getSugar() {
        return sugar;
    }

    public String toString() {
        return String.format("Family: %s, Calories: %.2f, Carbohydrates: %.2f, Protein: %.2f, Fat: %.2f, Sugar: %.2f",
                family, calories, carbohydrates, protein, fat, sugar);
    }
}
