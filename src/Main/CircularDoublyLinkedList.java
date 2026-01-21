package Main;

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
            This makes it so we can use the addFirst method to add the data to the list.
         */
        for (idx = (data.length - 1); idx >= 0; idx--)
        {
            addFirst(data[idx]);
        }
    }

    /**
     * Adds a new node at the start of the list containing the data to be stored.
     *
     * @param data the data to store in the list
     */
    public void addFirst(Type data)
    {
        Node newNode;

        newNode        = new Node(this.head, data, this.head.next);     // Creates new node with prev pointing to the
                                                                        // head node & next linked to head.next's node
        this.head.next.prev = newNode;                                  // re-links head.next.prev to point at new node
        this.head.next      = newNode;                                  // re-links head.next to point at new node

        this.size++;                                                    // increments size
    }

    /**
     * Adds a new node at the end of the list containing the data to add to the list.
     *
     * @param data the data to add to the list
     */
    public void add(Type data)
    {
        Node curr, newNode;

        // since we have a link to the previous node and our list is circularly linked, we can go to the end of the list
        curr           = this.head.prev;

        newNode        = new Node(curr, data, curr.next);      // make a new node that is linked properly
        curr.next      = newNode;                              // relink curr.next
        this.head.prev = newNode;                              // relink head.prev

        this.size++;                                           // increment size
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
            builder.append(curr.data.toString());                               // add the data to the string
            builder.append(", ");                                               // add a comma and space to the string
        }

        builder.append(curr.data.toString());                                   // add the data in the last list node
        builder.append("]");                                                    // add ] to end the string

        return builder.toString();                                              // return the completed string
    }
}
