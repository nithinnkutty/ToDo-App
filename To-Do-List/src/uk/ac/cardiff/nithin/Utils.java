package uk.ac.cardiff.nithin;

public class Utils {
    public static void addDefaultEntries(ToDoApp toDoApp){
        ToDoList defaultList1 = new ToDoList("list1");
        ToDoList defaultList2 = new ToDoList("list2");

        ToDoItem toDoItem1 = new ToDoItem("item1");
        ToDoItem toDoItem2 = new ToDoItem("item2");

        defaultList1.addToDoItem(toDoItem1);
        defaultList1.addToDoItem(toDoItem2);
        defaultList2.addToDoItem(toDoItem1);
        defaultList2.addToDoItem(toDoItem2);

        toDoApp.createToDo(defaultList1);
        toDoApp.createToDo(defaultList2);
    }

    public static void printAllToDoListNames(ToDoApp toDoApp){
        System.out.println("\n ............ All to do lists................. ");
        System.out.println("\n\t\tIndex No:\t To Do List Items");

        int index = 1;
        for (ToDoList toDoList: toDoApp.getToDoLists()) {
            System.out.println( "\t\t"+ (index) + "\t\t\t " + toDoList.getListName());
            index++;
        }
        System.out.println("\n..............................................");
    }

    public static void printExternalMenu() {
        System.out.println("\nChoose an option:\n");
        System.out.println("\t\tPress [1] : Show All Lists");
        System.out.println("\t\tPress [2] : Create List");
        System.out.println("\t\tPress [3] : View List");
        System.out.println("\t\tPress [4] : Modify List");
        System.out.println("\t\tPress [5] : Delete List");
        System.out.println("\t\tPress [0] : Exit");
        System.out.println();
    }

    public static void printModifyListOptions() {
        System.out.println("\nChoose an option: \n");
        System.out.println("\t\tPress [1] : Add item");
        System.out.println("\t\tPress [2] : Delete item");
        System.out.println("\t\tPress [3] : Change status");
        System.out.println("\t\tPress [0] : Back to main menu");
    }
    public static void printInvalidMessage() {
        System.err.println("\t\t>>>>> Invalid Entry  <<<<<");
        System.err.println("\t Please enter a valid entry");
    }
}
