import java.util.ArrayList;
import java.util.Scanner;


public class ToDoApp{

    static int defaultItemsNum = 0;
    private ArrayList<ToDoList> toDoLists = new ArrayList<>();

    public ToDoApp() {
        while(defaultItemsNum < 2){

            defaultItemsNum++;
            this.toDoLists.add(new ToDoList(defaultItemsNum));             // creates 2 default ToDoList Items when a ToDoList object is created.

        }
    }

    public void printAllItems(){

        System.out.println("\n ****************TO-DO-LISTS****************");
        System.out.println("\n\t\tItem No:\t To Do List Items");

        for ( int i = 0; i < toDoLists.size(); i++) {
            System.out.println( "\t\t"+ (i+1) + "\t\t\t " + toDoLists.get(i).getItem_Name());
        }
        System.out.println("\n ****************TO-DO-LISTS****************");
    }
    public void addToDoList(ToDoList newList){

        if(defaultItemsNum == 2){
            toDoLists.clear();
            defaultItemsNum = 0;
        }

        toDoLists.add(new ToDoList(item_Name));

    }
    public void viewItem(){
        //Call
        int itemNum;
        Scanner s =  new Scanner(System.in);
        System.out.println("Enter To-Do-List Item Number to View");

        while(true){
            if(s.hasNextInt()){
                itemNum = s.nextInt();
                if(itemNum <= toDoLists.size() && itemNum!= 0) {

                    System.out.println("----------------------------------------");
                    System.out.println("\tTo Do List Name : " + toDoLists.get(itemNum - 1).getItem_Name());
                    System.out.println("\n\tTasks to Complete: ");
                    toDoLists.get(itemNum - 1).print_tasks();
                    System.out.println("----------------------------------------");
                    break;
                }else {
                    System.err.print("\t\tError: Out of Bounds Exception");
                    System.err.println("\t\t\tPlease retry");
                    continue;
                }
            }else {
                System.err.println("\t\tPlease enter and Integer Value");
                continue;
            }
        }
    }

    public void editItem(){

        Scanner s =  new Scanner(System.in);

        System.out.println("Enter To-Do-List Item Number to Edit");

        if(s.hasNextInt()){
            int itemNum = s.nextInt();
            if(itemNum <= toDoLists.size() && itemNum!= 0) {

                //Calls private method to Delete or Modify the selected Item.
                deleteOrModify(itemNum);

            }else {
                System.err.println("Error: Out of Bounds Exception");
            }
        }else {
            System.out.println("Please enter and Integer Value");
        }

    }

    private void deleteOrModify(int itemNum) {
        Scanner s =  new Scanner(System.in);

        System.out.println("Select the Below Edit Options to Continue");
        System.out.println("[1] Delete Item\t\t [2] Modify Item");

        if(s.hasNextInt()) {

            int editOption = s.nextInt();
            if(editOption == 1){

                //Calling private method to Delete Item
                deleteItem(itemNum-1);              //itemNum -1 passes the Arraylist index of the selected Item

            }else if (editOption == 2) {

                //Calling private method to modify Item (Update task status / add new Task)
                modifyItem(itemNum-1);              //itemNum -1 passes the Arraylist index of the selected Item

            }else {
                System.out.println("Wrong Entry");
            }

        }else {
            System.out.println("Wrong Entry");
        }
    }

    private void modifyItem(int itemNum) {
        toDoLists.get(itemNum).modifyTask();
    }

    private void deleteItem(int itemNum) {
        toDoLists.remove(itemNum);
    }



}
