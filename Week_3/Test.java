package Week_3;
import java.util.Scanner;
public class Test{
    
    public int checkInputInteger() {
Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a double number! ");
                System.out.println("Enter again: ");
            }
        }
    }
    public static void main(String[] args){
//Bubble Sort      
        // BubbleSort bbs = new BubbleSort();
        //   int x = bbs.inputSizeOfArray();
        //    int[] arr = bbs.inputNumberOfArray(x);         
        //     bbs.bubbleSort(arr); 
        

//Quick Sort
                // QuickSort qs = new QuickSort();
                // System.out.print("Enter array size: ");     
                // int size = qs.checkInputInteger();
                // qs.generateRandom(size);
                // System.out.println("Unsorted array: ");
                // qs.display();
                // System.out.println("Sorted array: ");
                // qs.quickSort(0, size - 1);
                // qs.display();
        

//Binary Search
                // BinarySearch bs = new BinarySearch();
                // System.out.print("Enter number elements of array: ");
                // int size = bs.checkInputInteger();
                // bs.arr = new int [size];
                // bs.generateRandom();
                // System.out.print("Enter value to search: ");
                // int search = bs.checkInputInteger();
                // System.out.println("Unsorted array: ");
                // bs.displayArray();
                // System.out.println("Sorted Array: ");
                // bs.sortArray();
                // bs.displayArray();
                // int foundIndex = bs.binarySearch(bs.arr, search);
                // if (foundIndex == -1) {
                //     System.out.println("Not found");
                // } else {
                //     System.out.println("Found " + search + " at index: " + foundIndex);
                // } 
                

//Stack
                Stack stack = new Stack();
                stack.push(10);
                stack.push(20);
                stack.push(30);
                stack.push(40);
                
                System.out.println("Popped element is: " + stack.pop().data);
                System.out.println("Top element is: " + stack.get());
               
                stack.display();
    }


}
