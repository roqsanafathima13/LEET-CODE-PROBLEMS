import java.util.*;

// ---------- Study Task Model ----------
class StudyTask {
    private int taskId;
    private String subject;
    private String topic;
    private String date;      // e.g., "2026-08-05"
    private String priority;  // High, Medium, Low
    private String status;    // Pending, Completed

    public StudyTask(int taskId, String subject, String topic, String date, String priority) {
        this.taskId = taskId;
        this.subject = subject;
        this.topic = topic;
        this.date = date;
        this.priority = priority;
        this.status = "Pending";
    }

    public int getTaskId() { return taskId; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return String.format(
            "ID: %-5d Subject: %-12s Topic: %-18s Date: %-12s Priority: %-8s Status: %-10s",
            taskId, subject, topic, date, priority, status
        );
    }
}

// ---------- Study Planner Management System ----------
class StudyPlannerSystem {
    private ArrayList<StudyTask> taskList;
    private HashMap<Integer, Integer> idIndexMap; // taskId -> index in ArrayList

    public StudyPlannerSystem() {
        taskList = new ArrayList<>();
        idIndexMap = new HashMap<>();
    }

    // ---------- ADD ----------
    public void addTask(int id, String subject, String topic, String date, String priority) {
        if (idIndexMap.containsKey(id)) {
            System.out.println("Error: Task with ID " + id + " already exists.");
            return;
        }
        StudyTask task = new StudyTask(id, subject, topic, date, priority);
        taskList.add(task);
        idIndexMap.put(id, taskList.size() - 1);
        System.out.println("Task added successfully: " + task);
    }

    // ---------- SEARCH ----------
    public StudyTask searchTask(int id) {
        Integer index = idIndexMap.get(id);
        if (index == null) {
            System.out.println("Task with ID " + id + " not found.");
            return null;
        }
        StudyTask task = taskList.get(index);
        System.out.println("Task found: " + task);
        return task;
    }

    // ---------- UPDATE ----------
    public void updateTask(int id, String subject, String topic, String date, String priority) {
        Integer index = idIndexMap.get(id);
        if (index == null) {
            System.out.println("Cannot update. Task with ID " + id + " not found.");
            return;
        }
        StudyTask task = taskList.get(index);
        if (subject != null && !subject.isEmpty()) task.setSubject(subject);
        if (topic != null && !topic.isEmpty()) task.setTopic(topic);
        if (date != null && !date.isEmpty()) task.setDate(date);
        if (priority != null && !priority.isEmpty()) task.setPriority(priority);
        System.out.println("Task updated successfully: " + task);
    }

    // ---------- MARK COMPLETED ----------
    public void markCompleted(int id) {
        Integer index = idIndexMap.get(id);
        if (index == null) {
            System.out.println("Cannot mark complete. Task with ID " + id + " not found.");
            return;
        }
        StudyTask task = taskList.get(index);
        task.setStatus("Completed");
        System.out.println("Task marked as completed: " + task);
    }

    // ---------- DELETE ----------
    public void deleteTask(int id) {
        Integer index = idIndexMap.get(id);
        if (index == null) {
            System.out.println("Cannot delete. Task with ID " + id + " not found.");
            return;
        }
        int lastIndex = taskList.size() - 1;
        StudyTask lastTask = taskList.get(lastIndex);

        // Swap the task to remove with the last task to allow O(1) removal
        Collections.swap(taskList, index, lastIndex);
        idIndexMap.put(lastTask.getTaskId(), index);

        taskList.remove(lastIndex);
        idIndexMap.remove(id);

        System.out.println("Task with ID " + id + " deleted successfully.");
    }

    // ---------- DISPLAY ALL ----------
    public void displayAllTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No study tasks available.");
            return;
        }
        System.out.println("\n===== All Study Tasks =====");
        for (StudyTask t : taskList) {
            System.out.println(t);
        }
        System.out.println("Total Tasks: " + taskList.size());
    }

    // ---------- DISPLAY PENDING (sorted by priority) ----------
    public void displayPendingTasks() {
        ArrayList<StudyTask> pending = new ArrayList<>();
        for (StudyTask t : taskList) {
            if (t.getStatus().equalsIgnoreCase("Pending")) {
                pending.add(t);
            }
        }
        if (pending.isEmpty()) {
            System.out.println("No pending study tasks.");
            return;
        }
        List<String> order = Arrays.asList("High", "Medium", "Low");
        pending.sort((a, b) -> Integer.compare(order.indexOf(a.getPriority()), order.indexOf(b.getPriority())));

        System.out.println("\n===== Pending Study Tasks (sorted by priority) =====");
        for (StudyTask t : pending) {
            System.out.println(t);
        }
    }

    public int getTotalTasks() {
        return taskList.size();
    }
}

// ---------- Main / Menu-driven Program ----------
public class Main {
    public static void main(String[] args) {
        StudyPlannerSystem planner = new StudyPlannerSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Personal Study Planner =====");
            System.out.println("1. Add Study Task");
            System.out.println("2. Update Study Task");
            System.out.println("3. Search Study Task");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Delete Study Task");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Display Pending Tasks (by Priority)");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Subject: ");
                    String subject = sc.nextLine();
                    System.out.print("Enter Topic: ");
                    String topic = sc.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    System.out.print("Enter Priority (High/Medium/Low): ");
                    String priority = sc.nextLine();
                    planner.addTask(id, subject, topic, date, priority);
                    break;
                }
                case 2: {
                    System.out.print("Enter Task ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Subject (leave blank to skip): ");
                    String subject = sc.nextLine();
                    System.out.print("Enter new Topic (leave blank to skip): ");
                    String topic = sc.nextLine();
                    System.out.print("Enter new Date (leave blank to skip): ");
                    String date = sc.nextLine();
                    System.out.print("Enter new Priority (leave blank to skip): ");
                    String priority = sc.nextLine();
                    planner.updateTask(id, subject, topic, date, priority);
                    break;
                }
                case 3: {
                    System.out.print("Enter Task ID to search: ");
                    int id = sc.nextInt();
                    planner.searchTask(id);
                    break;
                }
                case 4: {
                    System.out.print("Enter Task ID to mark completed: ");
                    int id = sc.nextInt();
                    planner.markCompleted(id);
                    break;
                }
                case 5: {
                    System.out.print("Enter Task ID to delete: ");
                    int id = sc.nextInt();
                    planner.deleteTask(id);
                    break;
                }
                case 6:
                    planner.displayAllTasks();
                    break;
                case 7:
                    planner.displayPendingTasks();
                    break;
                case 8:
                    System.out.println("Exiting Study Planner. Happy Studying!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        sc.close();
    }
}
