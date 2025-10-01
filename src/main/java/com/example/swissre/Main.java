package com.example.swissre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String file = "src/main/resources/employees_file_1.csv";
        EmployeeService employeeService = new EmployeeService();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0].trim();
                String firstName = parts[1].trim();
                String lastName = parts[2].trim();
                double salary = Double.parseDouble(parts[3].trim());
                String managerId = parts.length > 4 ? parts[4].trim() : null;

                employeeService.addEmployee(new Employee(id, firstName, lastName, salary, managerId));
            }
        }

        System.out.println("------ Salary Analysis ------");
        List<String> managerWithLessSalary = employeeService.getSalaries();
        managerWithLessSalary.forEach(System.out::println);

        System.out.println("\n------ Reporting Depth Analysis ------");
        List<String> empWithDepthIssue = employeeService.getReportingDepth();
        if (empWithDepthIssue.isEmpty()) {
            System.out.println("------(no issues)------");
        } else {
            empWithDepthIssue.forEach(System.out::println);
        }
    }
}

