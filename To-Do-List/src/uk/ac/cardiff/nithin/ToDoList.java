package uk.ac.cardiff.nithin;

import uk.ac.cardiff.nithin.ToDoItem.ItemStatus;

import java.util.ArrayList;

public class ToDoList{
    private String listName ;
    private ArrayList<ToDoItem> toDoItems;

    public ToDoList(String listName) {
        this.listName = listName;
        this.toDoItems = new ArrayList<>();
    }

    public void addToDoItem(ToDoItem newItem){
        this.toDoItems.add(newItem);
    }

    public void deleteToDoItem(int itemNum) {
        this.toDoItems.remove(itemNum);
    }

    public void changeItemStatus(int itemNum){
        ToDoItem todoItem = toDoItems.get(itemNum);
        todoItem.setStatus(todoItem.getStatus() == ItemStatus.OPEN ? ItemStatus.COMPLETED : ItemStatus.OPEN);

//        if(todoItem.getStatus() == ItemStatus.OPEN) {
//            todoItem.setStatus(ItemStatus.COMPLETED);
//        } else {
//            todoItem.setStatus(ItemStatus.OPEN);
//        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(".................................\n");
        sb.append(listName.toUpperCase());
        sb.append("\n.................................\n");
        if(toDoItems.size()>0) {
            sb.append(" <<< Open Items >>>\n");
            for (ToDoItem toDoItem : this.toDoItems) {

                if (toDoItem.getStatus() == ItemStatus.OPEN) {
                    sb.append(toDoItem.getTask()).append("\n");
                }
            }
            sb.append(" <<< Closed Items >>>\n");
            for (ToDoItem toDoItem : this.toDoItems) {
                int count = 0;
                if (toDoItem.getStatus() == ItemStatus.COMPLETED) {
                    sb.append(toDoItem.getTask()).append("\n");
                }
            }
        }else {
            sb.append("No items added to this List\n");
        }
        sb.append(".................................");
        return sb.toString();
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public ArrayList<ToDoItem> getToDoItems() {
        return toDoItems;
    }

    public void setToDoItems(ArrayList<ToDoItem> toDoItems) {
        this.toDoItems = toDoItems;
    }
}
