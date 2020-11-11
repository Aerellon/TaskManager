package hu.training360.taskmanager.main;

import hu.training360.taskmanager.task.TaskManager;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleMenu consoleMenu = new ConsoleMenu(scanner);
        consoleMenu.add("New task", TaskManager::createTask);
        consoleMenu.add("List", TaskManager::list);
        consoleMenu.add("List by user", TaskManager::listByUser);
        consoleMenu.add("List tasks in progress", TaskManager::listInProgress);
        consoleMenu.add("List done tasks", TaskManager::listDone);
        consoleMenu.add("List blocked tasks", TaskManager::listBlocked);
        consoleMenu.add("Set status to 'IN_PROGRESS'", TaskManager::setStatusToInProgress);
        consoleMenu.add("Set status to 'DONE'", TaskManager::setStatusToDone);
        consoleMenu.add("Set status to 'BLOCKED'", TaskManager::setStatusToBlocked);
        consoleMenu.add("Delete", TaskManager::delete);
        consoleMenu.add("Exit", () -> System.exit(0));
        consoleMenu.show();
    }
}
