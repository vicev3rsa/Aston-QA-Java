package Lesson4_ex1;

public class Bowl {
    private int foodAmount;
    public Bowl (int initialFood) {
        if (initialFood >= 0) {
            this.foodAmount = initialFood;
        } else {
            this.foodAmount = 0;
        }
    }
    public int getFoodAmount() {
        return foodAmount;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
        } else {
            System.out.println("Нельзя добавить отрицательное или нулевое количество вкусняшек.\n");
        }
    }
    public boolean decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        } else {
            return false;
        }
    }
    public void printFoodAmount() {
        System.out.println("Осталось еды: " + foodAmount + "\n");
    }
}
