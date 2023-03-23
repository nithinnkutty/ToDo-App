package uk.ac.cardiff.ToDoApp.main;

public interface ToDo {
    void createToDoList(String listName);
    void deleteToDoList(int listNum);
    String viewToDoList(int listNum);
    void addToDoItem(int listNum, String taskItem);
    void deleteToDoItem(int listNum, int itemNum);
    void changeItemStatus(int listNum, int itemNum);
    boolean isValidList(int listNum);
    boolean isValidItem(int listNum, int itemNum);
    boolean isValidString(String name);
}
