import java.util.Scanner;

class ToDoItem {
     private String task;
     private String status;

    public ToDoItem() {
        this.task   = "Default Task";
        this.status = "Closed";
    }
//    public Task(int num) {
//        setTask();
//        setStatus();
//    }

    public ToDoItem(String task) {
        this.task = task;
        setStatus();
    }

    public String getTask() {
        return task;
    }

    public String getStatus() {
        return status;
    }

    public void setTask() {
        Scanner s = new Scanner(System.in);
        System.out.println("\nEnter a task to add in the List");
        this.task = s.nextLine();

    }

    public void setStatus() {
        //Method here is to change the task status inside a To-Do-List



        System.out.println("\nEnter status of the task ");

        while(true){

            System.out.println("\n\t\t[1] In Progress\n\t\t[2] On Hold\n\t\t[3] Completed");
            Scanner s = new Scanner(System.in);

            if (s.hasNextInt()) {

                int input = s.nextInt();

                if (input == 1) {
                    this.status = "In Progress";
                    System.out.println("\n===========Status set to: In Progress==========");
                    break;
                } else if (input == 2) {
                    this.status = "On Hold";
                    System.out.println("\n===========Status set to: On-Hold==========");
                    break;
                } else if (input == 3) {
                    this.status = "Completed";
                    System.out.println("\n===========Status set to: Completed==========");
                    break;
                }else {
                    System.err.println("\t\t>>>>>  Invalid Entry  <<<<<");
                    System.err.println("  Enter an Integer value from options ");
                    continue;
                }
            }else {
                System.err.println("\t\t>>>>>  Invalid Entry  <<<<<");
                System.err.println("\t\t\t\tPlease Retry ");
                continue;
            }

        }
    }

    @Override
    public String toString() {
        return  task +"\n\t\t\t\tStatus : "+ status  ;
    }
}
