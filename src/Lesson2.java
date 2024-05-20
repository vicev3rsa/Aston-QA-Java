public class Lesson2 {
    public static void main(String[] args) {
//        ex. 1
        printThreeWords();
//        ex. 2
        checkSumSign();
//        ex. 3
        printColor();
//        ex. 4
        compareNumbers();
//        ex. 5
        System.out.println(isSumInLimit10And20(5, 7));
//        ex. 6
//        ex. 7
//        ex. 8
//        ex. 9
//        ex. 10
//        ex. 11
//        ex. 12
//        ex. 13
//        ex. 14
    }


//    ex. 1
    static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }
//    ex. 2
    static void checkSumSign(){
        int a = -5;
        int b = 3;
        if (a+b>=0){
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }
//    ex. 3
    static void printColor(){
        int value = 8;
        if(value <=0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        }
        else if (value > 100) {
            System.out.println("Зеленый");
        }
        }
//    ex. 4
    static void compareNumbers(){
        int a = 5;
        int b = 3;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }

    }
//    ex. 5
//    5. Напишите метод, принимающий на вход два целых числа и проверяющий,
//    что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    public static boolean isSumInLimit10And20(int a, int b){
        int sum = a+b;
        return (sum>=10 && sum<=20);
        }



}