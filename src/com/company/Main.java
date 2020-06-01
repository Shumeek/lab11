package com.company;

import com.company.employee.Employee;
import com.company.manager.Manager;

import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Manager manager = null;
        Employee employee1 = null;
        Employee employee2 = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Shumeek\\IdeaProjects\\lab11\\Manager.txt"));

            manager= new Manager(reader.readLine(),reader.readLine(),Double.parseDouble(reader.readLine()),Double.parseDouble(reader.readLine()));

            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Shumeek\\IdeaProjects\\Lab11\\Employee.txt"));

            employee1 = new Employee(reader.readLine(), reader.readLine(), Double.parseDouble(reader.readLine()));

            employee2 = new Employee(reader.readLine(), reader.readLine(), Double.parseDouble(reader.readLine()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                reader.close();
        }

        FileOutputStream fileOut = null;

        ObjectOutputStream out;


        FileInputStream fileIn = null;

        ObjectInputStream in;

        try {
            fileOut = new FileOutputStream("SerializedEmployee");
            out = new ObjectOutputStream(fileOut);


            out.writeObject(employee1);
            out.writeObject(employee2);

            fileOut = new FileOutputStream("SerializedManager");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(manager);

            fileIn = new FileInputStream("SerializedEmployee");
            in = new ObjectInputStream(fileIn);
            Employee serializedEmployee1 = (Employee) in.readObject();
            Employee serializedEmployee2 = (Employee) in.readObject();

            fileIn = new FileInputStream("SerializedManager");
            in = new ObjectInputStream(fileIn);
            Manager serializedManager1 = (Manager) in.readObject();

            System.out.println(serializedEmployee1);
            System.out.println(serializedEmployee2);

            System.out.println(serializedManager1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            fileIn.close();
            fileOut.close();
        }

    }
}
