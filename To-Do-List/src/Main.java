import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        ToDoList newList = new ToDoList();
        Scanner s =  new Scanner(System.in);
        try {
            //Prints exiting To Do Lists to the console.
            newList.printAllItems();

            // Starts the loop to View/Edit/Create To do Lists.
            while(true){

                //Displays menu to select options
                System.out.println("\nSelect any option from Menu\n");
                System.out.println("\t\tPress [1] : Create New To-Do-List");
                System.out.println("\t\tPress [2] : Inspect To-Do-List");
                System.out.println("\t\tPress [3] : Edit To-Do-List");
                System.out.println("\t\tPress [0] : Terminate Program");
                System.out.println();


                if(s.hasNextInt()) {
                    int input = s.nextInt();
                    if (input == 1 || input == 2 || input == 3 || input == 0) {


                        if (input == 1) {
                            newList.createItem();                  //Method calls To Create new to-Do List Item.
                            newList.printAllItems();

                        } else if (input == 2) {
                            newList.viewItem();                     //Method calls To Inspect a to-Do List Item.
                            newList.printAllItems();

                        } else if (input == 3) {
                            newList.editItem();                     //Method calls To Edit Item.
                            newList.printAllItems();

                        } else if (input == 0) {
                            System.out.println("\n\t\tExiting from To-Do Lists");
                            break;
                        } else {
                            System.out.println("Wrong Selection");

                        }
                    }
                }else {
                    System.out.println("Wrong Selection");
                    break;
                }
            }

        }
        catch (Exception e){
            System.out.println("\n\t\tError...Please retry");
        }
        finally {
            System.out.println("\n\t***************End****************");
        }

    }

}
