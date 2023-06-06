package ru.geekbrains.hometask3.lib;

public abstract class Worker {

    protected String name;

    private double averageMonthlySalary;

    public abstract void calcSalary();

    public double getAverageMonthlySalary() {
        return averageMonthlySalary;
    }

    public void setAverageMonthlySalary(double averageMonthlySalary) {
        this.averageMonthlySalary = averageMonthlySalary;
    }

}
