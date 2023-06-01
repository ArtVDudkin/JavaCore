package ru.geekbrains.hometask2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final Scanner scan = new Scanner(System.in);
    private static final Random rand = new Random();
    private static final  int WIN_COUNT = 4;  // Число фигур в один ряд для победы
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '•';
    private static char[][] field; // Двумерный массив хранит текущее состояние игрового поля
    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля


    public static void main(String[] args) {
        while (true){
            initGame();
            printField();
            while (true){
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "Компьютер победил!"))
                    break;
            }
            System.out.println("Желаете сыграть еще раз? (Y - да, N - нет)");
            if (!scan.next().equalsIgnoreCase("Y")) {
                System.exit(0);
            } else {
                initGame();
            }
        }
    }

    /**
     * Инициализация игрового поля
     */
    private static void initGame() {
        // Установим размерность игрового поля
        fieldSizeX = 9;
        fieldSizeY = 9;

        field = new char[fieldSizeX][fieldSizeY];
        // Проинициализируем все элементы массива DOT_EMPTY (признак пустого поля)
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     */
    private static void printField() {
        // Печатаем верхнюю часть поля
        System.out.print(" -");
        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print(x + 1 + "-");
        }
        System.out.println();
        // Печатаем среднюю часть поля
        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x <  fieldSizeX; x++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }
        // Печатаем нижнюю часть поля
        for (int x = 0; x < fieldSizeX + 1; x++) {
            System.out.print("--");
        }
        System.out.println();
    }

    /**
     * Обработка хода игрока (человек)
     */
    private static void humanTurn() {
        int x, y;
        do
        {
            System.out.printf("Чтобы победить, нужно составить в одну линию %d фигур\n", WIN_COUNT);
            System.out.printf("Введите через пробел координаты Вашего следующего хода: "
                    + "X (от 1 до %d) и Y (от 1 до %d) >>> ", fieldSizeX, fieldSizeY);
            x = scan.nextInt() - 1;
            y = scan.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Проверка, ячейка является пустой
     * @param x координата X
     * @param y координата Y
     * @return true если ячейка свободна
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размеры игрового поля)
     * @param x координата X
     * @param y координата Y
     * @return true если введены валидные координаты ячейки поля
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 &&  x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     *  TODO доработать бота - идея в слудующем:
     *  1. Выделить область поля (прямоугольник), где есть фигуры игрока и бота
     *  2. Сканируем эту область (горизонтали, вертикали, диагонали) на предмет линий из фигур бота и игрока
     *  2а. Если у бота есть линия из Win_count -1 фигур и он может победить следующим ходом - ставим
     *  2b. Если бот не может победить следующим ходом, смотрим, есть ли такая возможность у игрока и блокируем ее
     *  2c. Если игрок следующим ходом не побеждает, смотрим есть ли у него незаблокированная линия из Win_count -2 фигур и блокируем
     *  2d. Если у игрока нет линий из Win_count -2 фигур, смотрим есть ли у бота такие линии и ставим еще одну фигуру в линию
     *  2e. Если удачных комбинаций ни у кого нет, ставим фигуру бота рандомно рядом в линию с уже стоящей в радиусе 1-2 клетки
     *
     * Ход компьютера
     */
    private static void aiTurn() {
        int x, y;
        do
        {
            x = rand.nextInt(fieldSizeX);
            y = rand.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка победил ли кто-нибудь
     * @param c символ, характерный для игрока или компьютера
     * @return true если выявлен победитель
     */
    private static boolean checkWin(char c) {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (checkFrom(x,y)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param x текущая координата X
     * @param y текущая координата Y
     * @return true если найдена комбинация из WIN_COUNT одинаковых фигур подряд по вертикали, горизонтали или диагонали
     */
    private static boolean checkFrom(int x, int y) {
        char player = field[x][y];
        if (player == DOT_EMPTY) { // если ячейка свободная, дальше ничего не ищем
            return false;
        }
        boolean xWin = true;   // Проверяем ячейки горизонтали
        boolean yWin = true;   // Проверяем ячейки вертикали
        boolean xyWin = true;  // Проверяем ячейки по главной диагонали
        boolean yxWin = true;  // Проверяем ячейки по второстепенной диагонали
        for (int i = 0; i < WIN_COUNT; i++) {
            if (i + x >= fieldSizeX || field[i+x][y] != player) {
                xWin = false;
            }
            if (i + y >= fieldSizeY || field[x][i+y] != player) {
                yWin = false;
            }
            if (i + y >= fieldSizeY || i + x >= fieldSizeX || field[x+i][i+y] != player) {
                xyWin = false;
            }
            if (y + i >= fieldSizeY || x - i < 0 || field[x-i][y+i] != player) {
                yxWin = false;
            }
        }

        return xyWin || xWin || yWin || yxWin;
    }

    /**
     * Проверка на ничью
     * @return true если все ячейки на поле уже заняты и свободных нет
     */
    static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++)
                if (isCellEmpty(x, y)) return false;
        }
        return true;
    }

    /**
     * Метод проверки состояния игры
     * @param c символ, характерный для игрока или компьютера
     * @param str сообщение о результате игры
     * @return true если игра завершился чьей-то победой, либо ничьей. false если игра не закончена
     */
    static boolean gameCheck(char c, String str) {
        if (checkWin(c)) {
            System.out.println(str);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false; // Игра продолжается
    }

}
