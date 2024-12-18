
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SpellChecker
{
	
	static private File myFile = new File("datasheet.csv");
    private ArrayList<String> dictionary;

    /* Constructor populates the dictionary ArrayList from the file dictionary.txt*/
    public SpellChecker() throws IOException
    {
        List<String> lines = Files.readAllLines(Paths.get("words.txt"));
        dictionary = new ArrayList<String>(lines);
    }

    /**
     * Write a linearSearch(word) method that finds a word
     * in the ArrayList dictionary. It should also keep
     * a count of the number of words checked.
     *
     * @param String word to be found in elements.
     * @return a count of how many words checked before returning.
     */
    public int linearSearch(String word)
    {
    	for(int i = 0; i < dictionary.size(); i++)
    	{
    		if(word.equals(dictionary.get(i))) 
    			return i + 1;
    	}
    	
		return dictionary.size();
    }

    /**
     * Write a binarySearch(word) method that finds the word
     * in the ArrayList dictionary. It should also keep
     * a count of the number of words checked.
     *
     * @param String word to be found in elements.
     * @return a count of how many words checked before returning.
     */
    public int binarySearch(String word)
    {
    	int count = 0;
    	
    	int low = 0, high = dictionary.size() - 1;
    	
    	for(int i = (high + low) / 2; high - low > 1; i = (high + low) / 2)
    	{
    		count++;
    		
    		
    		if(dictionary.get(i).toLowerCase().compareTo(word.toLowerCase()) < 0)
    		{
    			low = i;
    		}
    		else if (dictionary.get(i).toLowerCase().compareTo(word.toLowerCase()) > 0)
    		{
    			high = i;
    		}
    		else
    		{
    			break;
    		}
    		
//    		System.out.print("Index: " + i);
//    		
//    		for(int ii = 0 ; ii < 6 - Integer.toString(i).length(); ii++) {
//    			
//    			System.out.print(" ");
//    			
//    		}
//    		
//    		System.out.print(" | Word: " + dictionary.get(i));
//    		
//    		for(int ii = 0 ; ii < 20 - dictionary.get(i).length(); ii++) {
//    			
//    			System.out.print(" ");
//    			
//    		}
//    		
//    		System.out.print(" | " + "Min: " + low + ", Max: " + high);
//    		
//    		for(int ii = 0 ; ii < 12 - Integer.toString(low).length() - Integer.toString(high).length(); ii++) {
//    			
//    			System.out.print(" ");
//    			
//    		}
//    		
//    		System.out.println(" | Comparison Value: " + dictionary.get(i).toLowerCase().compareTo(word.toLowerCase()));
    		
    	}
    	
		return count;

    }

    public static void main(String[] args) throws IOException
    {
        SpellChecker checker = new SpellChecker();
        String keyterm = "geek";
        int iterations = checker.linearSearch(keyterm);
        System.out.println("Linear search steps for \"" + keyterm + "\" = " + iterations);
        int count = checker.binarySearch(keyterm);
        System.out.println("Binary search steps for \"" + keyterm + "\" = " + count);
        
        PrintWriter output = new PrintWriter(myFile);
        
        output.write("Word,Linear Search Steps, Binary Search Steps");
        output.println();
        
        int steps = 1;
        
        for(String word : checker.dictionary)
        {
        	
        	output.write("\"" + word + "\"," + steps + "," + checker.binarySearch(word));
        	output.println();
        	
        	System.out.println("\"" + word + "\"," + steps + "," + checker.binarySearch(word));
        	steps++;
        }
        
        output.close();
        
    }
}