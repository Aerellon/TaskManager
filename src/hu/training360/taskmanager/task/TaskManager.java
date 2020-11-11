package hu.training360.taskmanager.task;

import hu.training360.taskmanager.exception.TaskManagerException;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void createTask() {

        System.out.println("*** Create new task ***");

        System.out.println("user:");
        String user = scanner.next();

        System.out.println("description:");
        String description = scanner.next();

        System.out.println("hours to complete:");
        for(HoursToComplete item : HoursToComplete.values()) {
            System.out.println(item.ordinal() + " - " + item);
        }
        int index = scanner.nextInt();
        HoursToComplete hoursToComplete = HoursToComplete.values()[index];

        Task task = new Task(user, description, hoursToComplete);
        tasks.add(task);
    }

    public static void list() {

        System.out.println("*** Listing tasks ***");

        for (Task t : tasks) {
            System.out.println(tasks.indexOf(t) + ":" + t.toString());
        }
    }

    public static void listInProgress() {

        System.out.println("*** Tasks in progress ***");

        for (Task t : tasks) {
            if(t.getStatus() == Status.IN_PROGRESS) {
                System.out.println(tasks.indexOf(t) + ":" + t.toString());
            }
        }
    }

    public static void listDone() {

        System.out.println("*** Done tasks ***");

        for (Task t : tasks) {
            if(t.getStatus() == Status.DONE) {
                System.out.println(tasks.indexOf(t) + ":" + t.toString());
            }
        }
    }

    public static void listBlocked() {

        System.out.println("*** Blocked tasks ***");

        for (Task t : tasks) {
            if(t.getStatus() == Status.BLOCKED) {
                System.out.println(tasks.indexOf(t) + ":" + t.toString());
            }
        }
    }

    public static void listByUser() {

        System.out.println("User:");
        String user = scanner.next();

        System.out.println("*** " + user + "'s tasks ***");

        for (Task t : tasks) {
            if (t.getUser().equals(user)) {
                System.out.println(t.toString());
            }
        }
    }

    public static void setStatusToDone() {

        System.out.println("Task:");
        int index = scanner.nextInt();

        try {
            tasks.get(index).setStatusToDone();
        } catch (TaskManagerException e) {
            System.out.println(e.getErrorCode());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }
    }

    public static void setStatusToInProgress() {

        System.out.println("Task:");
        int index = scanner.nextInt();

        try {
            tasks.get(index).setStatusToInProgress();
        } catch (TaskManagerException e) {
            System.out.println(e.getErrorCode());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }
    }

    public static void setStatusToBlocked() {

        System.out.println("Task:");
        int index = scanner.nextInt();

        try {
            tasks.get(index).setStatusToBlocked();
        } catch (TaskManagerException e) {
            System.out.println(e.getErrorCode());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete() {

        System.out.println("index:");
        int index = scanner.nextInt();

        tasks.remove(index);
    }
}
