import java.util.Arrays;
public class Lesson2 {
    public static void main(String[] args) {
//      ex. 1
        printThreeWords();
//      ex. 2
        checkSumSign();
//      ex. 3
        printColor();
//      ex. 4
        compareNumbers();
//      ex. 5
        System.out.println(isSumInLimit10And20(5, 7));
//      ex. 6
        numberSign(5);
//      ex. 7
        System.out.println(negativeIsTrue(-1));
//      ex. 8
        amountOfString("Woof",5);
//      ex. 9
        System.out.println(leapYear(2024));
//      ex. 10
        arrayInverse();
//      ex. 11
        array100();
//      ex. 12
        arrayCheckLess6();
//      ex. 13
        twoDimArray();
//      ex. 14
        arrayInitialValue(5, 2);
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
        } 
        else if (value > 0 && value <= 100) {
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
        } 
            else {
            System.out.println("a < b");
            }
    }

//    ex. 5
     static boolean isSumInLimit10And20(int a, int b){
        int sum = a+b;
        return (sum>=10 && sum<=20);
        }

//    ex. 6
    static void numberSign(int a){
        if (a<0){
            System.out.println("Отрицательное");
        }
        else {
            System.out.println("Положительное");
        }
    }

//    ex. 7
    static boolean negativeIsTrue(int a){
        return a<0;
    }

//    ex. 8
    static void amountOfString(String str, int a){
        int i=0;
        while (i<a){
            System.out.println(str);
            i++;
        }
    }

//    ex. 9
    static boolean leapYear(int a) {
        return (a % 4 == 0 && a % 100 != 0) || a % 400 == 0;
    }

//    ex. 10
    static void arrayInverse() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int i = 0;
        while (i< arr.length) {
            if (arr[i] == 1) {
                arr[i] = 0;
            }
            else {
                arr[i] = 1;
            }
            i++;
        }
        System.out.println(Arrays.toString(arr));
    }

//    ex. 11
    static void array100() {
        int[] arr = new int[100];
        int j = 1;
        for(int i=0; i<arr.length; i++){
            arr[i]=j;
            j++;
        }
        System.out.println(Arrays.toString(arr));
    }

//    ex. 12
    static void arrayCheckLess6() {
        int [] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int j;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]<6){
                arr[i]*=2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

//    ex. 13
    static void twoDimArray() {
        int[][] arr = new int[5][5];
        for(int i = 0; i< arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == j || i + j == arr[0].length-1) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

//    ex. 14
    static int[] arrayInitialValue(int len, int initialValue){
        int [] arr = new int[len];
        for(int i=0; i<len; i++){
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
        return arr;

    }
}
