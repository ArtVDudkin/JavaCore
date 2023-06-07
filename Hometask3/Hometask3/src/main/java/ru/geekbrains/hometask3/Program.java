package ru.geekbrains.hometask3;

import ru.geekbrains.hometask3.lib.Repository;
import ru.geekbrains.hometask3.lib.Worker;
import ru.geekbrains.hometask3.lib.WorkerHourlySalary;
import ru.geekbrains.hometask3.lib.WorkerMonthlySalary;

public class Program {

    public static void main(String[] args) {

        Worker[] workers = {
                new WorkerHourlySalary("Аркадий", 300),
                new WorkerHourlySalary("Сергей", 220),
                new WorkerHourlySalary("Федор", 350),
                new WorkerMonthlySalary("Максим",45000),
                new WorkerMonthlySalary("Михаил",50000),
                new WorkerMonthlySalary("Юлия",35000),
        };

        System.out.println("Исходный массив работников:");
        for (Worker worker: workers) {
            worker.calcSalary();
            System.out.println(worker.toString());
        }

        // Создаем объект класса Repository и добавляем в него массив работников
        Repository workersRepo = new Repository(workers);

        // Сортировка массива работников по имени
        workersRepo.sortByName();
        System.out.println("\nСортировка работников по имени:");
        workersRepo.printInfo();

        // Сортировка массива работников по заработной плате
        workersRepo.sortByAverageSalary();
        System.out.println("\nСортировка работников по среднемесячной зарплате:");
        workersRepo.printInfo();
    }

}
