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
                System.out.print("[1] Create");
                System.out.print("\t\t[2] View");
                System.out.print("\t\t[3] Edit");
                System.out.print("\t\t[0] Terminate");
                System.out.println();


                if(s.hasNextInt()) {
                    int input = s.nextInt();
                    if (input == 1 || input == 2 || input == 3 || input == 0) {


                        if (input == 1) {
                            newList.createItem();                  //Method calls To Create new to-Do List Item.
                            newList.printAllItems();
                            continue;
                        } else if (input == 2) {
                            newList.viewItem();                     //Method calls To Inspect a to-Do List Item.
                            continue;
                        } else if (input == 3) {
                            newList.editItem();                     //Method calls To Edit Item.
                            newList.printAllItems();
                            continue;
                        } else if (input == 0) {
                            System.out.println("Exiting from To-Do Lists");
                            break;
                        } else {
                            System.out.println("Wrong Selection");
                            continue;
                        }
                    }
                }else {
                    System.out.println("Wrong Selection");
                    break;
                }
            }

        }
        catch (Exception e){
            System.out.println("Error...Please retry");
        }
        finally {
            System.out.println("**************End***************");
        }

    }

}
