package ru.geekbrains.hometask5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Backuper {

    public Backuper(String sourcePath, String backupPath) {
        try {
            createBackup(sourcePath, backupPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод создает backup директории, указанной в качесте текущей, в папку ./backup.
     * Если папка ./backup уже существует, пользователю предлагается выбрать, перезаписать папку ./backup или нет.
     * В случае подтверждения перезаписи всё содержимое папки ./backup удаляется и записывается заново.
     * @param sourcePath путь к текущей директории
     * @param backupPath путь к директории, в которой нужно создать backup
     * @throws IOException исключение, если по каким-либо причинам не удается скопировать файл
     */
    private void createBackup(String sourcePath, String backupPath) throws IOException {

        Scanner scan = new Scanner(System.in);
        File backupDir = new File(backupPath);
        // проверяем, существует ли директория ./backup
        if (backupDir.exists()) {
            System.out.println("Директория ./backup уже существует в текущей директории! Хотите её заменить? y/n");
            if (!scan.next().equalsIgnoreCase("Y")) {
                // если пользователь не хочет перезаписать директорию ./backup, то завершаем работу
                return;
            } else {
                // иначе удаляем директорию ./backup вместе с её содержимым
                deleteDir(backupDir);
            }
        }
        backupDir.mkdir();

        // Получаем список файлов в директории
        File sourceDir = new File(sourcePath);
        File[] filesToBackup = sourceDir.listFiles();

        // Копируем каждый файл в папку с резервными копиями
        for (File file : filesToBackup) {
            if (file.isFile()) {
                Files.copy(file.toPath(), new File(backupDir.getPath() + "/" + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    /**
     * Метод удаляет рекурсивно указанную директорию file и всё её содерживмое
     * @param file директория, которую необходимо удалить
     */
    private void deleteDir(File file) {
        if (file.isDirectory()) {
            File[] dirs = file.listFiles();
            for (File dir: dirs) {
                deleteDir(dir);
            }
        }
        file.delete();
    }

}
