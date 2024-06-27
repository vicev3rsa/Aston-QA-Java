package Lesson12_ex1;


// Основной класс с методом проверки массива
public class ArrayChecker {

    public static void checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Некорректный размер массива, требуется 4x4");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Некорректные данные в ячейке: [" + i + "][" + j + "]");
                }
            }
        }
        System.out.println("Корректный размер массива");
    }
}
