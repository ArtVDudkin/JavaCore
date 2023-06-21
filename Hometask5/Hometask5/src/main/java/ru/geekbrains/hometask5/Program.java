package ru.geekbrains.hometask5;

import java.io.File;
import java.io.IOException;

public class Program {

    public static void main(String[] args) {

        String sourceDir = ".";
        String backupDir = "./backup";

        // Создаем backup
        try {
            Backuper backup = new Backuper(sourceDir, backupDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Выводим в консоль файловый каталог, начиная с указанной директории sourceDir
        Tree.print(new File(sourceDir), "", true);

        // Сохраняем поле 3х3 из игры крестики-нолики в формате 3х байт
        TicTacToe field = new TicTacToe();
        field.fillField();
        field.printField();
        field.saveField();

    }

}
