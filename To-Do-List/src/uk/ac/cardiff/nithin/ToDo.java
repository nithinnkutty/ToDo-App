package uk.ac.cardiff.nithin;

public interface ToDo {
    void createToDo(ToDoList newList);
    void deleteToDo(int listNum);

    boolean isValidList(int listNum);

    void addToDoItem(int listNum, String taskItem);
    void deleteToDoItem(int listNum, int itemNum);
    void changeItemStatus(int listNum, int itemNum);

    boolean isValidItem(int listNum, int itemNum);

}
