
/**
 * The treenode class is responsilbe for searching and returning data from the binary tree.
 * 
 * @author Group 5
 * @version 1.0
 */
public class TreeNode    
{
    // instance variables
    private int bliss;
    private String english;
    private String specialBliss;
    private TreeNode right;
    private TreeNode left;

    /**
     * Constructor for objects of class List
     */
    public TreeNode(int bliss, String english, String specialBliss)
    {
            this.bliss = bliss;
            this.english = english;
            this.specialBliss=specialBliss;
            this.right = null;
            this.left = null;
    }
    
     /**
     * A method to get the right child
     * 
     * @param  none
     * @return TreeNode
     */
    public TreeNode getRight()
    {
        //returns value
        return right;
    }
    
     /**
     * A method to get the left child
     * 
     * @param  none
     * @return TreeNode
     */
    public TreeNode getLeft()
    {
        //returns value
        return left;
    }
    
     /**
     * A method to get the bliss character
     * 
     * @param  none
     * @return int bliss
    */
    public int getBliss()
    {
        //returns value
        return bliss;
    }
    
     /**
     * A method to get the english word
     * 
     * @param  none
     * @return String english
     */
    public String getEnglish()
    {
        //returns value
        return english;
    }
  
     /**
     * A method to set the right child
     * 
     * @param  TreeNode right
     * @return nothing
     */
    public void setRight(TreeNode right)
    {
        //sets right tree node
        this.right = right;
    }
    
     /**
     * Set the left child
     * 
     * @param  TreeNode left
     * @return nothing
     */
    public void setLeft(TreeNode left)
    {
        //sets left tree node
        this.left = left;
    }
    
    /**
     * Return a string containing the data from this node, formatted
     * 
     * @param  nothing
     * @return String
     */
    public String getInfo()
    {
        String info = "";
        
        info = (english + " - ") ;
        
        if(bliss == -1)
        {
            info = info + (specialBliss + " ");
            
        }
        else
        {
            info = info + (bliss + " ");
        }
        
        return info;
    }
    
     /**
     * Return a string containing the data from this node, formatted
     * 
     * @param  nothing
     * @return String
     */
    public String printInfoBliss()
    {
        String info= "";
        //returns and prints a string in BLISS
        info = (" " + english);
        
        
        
        return (info);
    }
    
    /**
     * Return a string containing the data from this node, formatted
     * 
     * @param  nothing
     * @return String
     */
    public String printInfoEnglish()
    {
        String info= "";
        //if else statment to return a string in english
        if(bliss == -1)
        {
            info = (specialBliss + " ");
            
        }
        else
        {
            info = (bliss + " ");
        }
        
        return (info);
    }
}
