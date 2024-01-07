package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{"Winter", "Spring", "Summer", "Autumn"};
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] arr = new int[length];

        for (int i=0; i<length; i++) {
            arr[i] = i+1;
        }

        return arr;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int total = 0;

        for (int i=0; i<arr.length; i++) {
            total += arr[i];
        }

        return total;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        int index = -1;

        for (int i=0; i<arr.length; i++) {
            if (number==arr[i]) {
                index = i;
                break;
            }
        }

        return index;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        int len = arr.length;
        String[] reverseArr = new String[len];

        for (int i=0; i<len; i++) {
            int k = i+1;
            reverseArr[i] = arr[len-k];
        }

        return reverseArr;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int countPosit = 0;

        for (int i=0; i<arr.length; i++) {
            if (arr[i]>0) {
                countPosit++;
            }
        }

        int[] posArr = new int[countPosit];
        int j = 0;

        for (int i=0; i<arr.length; i++) {
            if (arr[i]>0) {
                posArr[j] = arr[i];
                j++;
            }
        }

        return posArr;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        // first we sort each array of the main array (arr[i][j])
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length-1; j++) {
                for (int k=j+1; k<=arr[i].length-1; k++) {
                    if (arr[i][j]>arr[i][k]) {
                        int min = arr[i][k];
                        arr[i][k] = arr[i][j];
                        arr[i][j] = min;
                    }
                }
            }
        }

        // then we sort the main array by its length
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j<=arr.length-1; j++) {
                if (arr[i].length>arr[j].length) {
                    int[] temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        ArrayTasks arrayTasks = new ArrayTasks();

        for (String s: arrayTasks.seasonsArray()) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (int i: arrayTasks.generateNumbers(4)) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] arr = {3, 4, 5, -3};
        System.out.println(arrayTasks.totalSum(arr));

        System.out.println(arrayTasks.findIndexOfNumber(arr, -5));

        String[] arr1 = {"pineapple", "apple", "pen"};
        for (String s: arrayTasks.reverseArray(arr1)) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (int i: arrayTasks.getOnlyPositiveNumbers(arr)) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        int[][] arr2 = {{5, 4}, {7}};
        for (int[] i: arrayTasks.sortRaggedArray(arr2)) {
            for (int j: i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
