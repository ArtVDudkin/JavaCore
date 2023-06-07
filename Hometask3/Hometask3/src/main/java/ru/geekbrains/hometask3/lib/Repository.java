package ru.geekbrains.hometask3.lib;

import java.util.Arrays;
import java.util.Comparator;

public class Repository implements Comparator<Worker> {

    private Worker[] workers;

    public Repository(Worker[] workers) {
        this.workers = workers;
    }

    /**
     * Метод сортировки массива работников по имени
     */
    public void sortByName() {
        Arrays.sort(workers, Comparator.comparing(Worker::getName));
    }

    /**
     * Метод сортировки массива работников по среднемесячной зарплате
     */
    public void sortByAverageSalary() {
        Arrays.sort(workers, Comparator.comparing(Worker::getAverageMonthlySalary));
    }

    /**
     * Метод для вывода на экран информации обо всех работниках
     */
    public void printInfo() {
        for (Worker worker : workers) {
            System.out.println(worker.toString());
        }
    }

    /**
     * Метод сравнения двух объектов типа Worker по их среднемесячной зарплате
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Worker o1, Worker o2) {
        if(o1.getAverageMonthlySalary() > o2.getAverageMonthlySalary()) {
            return 1;
        } else {
            return 0;
        }
    }
}
