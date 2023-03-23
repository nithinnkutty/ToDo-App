package uk.ac.cardiff.ToDoApp.main;

import java.util.ArrayList;

/**
 * Holds all the to-do Lists
 * <p> Holds all the Major functionalities to manipulate list and list items
 */
public class ToDoApp implements ToDo {
    private final ArrayList<ToDoList> toDoLists;

    public ToDoApp() {
        toDoLists = new ArrayList<>();
    }

    /**
     * creates new To-Do list with a list name and adds to toDolists arraylist
     *
     * @param listName - name of the list to be created.
     */
    @Override
    public void createToDoList(String listName) {
        if (isValidString(listName)) {
            toDoLists.add(new ToDoList(listName));
            System.out.println("Created new list :" + listName);
        } else {
            throw new IllegalArgumentException("Not a valid entry");
        }
    }

    /**
     * deletes To-Do list linked with list index number passed
     *
     * @param listNum - Index number of the list to be deleted
     */
    @Override
    public void deleteToDoList(int listNum) {
        if (isValidList(listNum)) {
            System.out.println(toDoLists.get(listNum).getListName() + " deleted");
            toDoLists.remove(toDoLists.get(listNum));
        } else {
            throw new IllegalArgumentException("Not a valid entry");
        }
    }

    /**
     * Shows To-Do list linked with list index number passed
     *
     * @param listNum - Index number of the list to be displayed
     */
    @Override
    public String viewToDoList(int listNum) {
        if (isValidList(listNum)) {
            return toDoLists.get(listNum).toString();
        } else {
            throw new IllegalArgumentException("Not a valid entry");
        }
    }

    /**
     * Adds new To-Do item to a list with a list index number and item description
     *
     * @param listNum  - Index number of the list to which the Item is added
     * @param itemDesc -  Item Description
     */
    @Override
    public void addToDoItem(int listNum, String itemDesc) {
        if (isValidList(listNum) && isValidString(itemDesc)) {
            toDoLists.get(listNum).addToDoItem(new ToDoItem(itemDesc));
            System.out.println("Added Item to list :" + toDoLists.get(listNum).getListName());
        } else {
            throw new IllegalArgumentException("Not a valid entry");
        }
    }

    /**
     * Deletes To-Do item from list with a list index number and item index number
     *
     * @param listNum - Index number of the list on which the Item is deleted
     * @param itemNum - Index number of the item on list to be deleted
     */
    @Override
    public void deleteToDoItem(int listNum, int itemNum) {
        if (isValidItem(listNum, itemNum)) {
            System.out.println("Item \"" + toDoLists.get(listNum).getToDoItems().get(itemNum).getItemDesc() + "\" deleted");
            toDoLists.get(listNum).deleteToDoItem(itemNum);

        } else {
            throw new IllegalArgumentException("Not a valid entry to delete");
        }
    }

    /**
     * Changes status of an item in a list to 'COMPLETED' or 'OPEN' with a list index number and item index number
     */
    @Override
    public void changeItemStatus(int listNum, int itemNum) {
        if (isValidItem(listNum, itemNum)) {
            toDoLists.get(listNum).changeItemStatus(itemNum);
            System.out.println("Item status changed to :" + toDoLists.get(listNum).getToDoItems().get(itemNum).getItemStatus());
        } else {
            throw new IllegalArgumentException("Not a valid entry to change status");
        }
    }

    /* Returns true if item index number maps to any existing item object in toDoItems arraylist */
    @Override
    public boolean isValidItem(int listNum, int itemNum) {
        if (!isValidList(listNum)) return false;
        int listSize = toDoLists.get(listNum).getToDoItems().size();
        return itemNum >= 0 && itemNum < listSize;
    }

    /* Returns true if list index number maps to any existing to-do list object in toDoLists arraylist  */
    @Override
    public boolean isValidList(int listNum) {
        return listNum >= 0 && listNum < toDoLists.size();
    }

    /* Returns true if the list/item name is not null */
    @Override
    public boolean isValidString(String name) {
        return !name.equals("");
    }

    public ArrayList<ToDoList> getToDoLists() {
        return toDoLists;
    }

}
