package ru.geekbrains.hometask4;

public class Program {

    public static void main(String[] args) {

        //array A = 4x4 >>> size = Ok, all numbers = Ok
        String[][] arrA = {{"1", "2", "3", "4"},{"5", "6", "7", "8"},{"9", "10", "11", "12"},{"13", "14", "15", "16"}};
        //array B = 3x4 >>> incorrect size, all numbers = Ok
        String[][] arrB = {{"1", "2", "3", "4"},{"5", "6", "7", "8"},{"9", "10", "11", "12"}};
        //array C = 4x4 >>> size = Ok, not a number somewhere
        String[][] arrC = {{"1", "2", "3", "A"},{"5", "6", "7", "B"},{"9", "10", "LL", "12"},{"13", "14", "15", "16"}};
        int maxRow = 4;
        int maxCol = 4;

        try {
            int sum = getSum(arrA, maxRow, maxCol);
            System.out.println("Сумма элементов массива A = " + sum);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            int sum = getSum(arrB, maxRow, maxCol);
            System.out.println("Сумма элементов массива B = " + sum);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            int sum = getSum(arrC, maxRow, maxCol);
            System.out.println("Сумма элементов массива C = " + sum);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method converts all elements of string array 4x4 to integer values and returns a sum of them
     * @param arr input array to
     * @param maxRow maximum allowed row count of input array
     * @param maxCol maximum allowed column count of input array
     * @return a sum of elements of array
     * @throws MyArraySizeException when input array size is not equal 4x4
     * @throws MyArrayDataException when one or more elements of array can not be converted to integer
     */
    public static int getSum(String[][] arr, int maxRow, int maxCol) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != maxRow || arr[0].length != maxCol) {
            throw new MyArraySizeException("Ошибка! Размер массива должен быть равен ", maxRow, maxCol);
        }
        int sum = 0;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка чтения данных в ячейке", i, j);
                }
            }
        }
        return sum;
    }

}
