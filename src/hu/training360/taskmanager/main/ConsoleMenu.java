package hu.training360.taskmanager.main;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    private LinkedHashMap<String, Runnable> actionsMap = new LinkedHashMap<>();
    private Scanner scanner;

    public ConsoleMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void add(String name, Runnable action) {
        actionsMap.put(name, action);
    }

    public void show() {
        StringBuilder sb = new StringBuilder();
        List<String> actionNames = new ArrayList<>(actionsMap.keySet());
        for (int i = 0; i < actionNames.size(); i++) {
            sb.append(String.format(" %d: %s%n", i, actionNames.get(i)));
        }

        //noinspection InfiniteLoopStatement
        while (true) {
            System.out.println(sb.toString());
            int actionNumber = scanner.nextInt();
            List<Runnable> actions = new ArrayList<>(actionsMap.values());
            try {
                actions.get(actionNumber).run();
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("No such option\n");
            }
        }
    }
}
