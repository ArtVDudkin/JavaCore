package ru.geekbrains.hometask1.lib;

public class Point2D {

    int x, y;

    /**
     * Конструктор объекта двухмерная точка
     *
     * @param x - координата Х
     * @param y - координата Y
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("x: %d  y: %d", x, y);
    }
}
