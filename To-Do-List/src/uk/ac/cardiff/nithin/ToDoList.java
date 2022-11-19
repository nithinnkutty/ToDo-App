package uk.ac.cardiff.nithin;

import uk.ac.cardiff.nithin.ToDoItem.ItemStatus;

import java.util.ArrayList;

/**
 * Holds the todo items for each todoList Object
 */
public class ToDoList {
    private String listName;
    private ArrayList<ToDoItem> toDoItems;

    public ToDoList(String listName) {
        this.listName = listName;
        this.toDoItems = new ArrayList<>();
    }

    public void addToDoItem(ToDoItem newItem) {
        this.toDoItems.add(newItem);
    }

    public void deleteToDoItem(int itemNum) {
        this.toDoItems.remove(itemNum);
    }

    public void changeItemStatus(int itemNum) {
        ToDoItem todoItem = toDoItems.get(itemNum);
        todoItem.setItemStatus(todoItem.getItemStatus() == ItemStatus.OPEN ? ItemStatus.COMPLETED : ItemStatus.OPEN);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        sb.append(listName.toUpperCase());
        sb.append("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        if (toDoItems.size() > 0) {
            sb.append("<<<<<<<<<<<< All Items >>>>>>>>>>>>\n");
            int count = 1;
            for (ToDoItem toDoItem : toDoItems) {
                sb.append("\t " + count + "  ").append(toDoItem.getItemDesc()).append("\n");
                count++;
            }
            sb.append("\n<<<<<<<<< Completed Items >>>>>>>>>\n");
            count = 0;
            for (ToDoItem toDoItem : toDoItems) {
                if (toDoItem.getItemStatus() == ItemStatus.COMPLETED) {
                    sb.append("\t").append(toDoItem.getItemDesc()).append("\n");
                    count++;
                }
            }
            if (count == 0) {
                sb.append("No completed items yet\n");
            }


        } else {
            sb.append("No items added to this List\n");
        }
        sb.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        return sb.toString();
    }

    public String getListName() {
        return listName;
    }

    public ArrayList<ToDoItem> getToDoItems() {
        return toDoItems;
    }

}
