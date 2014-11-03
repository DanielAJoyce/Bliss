
/**
 * The ListNode class contains features that are required to get information from the list class.
 * i.e. get and set methods, and returning the data.
 * 
 * @author Group 5
 * @version 1.0
 */
public class ListNode
{  
    // instance variables
    
    public String information;
    private ListNode next;

    /**
     * Constructor for objects of class List
     * @author Ramanee
     */
    public ListNode(String information)
    {
        // initialise instance variables
        this.information = information;
        this.next = null;
    }

     /**
     * Get the next node
     * 
     * @param  none
     * @return the next node
     */
    public ListNode getNext()
    {
        return next;
    }
    
    
     /**
     * A method to get the information 
     * 
     * @param  none
     * @return information at this node
     */
    public String getinformation()
    {
        return information;
    }

     /**
     * Set the next node
     * 
     * @param  the node to be added at this node's next
     * @return nothing
       * @author Ramanee
   */
    public void setNext(ListNode next)
    {
        this.next = next;
    }
    
     /**
     * A method to return a string containing the data from this node, formatted
     * 
     * @param  nothing
     * @return nothing
     * @author Ramanee
   */
    public String formatInfo()
   {
        //data to return
        String info;
        
        info =  (" " + information);
       
        
        return (info);
    }
}

