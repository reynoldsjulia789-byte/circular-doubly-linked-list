package Main;

import java.util.Objects;

/**
 * Circular Doubly Linked List.
 * Created for learning purposes.
 *
 * @param <Type> the type of object stored in the list
 * @author Julia Reynolds
 */
public class CircularDoublyLinkedList<Type>
{
    private Node head; // the start of the list
    private int  size; // the length/size of the list

    /**
     * private inner node class for the doubly linked list
     */
    private class Node
    {
        private Node prev; // link to previous node in list
        private Type data; // data stored in node
        private Node next; // link to next node in list

        /**
         * Constructor for Node in Doubly Linked List that takes previous Node,
         * data, and next Node.
         *
         * @param prev the previous node in the list
         * @param data the data to store in the list node
         * @param next the next node in the list
         */
        private Node(Node prev, Type data, Node next)
        {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        private Node(Type data)
        {
            this(null, data, null);
        }
    }

    /**
     * Constructor for doubly linked list
     */
    public CircularDoublyLinkedList()
    {
        this.head = new Node(null);     // dummy head node stores no data
        this.size = 0;                       // list is empty so size is 0

        this.head.next = this.head;          // circularly link to self
        this.head.prev = this.head;          // circularly link to self
    }

    /**
     * Constructor that adds data as the linked list is constructed.
     *
     * @param data the data to store in the list
     */
    public CircularDoublyLinkedList(Type... data)
    {
        this();                                             // call other constructor to set up empty list

        int idx;                                            // list of variables used in this method

        /*
            Loops backward through the passed array.
            This makes it so we can use the addFirst method to addAtIndex the data to the list while maintaining the order
                of the elements to be added to the list.
            In a singly linked list that doesn't keep track of the tail of the list, or a non-circular doubly linked
                list, utilizing the addFirst method would be significantly faster for long lists since you can just addAtIndex
                to the front of the list rather than traversing through the entire list each time you addAtIndex a new element.
         */
        for (idx = (data.length - 1); idx >= 0; idx--)
        {
            addFirst(data[idx]);
        }
    }

    /**
     * Adds data to the beginning of the list.
     *
     * @param data the data to store in the list
     */
    public void addFirst(Type data)
    {
        addAtIndex(data, 0);
    }

    /**
     * Adds data to the end of the list.
     *
     * @param data the data to addAtIndex to the list
     */
    public void addLast(Type data)
    {

        addAtIndex(data, this.size); // since we have a method that adds at a specified index, we can call it
    }

    /**
     * Adds data at the specified index within the list
     *
     * @param data the data to addAtIndex to the list
     * @param index the location in the list to addAtIndex the data
     * @throws IndexOutOfBoundsException throws exception if index is outside of list bounds
     */
    public void addAtIndex(Type data, int index) throws IndexOutOfBoundsException
    {
        int  curridx;
        Node curr, newNode;

        // we are considering this.size in bounds in case we want to addAtIndex on to the end of the list.
        if (index < 0 || index > this.size)
        {
            throw new IndexOutOfBoundsException("cannot addAtIndex data to list. index is out of bounds");
        }

        // go forwards through the list if index is in the left half or middle of the list, or if the list is empty.
        if (index <= (this.size - 1) || this.size == 0)
        {
            curr = this.head;

            for (curridx = 0; curridx < index; curridx++)   // we want to stop one before the index we want to addAtIndex at
            {
                curr = curr.next;
            }

            newNode = new Node(curr, data, curr.next);      // create a new node with the prev and curr nodes linked

            curr.next.prev = newNode;                       // relink the prev variable in the next node
            curr.next      = newNode;                       // relink the next variable in the current node
        }
        else                           // go backwards through the list because to have less distance to travel.
        {
            curr = this.head;

            for (curridx = this.size; curridx > index; curridx--) // go backwards until desired index is reached.
            {
                curr = curr.prev;
            }

            newNode = new Node(curr.prev, data, curr);       // create a new node with the prev and curr nodes linked

            curr.prev.next = newNode;                        // relink the next variable in the previous node
            curr.prev      = newNode;                        // relink the prev variable in the current node
        }

        this.size++;                                     // increment size by 1 to ensure size is accurate
    }

    /**
     * Searches through the list for specified data, removing the first instance of it found.
     *
     * @param data the data to be removed from the list
     * @return boolean indicating if the removal was successful
     */
    public boolean removeData(Type data)
    {
        Node prev, curr;

        if (size == 0)
        {
            return false;                               // no data stored in empty list
        }

        prev = this.head;
        curr = this.head.next;                          // start on the first real node in the linked list

        // move through the list until we either loop back around to the head or find the data we are looking for
        while (curr != this.head)
        {
            if (Objects.equals(curr.data, data))        // match found, now we remove it
            {
                prev.next      = curr.next;             // set the next variable in the prev node to the node after curr
                curr.next.prev = prev;                  // set the prev variable in the node after curr to prev

                return true;                            // curr has been cut out of the list, so we return true.
            }

            prev = curr;                                // move prev forward one node
            curr = curr.next;                           // move curr forward one node
        }

        // at this point we have traversed through the entire list and not found the data we were looking to remove.
        return false;
    }

    /**
     * Removes data from the list at the specified index.
     *
     * @param index the index of the data to be removed
     * @return the data removed from the list
     * @throws IndexOutOfBoundsException throws exception if index is outside of list bounds
     */
    public Type removeIndex(int index) throws IndexOutOfBoundsException
    {
        int  curridx;
        Node prev, curr;

        if (index < 0 || index >= this.size)                  // this.size is out of bounds since we start at index 0
        {
            throw new IndexOutOfBoundsException("cannot remove data from list. index is out of list bounds");
        }

        // go forwards through the list if index is in the left half or middle of the list.
        if (index <= (this.size - 1))
        {
            prev = this.head;
            curr = this.head.next;                         // start on the first real list node

            for (curridx = 0; curridx < index; curridx++)  // we want to stop on the index we want to remove
            {
                prev = curr;
                curr = curr.next;
            }

            prev.next      = curr.next;     // relink the next variable in the previous node to point to the next node.
            curr.next.prev = prev;          // relink the prev variable in the node after the one to delete to prev.
        }
        else                           // go backwards through the list because to have less distance to travel.
        {
            prev = this.head;
            curr = this.head.prev;                         // start on the last real list node

            for (curridx = this.size; curridx > index; curridx--) // go backwards until desired index is reached.
            {
                prev = curr;
                curr = curr.prev;
            }

            prev.prev      = curr.prev;    // relink the prev variable in the previous node to the node after curr
            curr.prev.next = prev;         // relink the next variable in the node after curr to prev.
        }

        this.size--;                                       // decrement size by 1 to ensure list size is kept accurate

        return curr.data;
    }

    /**
     * Builds a String that represents the list.
     *
     * @return String representing the list
     */
    @Override
    public String toString()
    {
        StringBuilder builder;                              // objects used in this method
        Node          curr;

        if (size == 0)                                      // separate condition for size 0 so
        {
            return "[]";
        }

        builder = new StringBuilder("[");                   // start the StringBuilder with [

        /*
            This is a for loop that loops through the whole list.
            We start on head.next since head points to a dummy node.
            Since this list is circularly linked, and we want to stop one before the end,
                we traverse through the list until the next variable in the node we are currently
                looking at = this.head.
            Finally, we move curr to point to the next link in the list after each time we go through
                the body of the for loop.
         */
        for (curr = this.head.next; curr.next != this.head; curr = curr.next)
        {
            builder.append(curr.data.toString());                               // addAtIndex the data to the string
            builder.append(", ");                                               // addAtIndex a comma and space to the string
        }

        builder.append(curr.data.toString());                                   // addAtIndex the data in the last list node
        builder.append("]");                                                    // addAtIndex ] to end the string

        return builder.toString();                                              // return the completed string
    }
}
