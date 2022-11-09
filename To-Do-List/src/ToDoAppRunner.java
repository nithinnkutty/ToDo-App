import java.util.Scanner;

public class ToDoAppRunner {


    public static void main(String[] args) {
        ToDoApp toDoApp = new ToDoApp();
        ToDoList defaultList1 = new ToDoList("Default List 1");
        ToDoItem toDoItem1 = new ToDoItem("Item 1");
        ToDoItem toDoItem2 = new ToDoItem("Item 2");

        defaultList1.addToDoItem(toDoItem1);
        defaultList1.addToDoItem(toDoItem2);

        toDoApp.addToDoList(defaultList1);

        try {
            //Prints exiting To Do Lists to the console.
            toDoApp.printAllItems();

            // Starts the loop to View/Edit/Create To do Lists.
            while (true) {

                //Displays menu to select options
                System.out.println("\nSelect any option from Menu\n");
                System.out.println("\t\tPress [1] : Create New To-Do-List");
                System.out.println("\t\tPress [2] : Inspect To-Do-List");
                System.out.println("\t\tPress [3] : Edit To-Do-List");
                System.out.println("\t\tPress [0] : Terminate Program");
                System.out.println();

                Scanner s = new Scanner(System.in);
                if (s.hasNextInt()) {
                    int input = s.nextInt();

                    switch (input) {
                        case 1:
                            System.out.println("Enter To-Do-List Name ");
                            String listName = s.nextLine();
                            ToDoList newList = new ToDoList();
                            toDoApp.addToDoList();
                            toDoApp.printAllItems();
                            break;
                        case 2:
                            toDoApp.viewItem();
                            break;
                        case 3:
                            toDoApp.editItem();
                            toDoApp.printAllItems();
                            break;
                        case 0:
                            System.out.println("\n\t\tExiting from To-Do Lists");
                            break;
                        default:
                            System.err.println("\t\t>>>>>  Invalid Entry  <<<<<");
                            System.err.println("\tEnter an Integer value from options ");
                    }
                } else {
                    System.err.println("\t\t>>>>>  Invalid Entry  <<<<<");
                    System.err.println("\t\t\t\tPlease Retry ");
                }

            }
        }
        catch (Exception e){
            System.err.println("\t\t Some Error Occured");
            System.err.println("\n\t\t\tPlease retry again");
        }
        finally {
            System.out.println("\n\t***************End****************");
        }

    }

}
