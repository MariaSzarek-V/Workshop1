package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;


public class TaskManager {

    public static void main(String[] args) {
        String option;
        String[] options = {"add", "remove", "list", "exit"};
        Path path = Paths.get("tasks.csv");
        String lastTaskNumber = null;
        String[][] tasksSplitArr;

        if (Files.exists(path)) {
            try {
                String line = Files.readString(path);
                String[] eachTask = line.split("\n");
                tasksSplitArr = new String[eachTask.length][];
                for (int i = 0; i < eachTask.length; i++) {
                    tasksSplitArr[i] = eachTask[i].split("\\s*:\\s*|\\s*,\\s*");
                }
                lastTaskNumber = tasksSplitArr[eachTask.length - 1][0].trim();
                System.out.println(lastTaskNumber);
                for (int i = 0; i < tasksSplitArr.length; i++) {
                    for (int j = 0; j < tasksSplitArr[i].length; j++) {
                        System.out.print(tasksSplitArr[i][j] + " ");
                    }
                    System.out.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
                tasksSplitArr = new String[0][0];
            }
        } else {
            System.out.println("File not found");
            tasksSplitArr = new String[0][];
        }

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(ConsoleColors.BLUE);
            System.out.println("Please select an option:" + ConsoleColors.RESET);
            for (String opt : options) {
                System.out.println(opt);
            }
            option = scanner.nextLine();

            switch (option) {
                case "add":
                    int numberInt = Integer.parseInt(lastTaskNumber) + 1;
                    lastTaskNumber = String.valueOf(numberInt);
                    System.out.println("Add task");
                    System.out.println("Please add task description");
                    String description = scanner.nextLine();
                    System.out.println("Please add task due date");
                    String dueDate = scanner.nextLine();
                    System.out.println("Is your task is important: " + ConsoleColors.RED + "true/false?" + ConsoleColors.RESET);
                    String isImportant = scanner.nextLine();
                    while (!isImportant.equalsIgnoreCase("true") && !isImportant.equalsIgnoreCase("false")) {
                        System.out.println("Incorrect input.\nIs your task important: " + ConsoleColors.RED + "true/false?" + ConsoleColors.RESET);
                        isImportant = scanner.nextLine();
                    }
                    System.out.print(ConsoleColors.RESET);
                    String[] oneTask = {lastTaskNumber, description, dueDate, isImportant};
                    System.out.println(Arrays.toString(oneTask));
                    System.out.println(lastTaskNumber + " " + description + " " + dueDate + " " + isImportant);
                    tasksSplitArr = Arrays.copyOf(tasksSplitArr, tasksSplitArr.length + 1);
                    tasksSplitArr[tasksSplitArr.length - 1] = oneTask;
                    break;

                case "remove":
                    System.out.println("Please select number to remove task");
                    String numberToRemove = null;
                    while (true) {
                        numberToRemove = scanner.nextLine();
                        try {
                            int number = Integer.parseInt(numberToRemove);
                            int lastNumber = Integer.parseInt(lastTaskNumber);
                            if (number <= lastNumber && number >= 0) {
                                break;
                            } else {
                                System.out.println("Please input a valid number from range 0 to " + (lastTaskNumber));
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please input a valid number from range 0 to " + (lastTaskNumber));
                        }
                    }
                    for (int i = 0; i < tasksSplitArr.length; i++) {
                        for (int j = 0; j < tasksSplitArr[i].length; j++) {
                            if (tasksSplitArr[i][0].equals(numberToRemove)) {
                                System.out.println("Task " + numberToRemove + " was successfully deleted.");
                                tasksSplitArr = ArrayUtils.remove(tasksSplitArr, i);
                                break;
                            }
                        }

                    }

                    break;
                case "list":
                    System.out.println("Tasks on list:");
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < tasksSplitArr.length; i++) {
                        sb.append(tasksSplitArr[i][0]).append(" : ");
                        for (int j = 1; j < tasksSplitArr[i].length; j++) {

                            if (tasksSplitArr[i][j].equalsIgnoreCase("true") || tasksSplitArr[i][j].equalsIgnoreCase("false")) {
                                sb.append(ConsoleColors.RED + tasksSplitArr[i][j] + ConsoleColors.RESET);
                            } else {
                                sb.append(tasksSplitArr[i][j]).append(" ");
                            }
                        }
                        sb.append("\n");
                    }
                    System.out.println(sb.toString());
                    break;

                case "exit":
                    StringBuilder sbToFile = new StringBuilder();
                    for (int i = 0; i < tasksSplitArr.length; i++) {
                        for (int j = 0; j < tasksSplitArr[i].length; j++) {
                            if (j == 0) {
                                sbToFile.append(String.valueOf(i) + " : ");
                            } else if (j == tasksSplitArr[i].length - 1) {
                                sbToFile.append(tasksSplitArr[i][j]);
                            } else {
                                sbToFile.append(tasksSplitArr[i][j]).append(", ");
                            }
                        }
                        sbToFile.append("\n");
                    }

                    try {
                        Files.writeString(path, sbToFile.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ConsoleColors.RED + "Bye, bye!");
                    break;
                default:
                    System.out.println("Provided incorrect option.");
            }
        } while (!option.equals("exit"));
    }
}




