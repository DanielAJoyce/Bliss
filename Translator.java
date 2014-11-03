import java.io.*;
/**
 * This class contains all the methods that control the translator
 * 
 * @author Group 5
 * @version 1.0
 */
public class Translator
{

    //intisalize instance variables
    Tree theTree = new Tree(); 
    Queue myQueue = new Queue();
    Queue notFoundQueue = new Queue();
    Queue specialEnglish = new Queue();
    String foundWords;
    String foundNumbers;
    String wordOne;
    String wordTwo;

    /**
     * Constructor for objects of class Translator
     */
    public Translator()
    {
        foundWords = "";
        foundNumbers ="";
        wordOne="";
        wordTwo="";

    }

    /**
     * A method to load a bliss txt file to a binary tree.
     * 
     * @param  None
     * @return  None
     */
    public void loadBlissTree ()
    {

        try
        {
            //instances
            FileReader reader = new FileReader("blissTree.txt");
            BufferedReader buffer = new BufferedReader(reader);

            // read the first line of text
            String lineOfText = buffer.readLine();  

            //read until the end of file
            while(lineOfText != null)
            {
                //split string (bliss & english)

                String[] items = lineOfText.split(";");

                //bliss=items[0];
                //english= items[1];

                int blissInt = Integer.parseInt(items[0]);

                //pass both to addToBlissTree
                theTree.addToBlissTree(blissInt,items[1]);

                //read next line
                lineOfText= buffer.readLine();

            }

        }

        catch(IOException ioe)
        {
            System.out.println("Sorry there has been an error while reading the file.");
        }

    }

    /**
     *  A method to load a english txt file to a binary tree.
     * 
     * @param  None
     * @return None
     */
    public void loadEnglishTree ()
    {

        try
        {
            //instance variables
            FileReader reader = new FileReader("englishTree.txt");
            BufferedReader buffer = new BufferedReader(reader);

            // read the first line of text
            String lineOfText = buffer.readLine();  

            //read until the end of file
            while(lineOfText != null)
            {
                //split string (bliss & english)
                String[] items = lineOfText.split(";");

                //english=items[0];
                //bliss= items[1];
                //special bliss symbols = item[2];

                int blissInt = Integer.parseInt(items[1]);

                //pass both to addToBlissTree
                theTree.addToEnglishTree(items[0], blissInt, items[2]);

                //read next line
                lineOfText= buffer.readLine();

            }

        }

        catch(IOException ioe)
        {
            //error handling message
            System.out.println("Sorry there has been an error while reading the file.");
        }

    }

    /**
     * A method for translating BLISS characters to english
     * 
     * @param  String blissInput
     * @return  None
     */
    public void transBlissToEnglish(String blissInput)
    {
        foundNumbers ="";
        boolean found = false;
        String[] firstSplitArray = blissInput.split(";");

        for(int i=0;i< firstSplitArray.length;i++)
        {

            //calling a method that checks for special combination words (contains more than one bliss symbol)
            found= transSpecial(firstSplitArray[i]);

            if(found==false)
            {

                String[] secondSplitArray = firstSplitArray[i].split(",");
                
                //for loop that
                for(int z=0;z< secondSplitArray.length;z++)
                {
                    //instance variables
                    int blissInt = Integer.parseInt(secondSplitArray[z]);

                    found = isItNumberBliss(blissInt);

                    if(found==false)
                    {
                         //if false search in the bliss tree
                         found = theTree.searchInBlissTree(blissInt);
                        if(found==true)
                        {
                            //if true push words onto the stack
                            myQueue.push(theTree.foundInfo);
                            foundNumbers  = foundNumbers  + " " + secondSplitArray[z];
                        }
                        else
                        {
                            notFoundQueue.push(secondSplitArray[z]);
                        }
                    }

                }
            }

        }

        printTranslation(foundNumbers, "English");

    }

    /**
     * A method to check if it is a valid bliss number
     * 
     * @param  int numberCandidate
     * @return   boolean found
     */
    public boolean isItNumberBliss (int numberCandidate)
    {
        //instance variables
        boolean found =false;
        if(numberCandidate > 99)
        {
            // number has to be less than 100
            int translatedNumber = numberCandidate - 100;
           
            //check bliss number against bliss word
            String translatedString = Integer.toString(translatedNumber);
            myQueue.push(translatedString);
            foundNumbers  = foundNumbers  + " " + numberCandidate;
            found=true;
        }
        return found;
    }
    
    /**
     * A method to translate a special word
     * 
     * @param  String specialWord
     * @return  boolean found
     */
    public boolean transSpecial(String specialWord)
    {
        String combination = "";
        boolean found = false;
        String[] splitSpecialWord = specialWord.split(",");

        for(int z=0;z< splitSpecialWord.length;z++)
        {
            combination = combination + splitSpecialWord[z];
        }

        try
        {
            //instances
            FileReader reader = new FileReader("specialSymbols.txt");
            BufferedReader buffer = new BufferedReader(reader);

            // read the first line of text
            String lineOfText = buffer.readLine();  

            //read until the end of file
            while(lineOfText != null)
            {
                if(combination.equals(lineOfText))
                {
                    combination = buffer.readLine();
                    myQueue.push(combination);
                    foundNumbers = foundNumbers + " " + specialWord;
                    found = true;
                }
                else
                {
                    lineOfText = buffer.readLine();
                }
            }

        }

        catch(IOException ioe)
        {
            System.out.println("Sorry there has been an error while reading the file.");
        }
        return found;
    }
    
    /**
     * A method to convert bliss numbers
     * 
     * @param  String convertToNumber
     * @return  boolean found
     */
    public boolean isItNumberEnglish (String convertToNumber)
    {
        //instance variables
        boolean found = false;
        
        try
        {
            found = true;
            int converting  = Integer.parseInt(convertToNumber);
            converting = converting + 100;
            String translatedString = Integer.toString(converting);
            myQueue.push(translatedString);
            foundWords = foundWords + convertToNumber + " ";
            
        }
        catch(NumberFormatException nfe)
        {
            //default value
            found = false;
        }
        return found;
    }

    /**
     * A method to translate english strings to BLISS
     * 
     * @param  String englishInput
     * @return  None 
     */
    public void transEnglishToBliss(String englishInput)
    {
        //instance variables
        foundWords = "";
        String convertedString = "";
        boolean found = false;
        int i=0;
        String specialSearch = "";

        String[] splitArray = englishInput.split(" ");
        
        //for loop to split the string up
        for(int z=0;z< splitArray.length;z++)
        {

            found = theTree.searchInEnglishTree(splitArray[z]);

            if( found == true)
            {
                //if the search returns true then
                myQueue.push(theTree.foundInfo);
                foundWords = foundWords + splitArray[z] + " ";
            }
            else
            {
                //if the search returns false
                found = isItNumberEnglish(splitArray[z]);
                
                if(found == false)
                {
                    transSpecialEnglish(splitArray[z]);
                    
                }
               
            }

        }

        transSpecialEnglish("");

        printTranslation(foundWords, "Bliss");
    }

    /**
     * A method for translating special BLISS words to enlgish
     * 
     * @param  String firstWord
     * @return  None
     */
    public void transSpecialEnglish (String firstWord)
    {
        //intialize instance variables
        wordOne = firstWord;
        
        //if word two is not blank check if they are a combination word (consisting of two parts)
        if (wordTwo != "")
        {
            //combine the word
            String specialWord = wordTwo + " " + wordOne; 
            
            //search for the two part word
            boolean found = theTree.searchInEnglishTree(specialWord);

            if(found == true)
            {
                //if the boolean is returned true push words onto the stack
                myQueue.push(theTree.foundInfo);
                foundWords = foundWords + specialWord + " ";
                wordOne = "";
                wordTwo="";
            }
            else
            {

                //pushes word two onto the stack
                notFoundQueue.push(wordTwo);

                wordTwo=wordOne;
                wordOne="";

            }
        }
        else
        {
            wordTwo=wordOne;
            wordOne="";
        }

    }

    /**
     * A method to print out the translated text
     * 
     * @param  String foundWords, String englishOrBliss
     * @return    None
     */
    public void printTranslation(String foundWords, String englishOrBliss)
    {
        //if notFoundQueue is empty
        if(notFoundQueue.checkQueueEmpty()==true)
        {
            System.out.print(foundWords +" translated to "+ englishOrBliss +" is: ");
            while(myQueue.checkQueueEmpty() != true)
            {
                myQueue.pop();
            }
        }
        else if (myQueue.checkQueueEmpty()==true)
        {
            //catch incase no translation is available/found
            System.out.print("A translation was not found for the following words:");
            //calls a check if queue is empty method from the Queue class
            while(notFoundQueue.checkQueueEmpty()!=true)
            {
                notFoundQueue.pop();
            }
        }
        else
        {
            //catch incase no translation is available/found
            System.out.print("A translation was not found for the following words:");
            //calls a check if queue is empty method from the Queue class
            while(notFoundQueue.checkQueueEmpty()!=true)
            {
                notFoundQueue.pop();
            }
            System.out.println("");
            //display entered words, and then the translated words
            System.out.print(foundWords +" translated to " + englishOrBliss + " is: ");
            while(myQueue.checkQueueEmpty() != true)
            {
                myQueue.pop();
            }
        }
    }
    
    /**
     * A method to print the binary tree
     * 
     * @param  None
     * @return None 
     */
    public void printTree()
    {
        //calling the traversing method 
        theTree.callingTraverse();
    }

}

