package uk.ac.cardiff.nithin;

import java.util.Scanner;

/**
 * Represents the runner for To Do List App
 * <p>Runner handles the toDoApp object, which holds all the to-do lists and list manipulation functionalities
 * such as Create new List, Inspect list, Modify list, Delete List and to Show all Lists.
 * <p>Runner handles the inputs from user and functions to direct user to desired To-Do app operation.
 *
 * @author Nithin Narayanan Kutty C22049299
 */
public class Runner {
    public static ToDoApp toDoApp = new ToDoApp();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Utils.addDefaultEntries(toDoApp);               //Creates two default list and default items in it
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
                        toDoApp.createToDoList(listName);
                        continueToAddItem(toDoApp.getToDoLists().size() - 1);
                        System.out.println("Items in the list " + listName + ": " + toDoApp.getToDoLists().get(toDoApp.getToDoLists().size() - 1).getToDoItems().size());
                        Utils.printAllToDoListNames(toDoApp);
                        break;
                    case 3:
                        Utils.printAllToDoListNames(toDoApp);
                        System.out.println("Enter list number to inspect: ");
                        System.out.println(toDoApp.viewToDoList(retrieveListNumber()));
                        break;
                    case 4:
                        Utils.printAllToDoListNames(toDoApp);
                        System.out.println("Enter list number to modify: ");
                        modifyList(retrieveListNumber());
                        break;
                    case 5:
                        Utils.printAllToDoListNames(toDoApp);
                        System.out.println("Enter list number to delete: ");
                        toDoApp.deleteToDoList(retrieveListNumber());
                        break;
                    case 0:
                        System.out.println("\n............Exiting from To-Do List App..........");
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

    /**
     * Allows the User to add Open Status List items to a newly created list repeatedly
     *
     * @param listNum Is the retrieved list number from retrieveListNumber()
     */
    private static void continueToAddItem(int listNum) {
        int input = 0;
        do {
            Utils.printAddItemsOptions(toDoApp, listNum);
            try {
                input = Integer.parseInt(scanner.nextLine());
                switch (input) {
                    case 1:
                        System.out.println("Enter item name: ");
                        String itemName = scanner.nextLine();
                        toDoApp.addToDoItem(listNum, itemName);
                        break;
                    case 0:
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

    /**
     * Allow user to modify (Add, delete & change status of an Item) the selected list
     *
     * @param listNum Is the retrieved list number from retrieveListNumber()
     */
    public static void modifyList(int listNum) {
        int input = 0;
        do {
            System.out.println(toDoApp.viewToDoList(listNum));
            Utils.printModifyListOptions(toDoApp, listNum);
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
                        toDoApp.deleteToDoItem(listNum, retrieveItemNumber());
                        break;
                    case 3:
                        System.out.println(toDoApp.getToDoLists().get(listNum));
                        System.out.println("Enter item number to change status: ");
                        toDoApp.changeItemStatus(listNum, retrieveItemNumber());
                        break;
                    case 0:
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

    /**
     * Retrieves the actual index of the selected item in the toDoItems arraylist from the user input
     */
    private static int retrieveItemNumber() {
        return Integer.parseInt(scanner.nextLine()) - 1;
    }

    /**
     * Retrieves the actual index of the selected list in the toDoLists arraylist from the user input
     */
    private static int retrieveListNumber() {
        return Integer.parseInt(scanner.nextLine()) - 1;
    }
}
