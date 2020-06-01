package com.company.manager;

import com.company.employee.Employee;

import java.io.Serializable;

public class Manager extends Employee implements Serializable {
    double bonus;

    public Manager(String name,String surname,double bonus,double sal) {
        super(name,surname,sal);
        this.bonus = bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public double getSal() {
        return this.salary + this.bonus;
    }

    public String toString(){
        return "У менеджера " + this.name + " " + this.surname + " номер " + this.id +  " зарплата равна = " + this.salary + " долларов и бонус составляет  = " + this.bonus+ " долларов";
    }
}

