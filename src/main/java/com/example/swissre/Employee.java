package com.example.swissre;

public class Employee {
    private final String empId;
    private final String firstName;
    private final String lastName;
    private final double salary;
    private final String managerId;

    public Employee(String empId, String firstName, String lastName, double salary, String managerId) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.managerId = (managerId == null || managerId.isBlank()) ? null : managerId;
    }

    public String getId() {
        return empId;
    }

    public String getManagerId() {
        return managerId;
    }

    public double getSalary() {
        return salary;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
