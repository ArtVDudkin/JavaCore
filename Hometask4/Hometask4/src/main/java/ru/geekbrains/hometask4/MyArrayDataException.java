package ru.geekbrains.hometask4;

public class MyArrayDataException extends NumberFormatException{
    private String message;
    private int row;
    private int col;

    public MyArrayDataException(String message, int row, int col) {
        this.message = message;
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.printf(message + " [%d][%d]\n", row, col);
    }
}
