public class TaskLinkedList {
    private Task head;

    public void addTask(Task task) {
        if (head == null) head = task;
        else {
            Task temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = task;
        }
    }

    public Task searchTask(String id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId.equals(id)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void deleteTask(String id) {
        if (head == null) return;
        if (head.taskId.equals(id)) {
            head = head.next;
            return;
        }
        Task prev = head, curr = head.next;
        while (curr != null) {
            if (curr.taskId.equals(id)) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void traverse() {
        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
