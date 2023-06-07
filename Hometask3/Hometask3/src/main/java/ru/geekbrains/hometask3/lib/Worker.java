package ru.geekbrains.hometask3.lib;

import java.util.Comparator;

public abstract class Worker {

    protected String name;

    private double averageMonthlySalary;

    public String getName() {
        return name;
    }

    public abstract void calcSalary();

    public double getAverageMonthlySalary() {
        return averageMonthlySalary;
    }

    public void setAverageMonthlySalary(double averageMonthlySalary) {
        this.averageMonthlySalary = averageMonthlySalary;
    }

}
