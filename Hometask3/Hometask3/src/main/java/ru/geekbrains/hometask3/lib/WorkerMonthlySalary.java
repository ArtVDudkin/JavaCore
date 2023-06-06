package ru.geekbrains.hometask3.lib;

import ru.geekbrains.hometask3.lib.Worker;

public class WorkerMonthlySalary extends Worker {

    private double salaryPerMonth;

    public WorkerMonthlySalary(String name, double salaryPerMonth) {
        super.name = name;
        this.salaryPerMonth = salaryPerMonth;
    }

    public WorkerMonthlySalary() {
        super.name = "unknown";
        this.salaryPerMonth = 0;
    }

    @Override
    public void calcSalary() {
        super.setAverageMonthlySalary(this.salaryPerMonth);
    }

    @Override
    public String toString() {
        return String.format("Имя: %s, Среднемесячная зарплата: %.2f", name, getAverageMonthlySalary());
    }

}
