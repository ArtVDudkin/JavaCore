package ru.geekbrains.hometask3.lib;

import ru.geekbrains.hometask3.lib.Worker;

public class WorkerHourlySalary extends Worker {

    private double salaryPerHour;
    public WorkerHourlySalary(String name, double hourlySalary) {
        super.name = name;
        this.salaryPerHour = hourlySalary;
    }

    public WorkerHourlySalary() {
        super.name = "unknown";
        this.salaryPerHour = 0;
    }

    @Override
    public void calcSalary() {
        super.setAverageMonthlySalary(20.8 * 8 * this.salaryPerHour);
    }

    @Override
    public String toString() {
        return String.format("Имя: %s, Среднемесячная зарплата: %.2f", name, getAverageMonthlySalary());
    }

}
