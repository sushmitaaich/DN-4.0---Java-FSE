public class Main {
    public static void main(String[] args) {
        TaskLinkedList tasks = new TaskLinkedList();
        tasks.addTask(new Task("T001", "Design Module", "Pending"));
        tasks.addTask(new Task("T002", "Implement API", "In Progress"));
        tasks.addTask(new Task("T003", "Test Features", "Pending"));

        System.out.println("All Tasks:");
        tasks.traverse();

        System.out.println("\nSearching T002:");
        System.out.println(tasks.searchTask("T002"));

        System.out.println("\nDeleting T001");
        tasks.deleteTask("T001");

        System.out.println("\nFinal Task List:");
        tasks.traverse();
    }
}
