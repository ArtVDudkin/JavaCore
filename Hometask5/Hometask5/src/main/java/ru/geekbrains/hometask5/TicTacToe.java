package ru.geekbrains.hometask5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
public class TicTacToe {

    private static final int SIZE_X = 3;
    private static final int SIZE_Y = 3;
    private static final int[] values = {0, 1, 2, 3};
    private static final Random random = new Random();
    private int[] field;

    public TicTacToe() {
        this.field = new int[SIZE_X * SIZE_Y];
    }

    /**
     * Метод заполняет ячейки поля случайными значениями в диапазоне [0,3]
     */
    public void fillField() {
        for (int i = 0; i < this.field.length; i++) {
            this.field[i] = random.nextInt(values.length);
        }
    }

    /**
     * Метод выводит в консоль текущие значения ячеек поля (массив)
     */
    public void printField() {
        for (int i = 0; i < this.field.length; i++) {
            System.out.print(this.field[i] + " ");
        }
        System.out.println();
    }

    /**
     * Метод сохраняет в файл текущее поле из 3х3 ячеек (9 значений) таким образом, чтобы это заняло 3 байта
     */
    public void saveField() {
        byte[] bytes = new byte[3];
        // собираем построчно значения ячеек поля 3х3, чтобы получилось трехначное число
        for(int i = 0; i < bytes.length; i++) {
            int row = 0;
            for (int j = 0; j < SIZE_Y; j++) {
                row += this.field[SIZE_Y * i + j] * Math.pow(10,SIZE_Y - j -1);
            }
            // конвертируем полученное трехзначное число в байт
            bytes[i] = (byte)(row & 0xFF);
        }

        // Записываем байты в файл
        try (FileOutputStream fos = new FileOutputStream("file_binary.txt")) {
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
