package com.company.employee;

import com.company.manager.Manager;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {

    protected int id;
    protected static int nextId;
    protected String name;
    protected String surname;
    protected double salary ;
    protected Manager manager;

    public Employee( String name,String surname,double sal) {
        this.nextId++;
        this.id = this.nextId;
        this.name = name;
        this.surname = surname;
        this.salary= sal;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSal(double salary) {
        this.salary = salary;
    }

    public double getSal() {
        return salary;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }

    public final void addSalary(double p){
        this.salary = this.salary*(100+p)/100;
    }
    public String toString(){
        return "У рабочего " + this.name + " " + this.surname + " номер - " + this.id +  " зарплата = " + this.salary;
    }

    public void getManagerName(){
        if(manager == null) {
            System.out.println("У этого работника нет менеджера ");
        }else {
            System.out.println(this.getManager().getName());
        }
    }

    public Employee getTopManager(Manager manager){
        if(manager == null) {
            return this;
        }else {
            return manager.getTopManager(manager.getManager());
        }
    }
}