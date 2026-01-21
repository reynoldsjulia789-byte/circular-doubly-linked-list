package Test;

import Main.CircularDoublyLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
