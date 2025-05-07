package chapter15.todo.command;

import chapter15.todo.service.Task;
import chapter15.todo.service.TaskManager;

import java.util.List;

public class DeleteTaskCommand implements Command {

    private TaskManager taskManager;
    private Task task;

    public DeleteTaskCommand(TaskManager taskManager, int index) {
        this.taskManager = taskManager;

        List<Task> tasks = taskManager.getTasksAsList();
        if (index >= 0 && index < tasks.size()) {
            this.task = tasks.get(index);
        } else {
            throw new IndexOutOfBoundsException("무효");
        }
    }

    @Override
    public void execute() {
        taskManager.removeTask(task);

    }

    @Override
    public void undo() {
        taskManager.addTask(task);
        System.out.print("할 일 삭제가 취소되었습니다");
    }
}
