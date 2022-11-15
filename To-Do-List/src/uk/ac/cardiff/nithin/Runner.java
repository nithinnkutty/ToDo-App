package uk.ac.cardiff.nithin;

import java.util.Scanner;

public class Runner {
    public static ToDoApp toDoApp = new ToDoApp();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Utils.addDefaultEntries(toDoApp);
        int input = 1;
        do {
            Utils.printExternalMenu();
            try {
                input = Integer.parseInt(scanner.nextLine());
                switch (input) {
                    case 1:
                        Utils.printAllToDoListNames(toDoApp);
                        break;
                    case 2:
                        System.out.println("Enter list name: ");
                        String listName = scanner.nextLine();
                        toDoApp.createToDo(new ToDoList(listName));
                        System.out.println("Created new list " + listName);
                        Utils.printAllToDoListNames(toDoApp);
                        break;
                    case 3:
                        Utils.printAllToDoListNames(toDoApp);
                        System.out.println("Enter list number to inspect: ");
                        System.out.println(toDoApp.getToDoLists().get(retrieveListNumber()));
                        break;
                    case 4:
                        Utils.printAllToDoListNames(toDoApp);
                        System.out.println("Enter list number to modify: ");
                        modifyList(retrieveListNumber());
                        break;
                    case 5:
                        Utils.printAllToDoListNames(toDoApp);
                        System.out.println("Enter list number to delete: ");
                        toDoApp.deleteToDo(retrieveListNumber());
                        break;
                    case 0:
                        System.out.println("\n\t\t............Exiting from To-Do List App..........");
                        break;
                    default:
                        Utils.printInvalidMessage();
                }

            } catch (NumberFormatException e) {
                Utils.printInvalidMessage();
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (input != 0);
    }

    public static void modifyList(int listNum) {
        int input = 0;
        do {
            Utils.printModifyListOptions();
            try {
                input = Integer.parseInt(scanner.nextLine());
                switch (input) {
                    case 1:
                        System.out.println("Enter item name: ");
                        String itemName = scanner.nextLine();
                        toDoApp.addToDoItem(listNum, itemName);
                        break;
                    case 2:
                        System.out.println(toDoApp.getToDoLists().get(listNum));
                        System.out.println("Enter item number to delete: ");
                        int itemNum = retrieveItemNumber();
                        if (toDoApp.isValidItem(listNum, itemNum)) {
                            toDoApp.deleteToDoItem(listNum, itemNum);
                        } else {
                            Utils.printInvalidMessage();
                        }
                        break;
                    case 3:
                        System.out.println(toDoApp.getToDoLists().get(listNum));
                        System.out.println("Enter item number to change status: ");
                        itemNum = retrieveItemNumber();
                        if (toDoApp.isValidItem(listNum, itemNum)) {
                            toDoApp.changeItemStatus(listNum, itemNum);
                        } else {
                            Utils.printInvalidMessage();
                        }
                        break;
                    case 0:
                        break;
                    default:
                        Utils.printInvalidMessage();
                }
            } catch (Exception e) {
                Utils.printInvalidMessage();
            }
        } while (input != 0);

    }



    private static int retrieveItemNumber() {
        return Integer.parseInt(scanner.nextLine()) - 1;
    }

    private static int retrieveListNumber() {
        return Integer.parseInt(scanner.nextLine()) - 1;
    }
}
