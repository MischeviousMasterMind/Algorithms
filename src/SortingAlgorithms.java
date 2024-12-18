import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class SortingAlgorithms {

	private static File myFile = new File("sorting-algorithm-times.csv");
	
	public SortingAlgorithms() {
		// TODO Auto-generated constructor stub
	}
	
	public static void bubbleSort(int[] data) 
	{
		boolean swapped = true;
		
		for(int i = data.length - 1; i > 1 && swapped; i--) 
		{
			swapped = false;
			
			for(int ii = 0; ii < i; ii++) 
		    {	
				if (data[ii] > data[ii + 1]) {
					int temp 		= data[ii];
					data[ii] 		= data[ii + 1];
					data[ii + 1] 	= temp;
					swapped			= true;
				}
			}		
		}	
	}
	
	public static void insertionSort(int[] data)
	{
		for(int i = 0; i < data.length; i++)
		{		
			int smallest = data[i], index = i;
			for(int ii = i; ii < data.length; ii++)
			{
				if(data[ii] < smallest)
				{ 
					smallest = data[ii];
					index = ii;
				}
			}	
			
			int temp 	= data[i];		
			data[i] 	= data[index];
			data[index] = temp;	
		}
	}
	
	public static void selectionSort(int[] data) 
	{
		for(int i = 1; i < data.length; i++)
		{
			for(int ii = i; i > 1 && data[ii] < data[i - 1]; i--)
			{
				if(data[ii] >= data[i - 1])
				{
					int temp 	= data[i];		
					data[i] 	= data[ii];
					data[ii] = temp;	
				}
			}
		}
	}
	
	public static int[] generateRandomIntArray(int n) {
		
		int [] data = new int[n];
		
		for(int i = 0; i < data.length; i++)
		{
			
			data[i] = (int)(Math.random() * Integer.MAX_VALUE);
			
		}
		
		return data;
		
	}
	
	public static void main(String[] args)
	{

		int n		= 1000;
		int[] data	= generateRandomIntArray(n);
		
		System.out.println(Arrays.toString(data));
		System.out.println();
		
		long start = System.nanoTime();
		
		bubbleSort(data);
		System.out.println("BUBBLE SORT");
		System.out.println("Sorting time: " + (System.nanoTime() - start) / 1000 + " miliseconds");
		System.out.println();
		
		start = System.nanoTime();
		
		insertionSort(data);
		System.out.println("SELECTION SORT");
		System.out.println("Sorting time: " + (System.nanoTime() - start) / 1000 + " miliseconds");
		System.out.println();
		
		start = System.nanoTime();
		
		selectionSort(data);
		System.out.println("INSERTION SORT");
		System.out.println("Sorting time: " + (System.nanoTime() - start) / 1000 + " miliseconds");
		System.out.println();
		
		System.out.println(Arrays.toString(data));
		
		try
		{
			PrintWriter output = new PrintWriter(myFile);
			
			output.println();
			
			for(int i = 1; i < 10; i++) {
				
				int[] list = generateRandomIntArray(i);
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
