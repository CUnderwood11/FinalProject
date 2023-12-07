import com.yourpackage.HibernateUtil;
import com.yourpackage.ToDoItem;
import com.yourpackage.ToDoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {

    private ToDoList toDoList;

    @BeforeEach
    public void setUp() {
        // Initialize ToDoList before each test
        toDoList = new ToDoList(HibernateUtil.getSessionFactory());
    }

    @Test
    public void testAddItem() {
        // Test adding an item to the to-do list
        toDoList.addItem("Test Item");

        // Retrieve all items and ensure the list is not empty
        assertFalse(toDoList.getAllItems().isEmpty(), "The to-do list should not be empty");

        // Retrieve the added item and check its description
        ToDoItem addedItem = toDoList.getAllItems().get(0);
        assertEquals("Test Item", addedItem.getDescription(), "The added item's description should match");

        // Additional assertions if needed
        // ...
    }

    @Test
    public void testDeleteItem() {
        // Add an item first
        toDoList.addItem("Test Item");

        // Get the list of items
        List<ToDoItem> itemsBeforeDeletion = toDoList.getAllItems();
        int initialSize = itemsBeforeDeletion.size();

        // Test deleting the item
        toDoList.deleteItem(1);

        // Ensure the to-do list is empty after deletion
        List<ToDoItem> itemsAfterDeletion = toDoList.getAllItems();
        int finalSize = itemsAfterDeletion.size();

        // Assert that the size decreased by 1
        assertEquals(initialSize - 1,finalSize);

    }
}