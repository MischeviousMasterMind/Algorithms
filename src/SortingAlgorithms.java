import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class SortingAlgorithms {

	private static File myFile = new File("sorting-algorithm-times.csv");
	
	public SortingAlgorithms() {
		// TODO Auto-generated constructor stub
	}
	
	public static int[] bubbleSort(int[] data) 
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
		
		return data;
	}
	
	public static int[] insertionSort(int[] data)
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
		
		return data;
	}
	
	public static int[] selectionSort(int[] data) 
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
		
		return data;
	}
	
	public static int[] mergeSort(int[] elements)
    {
        int n = elements.length;
        int[] temp = new int[n];
        mergeSortHelper(elements, 0, n - 1, temp);
        
        return elements;
    }

    private static void mergeSortHelper(
        int[] elements, int from, int to, int[] temp)
    {
        if (from < to)
        {
            int middle = (from + to) / 2;
            mergeSortHelper(elements, from, middle, temp);
            mergeSortHelper(elements, middle + 1, to, temp);
            merge(elements, from, middle, to, temp);
        }
    }

    private static void merge(
        int[] elements, int from, int mid, int to, int[] temp)
    {
        int i = from;
        int j = mid + 1;
        int k = from;

        while (i <= mid && j <= to)
        {
            if (elements[i] < elements[j])
            {
                temp[k] = elements[i];
                i++;
            }
            else
            {
                temp[k] = elements[j];
                j++;
            }
            k++;
        }

        while (i <= mid)
        {
            temp[k] = elements[i];
            i++;
            k++;
        }

        while (j <= to)
        {
            temp[k] = elements[j];
            j++;
            k++;
        }

        for (k = from; k <= to; k++)
        {
            elements[k] = temp[k];
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

		int n		= 9999;
		int[] data	= generateRandomIntArray(n);
		
//		System.out.println(Arrays.toString(data));
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
		
		start = System.nanoTime();
		
		mergeSort(data);
		System.out.println("MERGE SORT");
		System.out.println("Sorting time: " + (System.nanoTime() - start) / 1000 + " miliseconds");
		System.out.println();
		
//		System.out.println(Arrays.toString(data));
		
		try
		{
			PrintWriter output = new PrintWriter(myFile);
			
			output.println("Number of Elements,Bubble Sort Time (ms),Selection Sort Time (ms),Insertion Sort Time (ms),Merge Sort Time (ms)");
			System.out.println("Number of Elements,Bubble Sort Time (ms),Selection Sort Time (ms),Insertion Sort Time (ms),Merge Sort Time (ms)");
			
			for(int i = 0; i <= 10000; i += 100) {
				
				int[] list = generateRandomIntArray(i);
				int bubbleSortTime = 0, insertionSortTime = 0, selectionSortTime = 0, mergeSortTime = 0;
				
				start = System.nanoTime();
				bubbleSort(list);
				bubbleSortTime = (int)(System.nanoTime() - start) / 1000;
				
				int[] sortedList = list;
				
				start = System.nanoTime();
				insertionSort(list);
				insertionSortTime = (int)(System.nanoTime() - start) / 1000;
				
				start = System.nanoTime();
				selectionSort(list);
				selectionSortTime = (int)(System.nanoTime() - start) / 1000;
				
				if(!sortedList.equals(list)) {
					System.out.println(":(");
					break;
				}
				
				start = System.nanoTime();
				mergeSort(list);
				mergeSortTime = (int)(System.nanoTime() - start) / 1000;
				
				output.println(i + "," + bubbleSortTime + "," + insertionSortTime + "," + selectionSortTime + "," + mergeSortTime);
				System.out.println(i + "," + bubbleSortTime + "," + insertionSortTime + "," + selectionSortTime + "," + mergeSortTime);
				
			}
			
			output.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
