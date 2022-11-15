package uk.ac.cardiff.nithin;

class ToDoItem {
     private String task;
     private ItemStatus status;
    public ToDoItem(String task) {
        this.task = task;
        this.status = ItemStatus.OPEN;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ToDoItem{");
        sb.append("task='").append(task).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }


    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }
    public enum ItemStatus {
        OPEN,
        COMPLETED;
    }

}
