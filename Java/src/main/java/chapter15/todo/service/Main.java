package chapter15.todo.service;

import chapter15.todo.command.AddTaskCommand;
import chapter15.todo.command.Command;
import chapter15.todo.command.CommandInvoker;
import chapter15.todo.command.DeleteTaskCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    // Recevier
    private static TaskManager taskManager = new TaskManager();

    // Invoker
    private static CommandInvoker invoker = new CommandInvoker();


    // 명령어와 실행 로직을 매핑하는 Map
    private static Map<Pattern, Consumer<String>> commandHandlers = new HashMap<>();

    // static 초기화 블럭
    static {
        // 입력된 값이 "exit"와 일치하다면
        commandHandlers.put(Pattern.compile("^exit$"), (input) -> {
            System.out.println("프로그램을 종료합니다.");
            scanner.close();
            System.exit(0);
        });

        commandHandlers.put(Pattern.compile("^todo list$"), (input) -> {
            taskManager.listTasks();
        });

        commandHandlers.put(Pattern.compile("^todo undo$"), (input) -> {
            invoker.undoLastCommand();
        });

        commandHandlers.put(Pattern.compile("^todo add .*"), (input) -> {
            processAddCommand(input);
        });

        commandHandlers.put(Pattern.compile("^todo del .*"), (input) -> {
            processDeleteCommand(input);
        });

    }


    private static void processAddCommand(String input) {
        // "todo add <우선순위> <할일내용>" 파싱
        String[] parts = input.split(" ", 4);
        if (parts.length < 4) {
            System.out.println("명령어 형식이 잘못되었습니다. 사용법: todo add <우선순위(1-5)> <할일내용>");
            return;
        }

        try {
            int priority = Integer.parseInt(parts[2]);
            if (priority < 1 || priority > 5) {
                System.out.println("우선순위는 1부터 5까지의 숫자여야 합니다.");
                return;
            }

            String content = parts[3];
            Command addCommand = new AddTaskCommand(taskManager, priority, content);
            invoker.executeCommand(addCommand);
        } catch (NumberFormatException e) {
            System.out.println("우선순위는 숫자여야 합니다.");
        }
    }

    private static void processDeleteCommand(String input) {
        // "todo del <번호>" 파싱
        String[] parts = input.split(" ", 3);
        if (parts.length < 3) {
            System.out.println("명령어 형식이 잘못되었습니다. 사용법: todo del <번호>");
            return;
        }

        try {
            int index = Integer.parseInt(parts[2]) - 1; // 1부터 시작하는 번호를 0부터 시작하는 인덱스로 변환
            Command deleteCommand = new DeleteTaskCommand(taskManager, index);
            invoker.executeCommand(deleteCommand);
        } catch (NumberFormatException e) {
            System.out.println("삭제할 항목 번호는 숫자여야 합니다.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("===== 할 일 관리 시스템(CMD) =====");
        System.out.println("추가 : todo add <우선순위(1~5)> <할일내용>");
        System.out.println("삭제 : todo del <번호>");
        System.out.println("목록 : todo list");
        System.out.println("실행 취소 : todo undo");
        System.out.println("종료 : exit");

        while (true) {
            System.out.println("\n명령어 입력 : ");
            String input = scanner.nextLine();
            try {

                boolean commandFound = false;


                for (Map.Entry<Pattern, Consumer<String>> entry : commandHandlers.entrySet()) {
                    if (entry.getKey().matcher(input).matches()) {
                        entry.getValue().accept(input);
                        commandFound = true;
                        break;

                    }
                }

                if (!commandFound) {
                    System.out.println("알수없는명령어입니다지원하는명령어를입력해라주세요");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
