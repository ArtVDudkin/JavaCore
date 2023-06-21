package ru.geekbrains.hometask5;

import java.io.File;

public class Program {

    public static void main(String[] args) {

        String sourceDir = ".";
        String backupDir = "./backup";

        // Создаем backup
        Backuper backup = new Backuper(sourceDir, backupDir);

        // Выводим в консоль файловый каталог, начиная с указанной директории sourceDir
        Tree.print(new File(sourceDir), "", true);

        TicTacToe field = new TicTacToe();
        field.fillField();
        field.printField();
        field.saveField();

    }

}
