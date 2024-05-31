package Lesson4_ex1;

public class Cat extends Animal {
    private static int catCount = 0;
    private static final int MAX_RUN_DISTANCE = 200;
    private boolean satiety;

    public Cat(String name) {
        super(name);
        satiety = false;
        catCount++;
    }
    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + "пробежал " + distance + "м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + "м. Максимальная дистанция: " + MAX_RUN_DISTANCE + "м.");
        }
    }
    @Override
    public void swim(int distance) {
        System.out.println(name + "не умеет плавать.");
    }
    public static int getCatCount() {
        return catCount;
    }
    public void eat(Bowl bowl, int catEat) {
        if (catEat <= 0) {
            System.out.println(name + " не может съесть отрицательное или нулевое количество еды.");

            return;
        }
        if (this.satiety) {
            System.out.println(name + " сыт и не хочет есть.");
        } else if (bowl.decreaseFood(catEat)) {
            System.out.println(name + "смог съесть " + catEat + " вкусняшек, теперь он сытый.");
            satiety = true;
        } else {
            System.out.println(name + "не притронулся к еде, так как ее недостаточно.");
        }
        bowl.printFoodAmount();
    }
    public boolean isSatiety() {
        return  satiety;
    }
    public String getName() {
        return name;
    }
}
