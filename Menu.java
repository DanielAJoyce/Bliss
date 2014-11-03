import java.io.*;
/**
 * This class contains:
 * -the menu
 * -the user interface
 * 
 * @author Group 5
 * @version 1.0
 */
public class Menu
{
    // instance variables
    Translator theTranslator = new Translator ();
    int choice;

    BufferedReader in;
    String read;

    /**
     * Constructor for objects of class Menu
     */
    public Menu()
    {
        choice = 0;
    }

    /**
     * The main method to access the program that creates the menu
     * 
     */
    public static void main (String [] args)
    {
        // creating an instance of the menu class
        Menu theMenu=new Menu();

        theMenu.starting();

        //clears the screen everytime the program is opened & a greeting message
        System.out.println("\f");
        System.out.println("      -Welcome!-");
        System.out.println("");

        // calling the menu method
        theMenu.runMenu();

    }

    /**
     * A method to display the menu options to the user. 
     * 
     * @param  None
     * @return  None
     */
    public void displayMainMenu () 

    {
        //menu system to display to user
        System.out.println(" ---- Translator ---- ");
        System.out.println("");
        System.out.println("");
        System.out.println("1.   English to BLISS");
        System.out.println("");
        System.out.println("2.   BLISS to English"); 
        System.out.println("");
        System.out.println("3.   Instructions"); 
        System.out.println("");
        System.out.println("4.   Print the dictionary"); 
        System.out.println("");
        System.out.println("5.   Exit"); 
        System.out.println("");

    }

    /**
     * A method to handle all the options in the menu and call them from other classes if necessary
     * 
     * @param  None
     * @return  None
     */
    public void runMenu () 
    {  

        //do while loop for the menu
        do
        {
            // initialise instance variables
            displayMainMenu ();
            promptChoice();

            if (choice == 1)
            {
                //navigates the user to English to BLISS
                System.out.println("\f");
                getEnglishWord();
                getToMenu();
                System.out.println("\f");

            } 
            else if(choice == 2)
            {
                //navigates the user to BLISS to English
                System.out.println("\f");
                getBlissNumber();
                getToMenu();
                System.out.println("\f");
            } 
            else if(choice == 3)
            {
                System.out.println("\f");

                // navigates the user to the instructions
                instructions();
                getToMenu();
                System.out.println("\f");
            }
            else if(choice == 4)
            {
                //navigates the user to the dictionary
                System.out.println("\f");
                theTranslator.printTree();
                getToMenu();
                System.out.println("\f");
            }
            else if(choice == 5)
            {
                //exits the program
                System.out.println("\f");
                exit();
            }
            else 
            {
                //catch incase user enters invalid input
                System.out.println("\f");
                System.out.println("Sorry your option was not found. Please Try again.");
            }

        }    
        while(true);

    }

    /**
     * A method to get the english word from the user.
     * 
     * @param  None
     * @return  None
     */
    public void promptChoice()
    {
        //asking the user for their choice
        System.out.print("Please enter your selection:"); 
        choice = Genio.getInteger(); 
    }

    /**
     * A method to get the english word from the user.
     * 
     * @param  None
     * @return  None
     */
    public void getEnglishWord()
    {
        // initialise instance variables
        int choice;
        String word = "";
        //message to display to user
        System.out.println("Would you like to:");
        System.out.println(" 1 - Load a txt file from memory for translation");
        System.out.println(" 2 - Enter your own text for translation");
        //uses genio to handle the int input
        choice = Genio.getInteger();
        if(choice==1){
            try {
                //prompts the user to enter name of txt file
                System.out.println("Please Enter the name of the text file (Please include .txt at the end of the name, for example: test.txt).");
                String text = Genio.getString();
                //open a bufferedReader to file helloworld.txt
                in = new BufferedReader(new FileReader(text));

                //read a line from helloworld.txt and save into a string
                read = in.readLine();

                //print out the line
                System.out.println("file output: " + read);
                word = read;

                //safely close the BufferedReader after use
                in.close();

            }catch(IOException e){
                //catch incase file doesnt load/isnt found
                System.out.println("\f");
                System.out.println("There was a problem:" + e);
                runMenu();
            }
        }
        else if(choice ==2){
            //prompts user to enter a english word to translate
            System.out.println("Please enter an English sentence that you would like to translate to BLISS:");
            word = Genio.getString();
        }
        else{
            //error message
            System.out.println("Wrong choice");
            runMenu();
        }
        theTranslator.transEnglishToBliss(word);

    }

    /**
     * A method to get the number associated with the bliss character.
     * @param  None
     * @return  None
     */
    public void getBlissNumber()
    {
        // initialise instance variables
        int choice;
        boolean validated = false;
        String number = "";
        System.out.println("Would you like to:");
        System.out.println(" 1 - Load a txt file from memory for translation");
        System.out.println(" 2 - Enter your own text for translation");
        choice = Genio.getInteger();
        if(choice==1){
            try {
                System.out.println("Please Enter the name of the text file (Please include .txt at the end of the name, for example: test.txt).");
                String text = Genio.getString();
                //open a bufferedReader to file helloworld.txt
                in = new BufferedReader(new FileReader(text));

                //read a line from helloworld.txt and save into a string
                read = in.readLine();

                //print out the line
                System.out.println("file output: " + read);
                number = read;

                //safely close the BufferedReader after use
                in.close();

            }catch(IOException e){
                //catch message to display
                System.out.println("\f");
                System.out.println("There was a problem:" + e);
                runMenu();
            }
        }
        else if(choice ==2){
            //message to prompt user to enter BLISS number(s) to translate
            System.out.println("Please enter the BLISS sentence that you would like to translate to english:");
            number = Genio.getString();
        }
        else{
            //error message
            System.out.println("Wrong choice");
            runMenu();
        }

        validated = validationSplit(number);

        if(validated == true)
        {
            theTranslator.transBlissToEnglish(number);
        }
        else
        {
            //catch incase user enters an invalid string
            System.out.println("Invalid input. Enter only numbers within range, commas or semicolons.");
            getBlissNumber();
        }

    }

    /**
     * A method to get the number associated with the bliss character.
     * @param  None
     * @return  None
     */
    public boolean validationSplit(String input)
    {
        // initialise instance variables
        boolean validated = false;
        String[] firstValidationArray = input.split(";");
        
        //for loop that has an array to validate bliss numbers.
        for(int i=0;i< firstValidationArray.length;i++)
        {

            String[] secondValidationArray = firstValidationArray[i].split(",");

            for(int z=0;z< secondValidationArray.length;z++)
            {

                //try & catch method
                try
                {
                    int validatingInts  = Integer.parseInt(secondValidationArray[z]);
                    if (validatingInts >= 1 && validatingInts <= 32 || validatingInts >= 101)
                    {
                        //if number is bigger than 1 and less than 32 or less than 101
                        validated =  true;
                    }
                    else
                    {
                        //if not then return this
                        validated = false;
                    }
                }
                catch (NumberFormatException nfe) 
                {
                    //error prevention catch
                    validated = false;
                }

            }

        }
        return validated;
    }

    /**
     * A method that calls the methods that load the files in the start of the program
     * 
     * @param  None
     * @return  None
     */
    public void starting ()
    {
        theTranslator.loadBlissTree();
        theTranslator.loadEnglishTree();
    }

    /**
     * A method that allows the user to look at the printed info as long as they need to and then enter
     * -1 to get back to the menu
     * 
     * @param  none
     * @return nothing    
     */
    public void getToMenu()
    {
        //local variable
        int tempSelection =1;

        //interface
        System.out.println("");
        System.out.println("");

        //getting the user to type -1 when theu want to get back to the menu
        System.out.println("Please enter -1 to get back to the main menu:");
        tempSelection = Genio.getInteger();

        //if the user inputs an invalid value the system will keep asking for a new value
        while (tempSelection != -1)
        {
            System.out.println("");
            System.out.println("Sorry an invalid input was detected.");
            System.out.println("Please enter -1 to get back to the main menu:");
            tempSelection = Genio.getInteger();
        }

        //cleaning the screen for the menu
        System.out.println("\f");
    }

    /**
     * A method to print out instructions to the user.
     * 
     * @param  None
     * @return  None
     */
    public void instructions()
    {
        //instructions to print to user
        System.out.println("                                                Instructions");
        System.out.println("                                         ===========================");
        System.out.println("                                   > Select which type of translation is needed\n");
        System.out.println("               English to Bliss                                                        Bliss to English");
        System.out.println("               ----------------                                                        ----------------");
        System.out.println("  1)Enter English words for translation                                 1)Enter Bliss using numbers, colons and semi colons only");
        System.out.println("  2)OR load a txt file that is located in the root directory            2)Either load a txt file from the root directory ");
        System.out.println("  3)Words will then be translated.                                      3)OR enter your own symbols to be translated ");
        System.out.println("  4)Bliss translation will be printed to screen                         4)Surround words using multiple symbols with semicolons");
        System.out.println("                                                                          eg input > 13,30;7,13;  =  'Happy Home'");
        System.out.println("                                                                        5)Bliss will then be translated");
        System.out.println("                                                                        6)English translation will be printed to screen\n");
    }

    /**
     * A method that exits the program and displays an message for the user
     * 
     * @param  None
     * @return  None
     */
    public void exit()
    {
        //message to inform the user system is now closing
        System.out.println("Thank you for using our Translator. Goodbye!");
        System.exit(0);
    }
}
