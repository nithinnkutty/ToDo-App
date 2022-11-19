package uk.ac.cardiff.nithin;

public class Utils {
    public static void addDefaultEntries(ToDoApp toDoApp) {
        ToDoList defaultToDoList1 = new ToDoList("Daily Planner");
        ToDoList defaultToDoList2 = new ToDoList("To Do List for study");

        ToDoItem defaultToDoList1Item1 = new ToDoItem("Wake up at 6");
        ToDoItem defaultToDoList1Item2 = new ToDoItem("Read a Book");
        ToDoItem defaultToDoList2Item1 = new ToDoItem("Complete Java Assignment");
        ToDoItem defaultToDoList2Item2 = new ToDoItem("Complete Web applications exercises");

        defaultToDoList1.getToDoItems().add(defaultToDoList1Item1);
        defaultToDoList1.getToDoItems().add(defaultToDoList1Item2);
        defaultToDoList2.getToDoItems().add(defaultToDoList2Item1);
        defaultToDoList2.getToDoItems().add(defaultToDoList2Item2);

        toDoApp.getToDoLists().add(defaultToDoList1);
        toDoApp.getToDoLists().add(defaultToDoList2);
    }

    public static void printAllToDoListNames(ToDoApp toDoApp) {
        System.out.println("\n...............All to do lists.................");
        System.out.println("\n\t\tIndex No:\t To Do List");

        int index = 1;
        for (ToDoList toDoList : toDoApp.getToDoLists()) {
            System.out.println("\t\t" + (index) + "\t\t\t " + toDoList.getListName());
            index++;
        }
        System.out.println("\n...............................................");
    }

    public static void printExternalMenu() {
        System.out.println("\n-------------------Main Menu-------------------");
        System.out.println("\nChoose a number option:\n");
        System.out.println("\t\t [1] : Show All Lists");
        System.out.println("\t\t [2] : Create List");
        System.out.println("\t\t [3] : View List");
        System.out.println("\t\t [4] : Modify List");
        System.out.println("\t\t [5] : Delete List");
        System.out.println("\t\t [0] : Exit");
        System.out.println("\n-----------------------------------------------");
    }

    public static void printModifyListOptions(ToDoApp toDoApp, int listNum) {
        System.out.println("\n---------------Modify " + toDoApp.getToDoLists().get(listNum).getListName() + "----------------");
        System.out.println("\nChoose a number option: \n");
        System.out.println("\t\t [1] : Add item");
        System.out.println("\t\t [2] : Delete item");
        System.out.println("\t\t [3] : Change status");
        System.out.println("\t\t [0] : Back to main menu");
        System.out.println("\n-----------------------------------------------");
    }

    public static void printAddItemsOptions(ToDoApp toDoApp, int listNum) {
        System.out.println("\n-------Add Items to " + toDoApp.getToDoLists().get(listNum).getListName() + "-------");
        System.out.println("\nChoose a number option: \n");
        System.out.println("\t\t [1] : Add item");
        System.out.println("\t\t [0] : Back to main menu");
        System.out.println("\n-----------------------------------------------");
    }

    public static void printInvalidMessage() {
        System.err.println("\t\t>>>>> Invalid Entry  <<<<<");
        System.err.println("\t\tPlease enter a valid entry");
    }
}
