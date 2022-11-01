import java.util.Scanner;

class Task {
     String task ="";
     String status = "";

    public Task(String task) {
        this.task = task;
        this.status = "closed";
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
        System.out.println("Enter status of the task");
        System.out.println("[1] In Progress \t\t[2] On Hold\t\t[3] Closed");
        Scanner s = new Scanner(System.in);

        if (s.hasNextInt()) {

            int input = s.nextInt();
            if (input == 1) {
                this.status = "In Progress";
            } else if (input == 2) {
                this.status = "On Hold";
            } else if (input == 3) {
                this.status = "Closed";
            } else {
                System.out.println("Wrong Entry");
            }

        } else {
            System.out.println("Wrong Entry");
        }
    }

    @Override
    public String toString() {
        return  task  + " \t\tStatus = " + status ;
    }
}
