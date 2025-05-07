package chapter15.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

// Receiver
public class TaskManager {
    private TreeSet<Task> tasks = new TreeSet<Task>();

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Adding task: " + task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        System.out.println("Removing task: " + task);
    }

    public void listTasks() {

            System.out.println("\n=====할 일 목록=====\n");

            if(tasks.isEmpty()) {
                System.out.println("등록된 할 일이 업습니다.....");
                return;
            }

            int index = 1;
            for (Task t : tasks) {
                System.out.println(index++ + "." + t);
            }

    }

    public List<Task> getTasksAsList() {
        return new ArrayList<>(tasks);
    }
}
