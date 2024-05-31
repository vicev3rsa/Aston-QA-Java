package Lesson4_ex1;

public abstract class Animal {
    private static int animalCount = 0;
    protected   String name;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);
    public static int getAnimalCount() {
        return animalCount;
    }
}
