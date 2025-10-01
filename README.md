# BIG COMPANY Employee Analyzer

## 📌 Problem Statement
BIG COMPANY employs many employees and wants to analyze its organizational structure for improvements.

The board has defined two rules:

1. **Manager salary rule**
   - A manager must earn **at least 20% more** than the average salary of their direct subordinates.
   - A manager must **not earn more than 50% above** the average salary of their direct subordinates.

2. **Reporting depth rule**
   - An employee should have **no more than 4 managers** between them and the CEO.

The program:
- Reads employee data from a CSV file.
- Detects violations of salary rules.
- Detects violations of reporting depth rules.
- Prints the results to the console.

---

## 📂 CSV File Structure
Id,firstName,lastName,salary,managerId
123,Joe,Doe,60000,
124,Martin,Chekov,45000,123
125,Bob,Ronstad,47000,123
300,Alice,Hasacat,50000,124
305,Brett,Hardleaf,34000,300


- Each row represents an employee.
- `managerId` is empty for the CEO.

---

## 🛠️ Tech Stack
- **Java SE** (any version)
- **JUnit 5** for testing
- **Maven** for build

---

## ▶️ How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/atul48kumar90/swiss-re-assignment.git

## 🚀 Build & Run
mvn clean install
mvn exec:java -Dexec.mainClass="com.example.swissre.Main"

## 🧪 Run Tests
mvn test

## 🔄 Continuous Integration

This project uses GitHub Actions for CI.
On every push/PR to main, Maven build and tests are automatically executed.

## 👤 Author
Atul Kumar Karn
atul48kumar90@gmail.com