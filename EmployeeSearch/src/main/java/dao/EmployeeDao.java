package dao;

import pojos.Employee;

public class EmployeeDao {

    public Employee searchEmployee(int id) {
        // Dummy data (no DB for simplicity)
        if (id == 101) {
            return new Employee(101, "Rahul", "IT");
        }
        return null;
    }
}
