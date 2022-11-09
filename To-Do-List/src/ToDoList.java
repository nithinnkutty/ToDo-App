
import java.util.ArrayList;
import java.util.Scanner;


public class ToDoList {

    String List_Name ;
    ArrayList<ToDoItem> toDoItems =   new ArrayList<>();

    public ToDoList(int def) {
        // Create default to-do-list Item when todoList object is created
        this.List_Name = "Default To-Do-List " + def;
        this.addDefaultTasks();

    }

    public ToDoList(String item_Name) {
        this.List_Name = item_Name;
        this.addToDoItem();
    }

    public void addDefaultTasks(){

        int default_taskNum = 2;                        // creates 2 default tasks when a ToDoList Item is created.
        for(int i = 1; i <= default_taskNum; i++){
            toDoItems.add(new ToDoItem());
        }
    }
    public void addToDoItem(ToDoItem newItem){
//        Scanner s = new Scanner(System.in);
//
//        System.out.println("\n\tAdd tasks to the list : "+ List_Name);
//        System.out.println("-------------------------------------------");
//
//        while(true){
//            ToDoItem task = new ToDoItem();
//
//            task.setTask();
//            task.setStatus();
//            toDoItems.add(task);
//
//            System.out.println("\nPress: [0] To continue adding task \nPress: [1] To Quit");
//            if(s.hasNextInt()){
//                int input = s.nextInt();
//
//                if(input == 0){
//                    continue;
//                } else if (input == 1) {
//                    System.out.println("Added "+ toDoItems.size()+" tasks to list :"+ List_Name);
//                    break;
//                } else{
//                    System.err.println("Enter an Integer value from options");
//                    continue;
//                }
//
//            }else {
//                System.err.println("Enter an Integer value from options");
//                continue;
//            }
//        }
    }

    public String getItem_Name() {
        return List_Name;
    }



    public void print_tasks(){
        for (int i = 1; i <= toDoItems.size(); i++) {
            System.out.println("\t\t" + i +" "+ toDoItems.get(i-1).toString());
        }
    }

    public void modifyTask(){

        print_tasks();

        System.out.println("Select the Below Modify tasks Options to Continue");
        System.out.println("[1] Add task\t\t [2] Update task status");

        Scanner s = new Scanner(System.in);
        if(s.hasNextInt()){

            int modifyOption = s.nextInt();
            if(modifyOption == 1){

                //Creating new task to append into and existing to-do-List Item
                ToDoItem task = new ToDoItem();

                task.setTask();
                task.setStatus();
                toDoItems.add(task);

            }else if (modifyOption ==2) {

                //Code to update the status of Task for an individual task
                System.out.println("Enter task number to Modify Status");
                if(s.hasNextInt()){
                    int input  = s.nextInt();
                    if(input <= toDoItems.size() && input != 0  ){
                        toDoItems.get(input-1).setStatus();
                    }
                }

            }else {
                System.out.println("Wrong Entry");
            }

        }else {
            System.out.println("Wrong Entry");
        }
    }
}
