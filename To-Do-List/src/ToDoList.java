import java.util.ArrayList;
import java.util.Scanner;


public class ToDoList{

    static int defaultItemsNum = 0;
    private ArrayList<ToDoListItem> toDoLists = new ArrayList<>();

    public ToDoList() {
        while(defaultItemsNum < 2){

            defaultItemsNum++;
            this.toDoLists.add(new ToDoListItem(defaultItemsNum));             // creates 2 default ToDoList Items when a ToDoList object is created.

        }
    }

    public void printAllItems(){

        System.out.println("\n\n *****TO-DO-LIST*****\n");
        System.out.println("\t\tItem No:\t To Do List Items\t\t No: of tasks \t Completed tasks\n");
        for ( int i = 0; i < toDoLists.size(); i++) {
            System.out.print( "\t\t"+ (i+1) + "\t\t\t " + toDoLists.get(i).getItem_Name());
            System.out.print("\t\t\t " + toDoLists.get(i).tasks.size());
            System.out.println("\t\t\t\t " + toDoLists.get(i).NoOfCmpltdTasks());
        }
    }
    public void createItem(){

        if(defaultItemsNum == 2){
            toDoLists.clear();
            defaultItemsNum = 0;
        }
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Item Name ");
        String item_Name = s.nextLine();
        toDoLists.add(new ToDoListItem(item_Name));

    }
    public void viewItem(){
        int itemNum;
        Scanner s =  new Scanner(System.in);
        System.out.println("Enter Item Number to View");

        if(s.hasNextInt()){
            itemNum = s.nextInt();
            if(itemNum <= toDoLists.size() && itemNum!= 0) {

                System.out.println("To Do List Name : " + toDoLists.get(itemNum - 1).getItem_Name());
                System.out.println("Tasks to Complete: ");
                toDoLists.get(itemNum - 1).print_tasks();
            }else {
                System.out.println("Wrong Entry");
            }
        }else {
            System.out.println("Wrong Entry");
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
                System.out.println("Wrong Entry");
            }
        }else {
            System.out.println("Wrong Entry");
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
