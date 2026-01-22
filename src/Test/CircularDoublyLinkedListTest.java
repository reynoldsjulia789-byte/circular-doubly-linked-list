package Test;

import Main.CircularDoublyLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Circular Doubly Linked List
 * @author Julia Reynolds
 */
public class CircularDoublyLinkedListTest
{
    @Nested
    @DisplayName("Constructor Tests")
    class constructorTests
    {
        @Test
        @DisplayName("Can create empty list")
        public void emptyConstructor()
        {
            CircularDoublyLinkedList<String> testlist;

            testlist = new CircularDoublyLinkedList<>();

            assertEquals("[]", testlist.toString());
        }

        @Test
        @DisplayName("Can construct list with data")
        public void infiniteConstructor()
        {
            CircularDoublyLinkedList<Integer> testlist;

            testlist = new CircularDoublyLinkedList<>(1, 3, 4, 6, 8, 0);

            assertEquals("[1, 3, 4, 6, 8, 0]", testlist.toString());
        }
    }

    @Nested
    @DisplayName("addFirst Tests")
    class addFirstTests
    {
        @Test
        @DisplayName("Can add string elements")
        public void addsStringElements()
        {
            CircularDoublyLinkedList<String> testlist;

            testlist = new CircularDoublyLinkedList<>();

            testlist.addFirst("D");
            testlist.addFirst("C");
            testlist.addFirst("B");
            testlist.addFirst("A");

            assertEquals("[A, B, C, D]", testlist.toString());
        }

        @Test
        @DisplayName("Can add integer elements")
        public void addsIntegerElements()
        {
            CircularDoublyLinkedList<Integer> testlist;

            testlist = new CircularDoublyLinkedList<>();

            testlist.addFirst(3);
            testlist.addFirst(2);
            testlist.addFirst(1);

            assertEquals("[1, 2, 3]", testlist.toString());
        }

        @Test
        @DisplayName("add to preexisting list")
        public void addToList()
        {
            CircularDoublyLinkedList<Integer> testlist;

            testlist = new CircularDoublyLinkedList<>(4, 5, 6);

            testlist.addFirst(3);
            testlist.addFirst(2);
            testlist.addFirst(1);

            assertEquals("[1, 2, 3, 4, 5, 6]", testlist.toString());
        }
    }

    @Nested
    @DisplayName("add Tests")
    class addTests
    {
        @Test
        @DisplayName("Can add string elements")
        public void addsStringElements()
        {
            CircularDoublyLinkedList<String> testlist;

            testlist = new CircularDoublyLinkedList<>();

            testlist.add("A");
            testlist.add("B");
            testlist.add("C");
            testlist.add("D");

            assertEquals("[A, B, C, D]", testlist.toString());
        }

        @Test
        @DisplayName("Can add integer elements when there is a preexisting list")
        public void addsIntegerElements()
        {
            CircularDoublyLinkedList<Integer> testlist;

            testlist = new CircularDoublyLinkedList<>(1, 2, 3);

            testlist.add(4);
            testlist.add(5);
            testlist.add(6);

            assertEquals("[1, 2, 3, 4, 5, 6]", testlist.toString());
        }
    }

    @Nested
    @DisplayName("add at index Tests")
    class addIndexTests
    {
        @Test
        @DisplayName("can add in right half of list")
        public void addsAtIndexRight()
        {
            CircularDoublyLinkedList<Integer> testlist;

            testlist = new CircularDoublyLinkedList<>(0, 1, 2, 3, 5);

            testlist.add(4, 4);

            assertEquals("[0, 1, 2, 3, 4, 5]", testlist.toString());
        }

        @Test
        @DisplayName("can add in left half of list")
        public void addsAtIndexLeft()
        {
            CircularDoublyLinkedList<Integer> testlist;

            testlist = new CircularDoublyLinkedList<>(0, 2, 3, 4, 5);

            testlist.add(1, 1);

            assertEquals("[0, 1, 2, 3, 4, 5]", testlist.toString());
        }

        @Test
        @DisplayName("can add to empty list")
        public void addsToEmpty()
        {
            CircularDoublyLinkedList<String> testlist;

            testlist = new CircularDoublyLinkedList<>();

            testlist.add("new", 0);

            assertEquals("[new]", testlist.toString());
        }

        @Test
        @DisplayName("can add at beginning of list")
        public void addAtFront()
        {
            CircularDoublyLinkedList<Integer> testlist;

            testlist = new CircularDoublyLinkedList<>(1, 2, 3, 4, 5);

            testlist.add(0, 0);

            assertEquals("[0, 1, 2, 3, 4, 5]", testlist.toString());
        }

        @Test
        @DisplayName("can add at end of list")
        public void addAtEnd()
        {
            CircularDoublyLinkedList<Integer> testlist;

            testlist = new CircularDoublyLinkedList<>(0, 1, 2, 3, 4);

            testlist.add(5, 5);

            assertEquals("[0, 1, 2, 3, 4, 5]", testlist.toString());
        }
    }

    @Nested
    @DisplayName("remove data Tests")
    class removeDataTests
    {
        @Test
        @DisplayName("Successfully removes specified element")
        public void removeData()
        {
            CircularDoublyLinkedList<String> testlist;

            testlist = new CircularDoublyLinkedList<>("A", "B", "C", "D");

            testlist.removeData("C");

            assertEquals("[A, B, D]", testlist.toString());
        }

        @Test
        @DisplayName("Returns true when successful")
        public void removeDataTrue()
        {
            CircularDoublyLinkedList<String> testlist;

            testlist = new CircularDoublyLinkedList<>("A", "B", "C", "D");

            assertTrue(testlist.removeData("C"));
        }

        @Test
        @DisplayName("Returns false when object not found")
        public void removeDataFalse()
        {
            CircularDoublyLinkedList<String> testlist;

            testlist = new CircularDoublyLinkedList<>("A", "B", "C", "D");

            assertFalse(testlist.removeData("Z"));
        }

        @Test
        @DisplayName("Returns false if list is empty")
        public void removeDataEmptyList()
        {
            CircularDoublyLinkedList<String> testlist;

            testlist = new CircularDoublyLinkedList<>();

            assertFalse(testlist.removeData("Z"));
        }

        @Test
        @DisplayName("Removes element from end of list")
        public void removeDataEndOfList()
        {
            CircularDoublyLinkedList<String> testlist;

            testlist = new CircularDoublyLinkedList<>("A", "B", "C", "D");

            testlist.removeData("D");

            assertEquals("[A, B, C]", testlist.toString());
        }

        @Test
        @DisplayName("Removes element from beginning of list")
        public void removeDataBeginningOfList()
        {
            CircularDoublyLinkedList<String> testlist;

            testlist = new CircularDoublyLinkedList<>("A", "B", "C", "D");

            testlist.removeData("A");

            assertEquals("[B, C, D]", testlist.toString());
        }
    }

    @Nested
    @DisplayName("remove at index Tests")
    class removeIndexTests
    {
        @Test
        @DisplayName("Removes element at index")
        public void removeIndex()
        {
            CircularDoublyLinkedList<String> testlist;

            testlist = new CircularDoublyLinkedList<>("A", "B", "C", "D");

            assertEquals("C", testlist.removeIndex(2));
            assertEquals("[A, B, D]", testlist.toString());
        }

        @Test
        @DisplayName("Removes element at beginning of list")
        public void removeFirst()
        {
            CircularDoublyLinkedList<String> testlist;

            testlist = new CircularDoublyLinkedList<>("A", "B", "C", "D");

            assertEquals("A", testlist.removeIndex(0));
            assertEquals("[B, C, D]", testlist.toString());
        }

        @Test
        @DisplayName("Removes element at end of list")
        public void removeLast()
        {
            CircularDoublyLinkedList<String> testlist;

            testlist = new CircularDoublyLinkedList<>("A", "B", "C", "D");

            assertEquals("D", testlist.removeIndex(3));
            assertEquals("[A, B, C]", testlist.toString());
        }

        @Test
        @DisplayName("throws exception when index is out of bounds")
        public void outOfBounds()
        {
            CircularDoublyLinkedList<String> testlist;

            testlist = new CircularDoublyLinkedList<>("A", "B", "C", "D");

            assertThrows(IndexOutOfBoundsException.class, () -> testlist.removeIndex(4));
        }
    }
}
