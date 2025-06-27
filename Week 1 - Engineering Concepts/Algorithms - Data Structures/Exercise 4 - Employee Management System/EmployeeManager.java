public class EmployeeManager {
    Employee[] employees = new Employee[100];
    int count = 0;

    public void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count++] = e;
        }
    }

    public Employee searchById(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId.equals(id)) return employees[i];
        }
        return null;
    }

    public void deleteEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId.equals(id)) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                break;
            }
        }
    }

    public void listEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }
}
