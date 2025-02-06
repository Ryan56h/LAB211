    package Week_3;

    import java.util.Scanner;

    public class BubbleSort {

        private int arr[];
        private int x;

    public BubbleSort() {
    }

        public BubbleSort(int[] arr, int x) {
            this.arr = arr;
            this.x = x;
        }
        Scanner scanner = new Scanner(System.in);

        public int checkInputInteger() {

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

        public int inputSizeOfArray() {
            System.out.println("Enter the size of array: ");
            int n = checkInputInteger();
            return n;
        }
        public int[] inputNumberOfArray(int x){
            int a[] = new int[x];
            for (int i = 0; i< x; i++){
                System.out.print("Enter a[" +i+ "]: ");
                a[i] = checkInputInteger();
            }
            return a;
        }
        public void bubbleSort(int[] arr){
            System.out.print("Unsorted array: ");
            for(int i = 0; i<arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            for (int i =0 ; i< arr.length - 1 ; i++){
                for (int j = 0; j < arr.length -1; j++){
                    if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            }System.out.println();
             System.out.print("Sorted array: ");
            for(int i = 0; i<arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            
        }
       

    }
