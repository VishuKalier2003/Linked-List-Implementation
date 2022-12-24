import java.util.Scanner;
// todo: Write A Program to Create a Singly Linked List and remove a Node with its index given from the End... The Process should take O(n) time...
//! Linked List Data Structure Class created... 
public class LinkedList
{
    //! Node Structure Class Created...
    public class Node
    {
        //* Member variables... */
        public int data;
        public Node next;
        public Node(int val)     // Parametrized Constructor
        {
            this.data = val;
            this.next = null;
        }
    }
    //! Head Node Pointer Created...
    Node head;

    //? Function defined for Insertion of Nodes... O(n) time...
    public void InsertNode(int val)
    {
        Node n = new Node(val);
        if (head == null)          // If Linked List is Empty...
        {
            head = n;
            return;
        }
        Node temp = head;          // if Linked List is not Empty...
        while(temp.next != null)
            temp = temp.next;
        temp.next = n;
        n.next = null;
        return;
    }

    //? Function to Print the Linked List... O(n) time...
    public void PrintList()
    {
        Node temp = head;
        while(temp.next != null)
        {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println(temp.data+" -> null");
        return;
    }

    //? Function to Remove the Node by the given index from the End... O(n) time...
    public void DeleteNodeFromEnd(int k)
    {
        Node temp = head;              // temporary pointer
        int count = 0;      // counter variable
        //* We first traverse the Linked List to evaluate its Length... O(n) time... */
        while(temp.next != null)
        {
            temp = temp.next;
            count++;
        }
        //* We then find the index of the Node in the Linked List from End... O(1) time... */
        int index = count - k;
        Node temp1 = head.next;
        Node temp2 = head;
        //*We again traverse the Linked List to reach the particular Node by index and remove it... O(n) time...*/
        while(index != 0)
        {
            temp2 = temp2.next;
            temp1 = temp1.next;
            index--;
        }
        temp2.next = temp1.next;         // The Required Node is removed...
        System.out.println("The Node has been deleted !!");
        return;
    }

    //! The Main Method begins...
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);              // Creating Scanner class object...
        LinkedList linkedlist = new LinkedList();         // Creating Linked List class object...
        int x, a;
        System.out.print("Enter the number of Nodes to Insert : ");
        a = sc.nextInt();
        for(int i = 0; i < a; i++)
        {
            System.out.print("Enter the Node data : ");
            x = sc.nextInt();
            linkedlist.InsertNode(x);
        }
        linkedlist.PrintList();
        System.out.print("Enter the index of Node to be Deleted from End : ");
        a = sc.nextInt();
        linkedlist.DeleteNodeFromEnd(a);
        linkedlist.PrintList();
        sc.close();                   // Scanner class closed...
    }
}