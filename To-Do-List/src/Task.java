import java.util.Scanner;

class Task {
     private String task;
     private String status;

    public Task() {
        this.task   = "Default Task";
        this.status = "Closed";
    }
//    public Task(int num) {
//        setTask();
//        setStatus();
//    }

    public Task(String task) {
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
        System.out.println("Write task to add in the List");
        this.task = s.nextLine();

    }

    public void setStatus() {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter status of the task ");
        System.out.println("[1] Ongoing\t\t[2] On Hold\t\t[3] Closed");

        if (s.hasNextInt()) {

            int input = s.nextInt();

            if (input == 1) {
                this.status = "Ongoing";
                System.out.println("Status Updated to Ongoing");
            } else if (input == 2) {
                this.status = "On Hold";
                System.out.println("Status Updated to On-Hold");
            } else if (input == 3) {
                this.status = "Completed";
                System.out.println("Status Updated to Completed");
            } else {
                System.out.println("Wrong Entry");
            }

        } else {
            System.out.println("Wrong Entry");
        }
    }

    @Override
    public String toString() {
        return  task +"\n\t\t\t\tStatus : "+ status  ;
    }
}
