/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week_3;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class QuickSort {

    Scanner scanner = new Scanner(System.in);

    int arr[];

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    public QuickSort() {
    }

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

   public void generateRandom(int size) {
        arr = new int[size];
        Random ran = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(size * 10);
        }
    }

    public int partition(int left, int right) {
        int pivot = arr[(left + right) / 2];

        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    public void quickSort(int left, int right) {
        if (left < right) {
            int pivot = partition(left, right);
            quickSort(left, pivot - 1);
            quickSort(pivot, right);
        }
    }

    public void display() {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

 
}
