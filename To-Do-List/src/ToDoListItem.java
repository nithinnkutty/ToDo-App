
import java.util.ArrayList;
import java.util.Scanner;


public class ToDoListItem {

    String item_Name ;
    ArrayList<Task> tasks              =   new ArrayList<>();

    public ToDoListItem( int def) {
        // Create default to-do-list Item when todoList object is created
        this.item_Name = "Default Item " + def;
        this.addDefaultTasks();

    }

    public ToDoListItem(String item_Name) {
        this.item_Name = item_Name;
        this.addTasks();
    }

    public void addDefaultTasks(){

        int default_taskNum = 2;                        // creates 2 default tasks when a ToDoList Item is created.
        for(int i = 1; i <= default_taskNum; i++){
            tasks.add(new Task());
        }
    }
    public void addTasks(){
        Scanner s = new Scanner(System.in);

        System.out.println("Add tasks to the list : "+ item_Name);

        while(true){

            Task task = new Task();

            task.setTask();
            task.setStatus();
            tasks.add(task);

            System.out.println("Press [0] To continue adding tasks \tOR\t [1] to Finish");
            if(s.hasNextInt()){
                int input = s.nextInt();

                if(input == 0){
                    continue;
                } else if (input == 1) {
                    System.out.println("Added "+tasks.size()+" tasks to list :"+ item_Name);
                    break;
                } else{
                    System.out.println("Wrong Selection");
                }

            }else {
                System.out.println("Wrong Selection");
            }
        }
    }

    public String getItem_Name() {
        return item_Name;
    }



    public void print_tasks(){
        for (int i = 1; i <= tasks.size(); i++) {
            System.out.println("\t\t" + i +" "+ tasks.get(i-1).toString());
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
                Task task = new Task();

                task.setTask();
                task.setStatus();
                tasks.add(task);

            }else if (modifyOption ==2) {

                //Code to update the status of Task for an individual task
                System.out.println("Enter task number to Modify Status");
                if(s.hasNextInt()){
                    int input  = s.nextInt();
                    if(input <= tasks.size() && input != 0  ){
                        tasks.get(input).setStatus();
                    }
                }

            }else {
                System.out.println("Wrong Entry");
            }

        }else {
            System.out.println("Wrong Entry");
        }
    }
    public int NoOfCmpltdTasks(){
        int count = 0;
        for(int i=0; i< tasks.size();i++){
            if(tasks.get(i).getStatus().equals("Completed")){
                count++;
            }
        }
        return count;
    }
}
