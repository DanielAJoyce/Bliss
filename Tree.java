
/**
 * Write a description of class Tree here.
 * 
 * @author Group 5
 * @version 1.0
 */
public class Tree
{
   // instance variables 
   public TreeNode rootBliss;
   public TreeNode rootEnglish;
   public String foundInfo;

    /**
     * Constructor for objects of class Tree
     */
    public Tree()
    {
        rootBliss = null;
        rootEnglish = null;
        foundInfo = "";
    }

    /**
     * A method that goes through the tree and searches for the word to be translated
     * 
     * @param  int findThis
     * @return  boolean
     */
    public boolean searchInBlissTree(int findThis)
    {
        boolean found = false;
        TreeNode currentNodeSearch;
        TreeNode previousNodeSearch;

        currentNodeSearch = rootBliss;
        previousNodeSearch = rootBliss;

        //while there are nodes in the tree and the node has not been found
        while (currentNodeSearch != null && !found)
        {

            //if a match is found
            if (currentNodeSearch.getBliss() == findThis)
            {
                //break from loop
                found = true;
            }
            else if (findThis < currentNodeSearch.getBliss())
            {
                //keeping track of previous
                previousNodeSearch = currentNodeSearch;

                //if it is smaller than the surrent node go left
                currentNodeSearch = currentNodeSearch.getLeft(); 
            }
            else if (findThis > currentNodeSearch.getBliss())
            {
                //keep track of previous
                previousNodeSearch = currentNodeSearch;

                //if it is larger than the current node go right
                currentNodeSearch = currentNodeSearch.getRight();
            }
        }

        //returning true if it was found and false if not
        if (found == true)
        {
            foundInfo=currentNodeSearch.printInfoBliss();
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     * A method that goes through the tree and searches for the word to be translated
     * 
     * @param  int findThis
     * @return  boolean
     */
    public boolean searchInEnglishTree(String findThis)
    {
        boolean found = false;
        TreeNode currentNodeSearch;
        TreeNode previousNodeSearch;

        currentNodeSearch = rootEnglish;
        previousNodeSearch = rootEnglish;

        //while there are nodes in the tree and the node has not been found
        while (currentNodeSearch != null && !found)
        {

            //if a match is found
            if (findThis.compareTo(currentNodeSearch.getEnglish()) == 0)
            {
                //break from loop
                found = true;
            }
            else if (findThis.compareTo(currentNodeSearch.getEnglish()) < 0)
            {
                //keeping track of previous
                previousNodeSearch = currentNodeSearch;

                //if it is smaller than the surrent node go left
                currentNodeSearch = currentNodeSearch.getLeft(); 
            }
            else if (findThis.compareTo(currentNodeSearch.getEnglish()) > 0 )
            {
                //keep track of previous
                previousNodeSearch = currentNodeSearch;

                //if it is larger than the current node go right
                currentNodeSearch = currentNodeSearch.getRight();
            }
        }

        //returning true if it was found and false if not
        if (found == true)
        {
            foundInfo=currentNodeSearch.printInfoEnglish();
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     * A method that adds an node to the tree
     * 
     * @param  int studentID, int mark
     * @return  None
     */
    public void addToBlissTree(int bliss, String english)
    {
        // initialise instance variables
        TreeNode currentNode, previousNode;

        currentNode = rootBliss;
        previousNode = null;

        TreeNode newNode;
        newNode = new TreeNode (bliss, english,"" );

        //If the tree is empty
        if (rootBliss == null)
        {
            //Set as root
            rootBliss = newNode;
        }
        else 
        {
            //finding the place for the node to be added
            while(currentNode != null)
            {
                //keeping track of the previous node
                previousNode = currentNode;

                //deciding wether to go left or right
                if(newNode.getBliss() < currentNode.getBliss())
                {
                    currentNode=currentNode.getLeft();
                }
                else
                {
                    currentNode = currentNode.getRight();
                }
            }

            //adding the new node to it's new place
            if(newNode.getBliss() < previousNode.getBliss())
            {
                previousNode.setLeft(newNode); 
            }
            else
            {
                previousNode.setRight(newNode);
            }

        }

    }

    /**
     * A method that adds an node to the tree
     * 
     * @param  int studentID, int mark
     * @return  None
     */
    public void addToEnglishTree(String english, int bliss, String specialBliss)
    {
        // initialise instance variables
        TreeNode currentNode, previousNode;

        currentNode = rootEnglish;
        previousNode = null;

        TreeNode newNode;
        newNode = new TreeNode (bliss, english, specialBliss);

        //If the tree is empty
        if (rootEnglish == null)
        {
            //Set as root
            rootEnglish = newNode;
        }
        else 
        {
            //finding the place for the node to be added
            while(currentNode != null)
            {
                //keeping track of the previous node
                previousNode = currentNode;

                //deciding wether to go left or right
                if(english.compareTo(currentNode.getEnglish()) < 0)
                {
                    currentNode=currentNode.getLeft();
                }
                else
                {
                    currentNode = currentNode.getRight();
                }
            }

            //adding the new node to it's new place
            if(newNode.getEnglish().compareTo( previousNode.getEnglish()) < 0)
            {
                previousNode.setLeft(newNode); 
            }
            else
            {
                previousNode.setRight(newNode);
            }

        }

    }
    
    /**
     * A method for calling a Traverse Binary Tree
     * 
     * @param   None
     * @return  None
     */
    public void callingTraverse ()
    {
        traverseTree(rootEnglish);
    }

    
   /**
     * A method for adding a node to a Traverse Binary Tree
     * 
     * @param   None
     * @return  None
     */
    public void traverseTree(TreeNode node)
    {             
        //if statment if the node is NOT equal to null
        if (node!=null)
        {
            traverseTree(node.getLeft());

            System.out.println(node.getInfo());  

            traverseTree(node.getRight());
        }
    }
}
