package Lesson12_ex1;

// Класс с main
public class ArrayCheckerApp {
    public static void main(String[] args) {

        String[][] correctArraySizeData = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] incorrectArraySize = {
                {"1", "2", "3"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] incorrectArrayData = {
                {"1", "two", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };


        try {
            ArrayChecker.checkArray(correctArraySizeData);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            ArrayChecker.checkArray(incorrectArraySize);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            ArrayChecker.checkArray(incorrectArrayData);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
