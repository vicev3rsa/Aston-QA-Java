package Lesson4_ex1;
public class AnimalApp {
    public static void main(String[] args) {

        // Cоздаем собаку Чаппи
        Dog dogChappi = new Dog("Чаппи ");
        dogChappi.run(150);
        dogChappi.run(600);
        dogChappi.swim(5);
        dogChappi.swim(15);

        // Создаем миску 1
        Bowl bowl1 = new Bowl(10);

        // Cоздаем кота Барсика
        Cat catBarsic = new Cat("Барсик ");
        catBarsic.run(100);
        catBarsic.run(250);
        catBarsic.swim(10);
        catBarsic.eat(bowl1, 0);
        catBarsic.eat(bowl1, 10);
        bowl1.addFood(0);

        // Создаем миску 2
        Bowl bowl2 = new Bowl(10);
        
        // Cоздаем массив котов
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Мурзик ");
        cats[1] = new Cat("Кузя ");
        cats[2] = new Cat("Дымок ");

        // Просим всех котов покушать
        for (Cat cat : cats) {
            cat.eat(bowl2, 5);
        }

        // Выводим информацию о сытости котов
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сытость: " + cat.isSatiety());
        }

        // Выводим количество созданных животных
        System.out.println();
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
    }
}











