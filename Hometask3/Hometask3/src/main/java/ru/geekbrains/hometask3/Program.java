package ru.geekbrains.hometask3;

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

        for (Worker worker: workers) {
            worker.calcSalary();
            System.out.println(worker.toString());
        }
    }

}
