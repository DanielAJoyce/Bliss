
/**
 * This class is responsible for the queue, creating a new one, pushing and popping data and printing
 * the current list.
 * 
 * 
 * @author Group 5
 * @version 1.0
 */
public class Queue
{
    // instance variables 
    List aList = new List();

    /**
     * Constructor for objects of class Queue
     */
    public Queue()
    {
        initialiseQueue();
    }

    /**
     * A method to create a new queue
     * 
     * @param     None
     * @return    None
     */
    public void initialiseQueue()
    {    
        //sets up the Queue
        aList.setHead(null);     
    }

    /**
     * pushes a value onto Queue 
     * 
     * @param       int information
     * @return     None
     */
    public void push(String information)
    {              
        // adds a number into the Queue
        aList.addToTail(information);     
    }

    /**
     * A method to display if queue is empty
     * 
     * @param       None
     * @return     None
     */
    public void pop()
    {    
        if (checkQueueEmpty())
        {
            //if queue is empty, display to user
            System.out.print("\f         Queue is Empty\n");
        }
        else
        {
            aList.deleteFromList().getinformation();
        }
    }
    
    /**
     * A method to pop a data value from the Queue 
     * 
     * @param      None
     * @return     None
     */
    public String popNoPrint()
    {    
        String theWord ="";
        
        //check if queues not empty, if true pop the value.
        if(!checkQueueEmpty())
        {
            theWord = aList.deleteNode();
        }
        
        return theWord;
    }

    /**
     * A method to print the whole queue
     * 
     * @param     None
     * @return    None
     */
    public void printer()
    {    
        //test method to print the list
        aList.printList();
    }

    /**
     * A method to check if the queue is empty 
     * 
     * @param     None
     * @return    None
     */
    public boolean checkQueueEmpty()
    {                  
        //checks if the Queue is empty
        return aList.isEmpty();
    }


}
