package com.example.swissre;


import java.util.*;

public class EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();
    private final Map<String, List<Employee>> managerToSubs = new HashMap<>();

    public void addEmployee(Employee e) {
        employees.put(e.getId(), e);
        if (e.getManagerId() != null) {
            List<Employee> subs = managerToSubs.get(e.getManagerId());
            
            if (subs == null) {
                subs = new ArrayList<>();
                managerToSubs.put(e.getManagerId(), subs);
            }
            subs.add(e);
        }
        
    }

    /**
        * Rules for a manager's salary:
        * - A manager should earn at least 20% more than the average salary of their direct reports.
        * - A manager should not earn more than 50% above that same average.
    */

    public List<String> getSalaries() {
        List<String> results = new ArrayList<>();
        for (var entry : managerToSubs.entrySet()) {
            Employee manager = employees.get(entry.getKey());
            List<Employee> subs = entry.getValue();

            double avgSalary = subs.stream().mapToDouble(Employee::getSalary).average().orElse(0);
            double minSalaryAllowed = avgSalary * 1.2;
            double maxSalaryAllowed = avgSalary * 1.5;

            if (manager.getSalary() < minSalaryAllowed) {
                results.add(manager.getFullName() + " earns less than allowed by " +
                        (minSalaryAllowed - manager.getSalary()));
            } else if (manager.getSalary() > maxSalaryAllowed) {
                results.add(manager.getFullName() + " earns more than allowed by " +
                        (manager.getSalary() - maxSalaryAllowed));
            }
        }
        return results;
    }

    /**
     * Employees with more than 4 managers between them and the CEO.
     */
    public List<String> getReportingDepth() {
        List<String> results = new ArrayList<>();
        for (Employee e : employees.values()) {
            int depth = getDepth(e);
            if (depth > 4) {
                results.add(e.getFullName() + " has reporting line too long by " +
                        (depth - 4) + " levels");
            }
        }
        return results;
    }

    private int getDepth(Employee e) {
        int depth = 0;
        while (e.getManagerId() != null) {
            depth++;
            e = employees.get(e.getManagerId());
        }
        return depth;
    }
}

