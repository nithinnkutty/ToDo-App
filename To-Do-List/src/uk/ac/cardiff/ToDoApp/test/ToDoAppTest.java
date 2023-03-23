package uk.ac.cardiff.ToDoApp.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import uk.ac.cardiff.ToDoApp.main.ToDoApp;
import uk.ac.cardiff.ToDoApp.main.ToDoItem;
import uk.ac.cardiff.ToDoApp.main.ToDoList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ToDoAppTest {
    private static ToDoApp testToDoApp;

    @BeforeAll
    public static void setupTest(){
        testToDoApp = new ToDoApp();
    }
    @Test
    void testForAddingNewToDoList(){
        testToDoApp.createToDoList("TestList1");
        assertEquals("TestList1", testToDoApp.getToDoLists().get(0).getListName());
    }
    @Test
    void testForDeletingToDoList(){
        testToDoApp.createToDoList("TestList2");
        System.out.println(testToDoApp.getToDoLists().size());
        testToDoApp.deleteToDoList(1);
        assertTrue(testToDoApp.getToDoLists().size()<2);
    }
    @Test
    void testForAddingInvalidToDoListName(){
        assertThrows(IllegalArgumentException.class,()-> testToDoApp.createToDoList(""));
    }
    @Test
    public void testForAddingToDoItem(){
        ToDoList testList =  new ToDoList("Test1");
        testList.addToDoItem(new ToDoItem("testItem1"));
        assertEquals("testItem1",testList.getToDoItems().get(0).getItemDesc());
    }

}
