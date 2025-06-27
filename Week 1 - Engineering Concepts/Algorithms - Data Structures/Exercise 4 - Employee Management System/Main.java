public class Main {
    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager();
        em.addEmployee(new Employee("E001", "John", "Manager", 75000));
        em.addEmployee(new Employee("E002", "Alice", "Developer", 60000));
        em.addEmployee(new Employee("E003", "Bob", "Tester", 50000));

        System.out.println("All Employees:");
        em.listEmployees();

        System.out.println("\nSearching for E002:");
        System.out.println(em.searchById("E002"));

        System.out.println("\nDeleting E003");
        em.deleteEmployee("E003");

        System.out.println("\nFinal List:");
        em.listEmployees();
    }
}
