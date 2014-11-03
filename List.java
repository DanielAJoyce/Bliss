
/**
 * The list class is responsible for creating a new list, setting a new head and tail, printing
 * and deleting nodes.
 * 
 * @author   Group 5
 * @version  1.0
 */
public class List
{
    //instance variables
    private ListNode head;   
    private ListNode tail;
    private int queueSize;
    /**
     * Constructor for objects of class List
     * Create a head
     */
    public List()
    {
        head = null;
        tail = null;
    }
 
     /**
     * Accessor for this class
     * 
     * @param  nothing
     * @return Head of list    
     */
    public ListNode getHead()
    {
        return(head);
    }

     /**
     * A method to create a new head
     * 
     * @param  Head
     * @return nothing
     */
    public void setHead(ListNode newHead)
    {
        head = newHead;
    }
    
     /**
     * A method to create a new tail
     * 
     * @param  Head
     * @return nothing
     */
    public void setTail(ListNode newTail)
    {
        //creates a new tail
        tail = newTail;
    }
    
     /**
     * A method to return the tail
     * 
     * @param  nothing
     * @return Head of list    
     */
    public ListNode getTail()
    {
        return(null);
    }

     /**
     * Add a new node at the start of a list
     * 
     * @param  data to add
     * @return nothing    
     */
    public void addToTail(String information)
    {
        ListNode myListNode = new ListNode(information);
        
        //checks if list is empty
        if(isEmpty())
        {
            head = tail = myListNode;
            
        }
        else if (head == tail)
        {
            tail = myListNode;
            head.setNext(tail);
        }
        else
        {
            tail.setNext(myListNode);
            tail = myListNode;
        }
                
    }
    
    /**
     * A method to test if Queue is empty 
     * 
     * @param      None
     * @return     boolean 
     */
    public boolean isEmpty()
    {
        return head == null;
    }
    
    /**
     * method to print and test Queue
     * 
     * @param      None
     * @return     None
     */
    public void printList()
    {
        //initialize instance variables
        System.out.print("\f"); 
        ListNode marker;       
        
        marker = head;
        //while marker is not equal to null, get the next marker.
        while (marker != null)
        {           
           System.out.print(marker.formatInfo() + "\n"); 
           marker = marker.getNext();
        }        
    }
    
    /**
     * A method to remove a value from top of Queue
     * 
     * @param       None
     * @return     ListNode
     */
    public ListNode deleteFromList()
    {
        //records deleted node
        ListNode deletedNode = head;   
        //validates to see if Queue is empty or not
        if (isEmpty())
        {
            return null;     
        }
        else
        {
            // removes node from Queue
            deletedNode = head;
            head = head.getNext();
            
            
            System.out.print(deletedNode.formatInfo() + " ");
            return deletedNode;
        }
    }
    
    /**
     * A method to remove a value from top of Queue
     * 
     * @param      None
     * @return    String
     */
    public String deleteNode()
    {
        String theWord = "";
        
        //records deleted node
        ListNode deletedNode = head;  
        
        //validates to see if Queue is empty or not
        if(!isEmpty())
        {
            // removes node from Queue
            deletedNode = head;
            head = head.getNext();
            
            theWord = deletedNode.getinformation();
        }
        
        return theWord;
    }
    
    
}
