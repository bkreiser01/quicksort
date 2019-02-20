import java.util.*;

public class Quicksort
{
    public static void main(String [] args)
    {
        int rnd;
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("What is the maximum number you would like to generate?");
        int max = keyboard.nextInt();
        System.out.println();

        System.out.println("What is the minimum number you would like to generate?");
        int min = keyboard.nextInt();
        System.out.println();

        int range = (max - min) + 1;

        System.out.println("How large would you like the array to be?");
        int arraySize = keyboard.nextInt();
        System.out.println();

        int[] array = new int[arraySize];

        for(int i = 0; i < array.length; i++)
        {
            rnd = (int) (Math.random() * range) + min;

            array[i] = rnd;
        }

        System.out.println("UNSORTED");
        System.out.println("-----------------------");
        printArray(array);

        quickSort(array);

        System.out.println("SORTED");
        System.out.println("-----------------------");
        printArray(array);


    } 

    public static void printArray(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void quickSort(int[] array)
    {
        quickSort(array, 0, array.length -1);
    }

    private static void quickSort(int[] array, int start, int end)
    {
        if(end > start)
        {
            int endOfLeftPart = partition(array, start, end);
            quickSort(array, start, endOfLeftPart);
            quickSort(array, endOfLeftPart + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end)
    {
        int leftFinger = start - 1;
        int rightFinger = end + 1;
        int pivot = array[start];
        int temp;

        while(true)
        {
            do
                rightFinger--;
            while (array[rightFinger] > pivot);

            do
                leftFinger++;
            while (array[leftFinger] < pivot);

            if(leftFinger >= rightFinger)
                return rightFinger;
            else
                temp = array[leftFinger];
                array[leftFinger] = array[rightFinger];
                array[rightFinger] = temp;
        }
    }
}