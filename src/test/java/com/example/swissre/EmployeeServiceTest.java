package com.example.swissre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();

        employeeService.addEmployee(new Employee("123", "Atul", "Karn", 60000, null));
        employeeService.addEmployee(new Employee("124", "Vipul", "Karn", 45000, "123"));
        employeeService.addEmployee(new Employee("125", "Amit", "Jha", 47000, "123"));
        employeeService.addEmployee(new Employee("126", "Ravi", "Singh", 50000, "124"));
        employeeService.addEmployee(new Employee("127", "Aashish", "Gunjan", 34000, "126"));
        employeeService.addEmployee(new Employee("128", "Deepak", "Kumar", 30000, "127"));
        employeeService.addEmployee(new Employee("129", "Sunil", "Verma", 28000, "128"));
    }

    @Test
    void test_AnalyzeSalaries() {
        List<String> issues = employeeService.getSalaries();
        assertFalse(issues.isEmpty(), "Salary issue should be detected");
    }

    @Test
    void test_ReportingDepth() {
        List<String> issues = employeeService.getReportingDepth();
        assertTrue(issues.stream().anyMatch(s -> s.contains("Sunil Verma")));
    }
}
