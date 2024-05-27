package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class TripletWithNearToSum {


    static int threeSumClosest(int[] array, int target) {
        int flag = 0; //flag variable to check if result is found
        int n = array.length;
        int result = Integer.MAX_VALUE; //initialize result variable
        Arrays.sort(array);    //sort the array

        for (int i = 0; i < n - 2; ++i) //iterate through the array
        {
            int j = i + 1, k = n - 1;   //initialize two pointers

            while (j < k)  //iterate until the pointers meet
            {
                int sum = array[i] + array[j] + array[k]; //calculate sum of three elements

                if (flag != 1) {   //check if no result is found yet
                    result = sum;  //initialize result with the first sum
                    flag = 1;   //set flag to 1 to indicate result is found
                }


                if (Math.abs(sum - target) < Math.abs(result - target)) //compare the absolute difference between sum and target with current result
                    result = sum; //update result if the absolute difference is smaller

                else if (Math.abs(sum - target) == Math.abs(result - target)) { //if the absolute differences are equal
                    if (sum > result) //choose the sum with a greater value
                        result = sum;
                }

                if (target > sum) //move the left pointer if target is greater than sum
                    j++;
                else
                    k--; //move the right pointer if target is smaller than sum
            }
        }
        return result; //return the result
    }

    boolean tripletHasSum(int[] arr, int n, int sum) {


        for (int i = 0; i < n - 2; i++) {

            if (pairHasSum(arr, n, sum - arr[i], i + 1)) {
                return true;
            }
        }

        return false;
    }

    boolean pairHasSum(int[] arr, int n, int sum, int start) {

        int low = start;
        int high = n - 1;
        while (low < high) {

            if (arr[low] + arr[high] == sum) {
                return true;
            } else if (arr[low] + arr[high] > sum) {
                high--;
            } else {
                low++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 5};
        int target = 13;
//        int[] arr = {-7, 1, 1, 3, 8, 9};
//        int target = 2;
        int res = threeSumClosest(arr, target);
        System.out.println(res);
    }
}
