package chapter15.todo.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task implements Comparable<Task> {

    private int priority;
    private String content;

    @Override
    public String toString() {
        return "Task [priority=" + priority + ", content=" + content + "]";
    }

    @Override
    public int compareTo(Task other) {
        int priorityCompare = this.priority - other.priority;
        if (priorityCompare != 0) {
            return priorityCompare;
        }

        return this.content.compareTo(other.content);
    }
}
