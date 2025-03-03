package Week_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {

    int[] arr;

    public BinarySearch(int[] arr) {
        this.arr = arr;
    }

    public BinarySearch() {
    }

    public void displayArray() {
        System.out.println(Arrays.toString(arr));
    }

    

    public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public void sortArray() {
        Arrays.sort(arr);
    }

    public void generateRandom() {

        Random ran = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(arr.length * 10);
        }
    }

   
}
