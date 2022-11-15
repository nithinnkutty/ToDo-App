package uk.ac.cardiff.nithin;

import java.util.ArrayList;

//Holds all the todolists
public class ToDoApp implements ToDo{
    private ArrayList<ToDoList> toDoLists;

    public ToDoApp() {
        toDoLists = new ArrayList<>();
    }

    @Override
    public void createToDo(ToDoList newList) {
        toDoLists.add(newList);
    }

    @Override public void deleteToDo(int listNum) {
        toDoLists.remove(toDoLists.get(listNum));
    }




//    @Override
//    public ToDoList retrieveToDo(int listNum) {
//        for (ToDoList toDoList : toDoLists) {
//            if (toDoList.getListName().equals(listName)) {
//                return toDoList;
//            }
//        }
//        return null;
//    }

    @Override
    public void addToDoItem(int listNum, String taskItem) {
        toDoLists.get(listNum).addToDoItem(new ToDoItem(taskItem));
    }

    @Override
    public void deleteToDoItem(int listNum, int itemNum) {
        if(isValidItem(listNum, itemNum)) {
            toDoLists.get(listNum).deleteToDoItem(itemNum);
        } else {
            throw new IllegalArgumentException("Not a valid entry to delete");
        }
    }

    @Override
    public void changeItemStatus(int listNum, int itemNum) {
        toDoLists.get(listNum).changeItemStatus(itemNum);
    }

    @Override
    public boolean isValidItem(int listNum, int itemNum) {
        if (!isValidList(listNum))
            return false;

        int listSize = toDoLists.get(listNum).getToDoItems().size();
        return itemNum >= 0 && itemNum < listSize;
    }

    @Override
    public boolean isValidList(int listNum) {
        return listNum >= 0 && listNum < toDoLists.size();
    }

    public ArrayList<ToDoList> getToDoLists() {
        return toDoLists;
    }

}
