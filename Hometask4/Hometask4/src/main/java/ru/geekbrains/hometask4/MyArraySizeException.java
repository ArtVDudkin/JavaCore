package ru.geekbrains.hometask4;

public class MyArraySizeException extends RuntimeException {

    private String message;
    private int maxRow;
    private int maxCol;
    public MyArraySizeException(String message, int maxRow, int maxCol) {
        this.message = message;
        this.maxRow = maxRow;
        this.maxCol = maxCol;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.printf(message + "%d x %d\n", maxRow, maxCol);
    }
}
