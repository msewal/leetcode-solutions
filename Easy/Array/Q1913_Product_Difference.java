/*
 * @author OmerZeyveli (on Github)
 * Leetcode User Name: Riive
 * Leetcode Question 1913: Maximum Product Difference Between Two Pairs.
 * Fastest Solution.
 */

// This code runs with 3 methods for runtime speed.
// In the question for the maximum diffrence, we multiply the largest 2 numbers and smallest 2 numbers.
// We calculate the maximum value by checking every element of array and returning the largest one.
// Our code also replaces that max value with 0 in array. It helps us get the second largest value afterwards.
// Same goes for minimum value, except we need to check if the current element is smaller than one.
// Its because there can't be any number smaller than one in our given array,
// except the ones we replaced with 0 when we calculate the max values.

class Solution {
    public static int maxProductDifference(int[] nums) {
        // Product Difference.
        return (arrMax(nums) * arrMax(nums)) - (arrMin(nums) * arrMin(nums));
    }

    public static int arrMax(int[] nums){
        int len = nums.length; // Length of array.
        int max = 0, element = 0; // Maximum value and index of it.
        // Max value is searched for every element of array. When found, its replaced with 0.
        for(int i = 0; i < len; i++){
            if(max < nums[i]){
                max = nums[i];
                element = i;
            }
        }
        nums[element] = 0;
        return max;
    }

    public static int arrMin(int[] nums){
        int len = nums.length; // Length of array.
        int min = 10000, element = 0; // Minimum value and index of it.
        // Min value is searched for every element of array. When found, its replaced with 0.
        for(int i = 0; i < len; i++){
            // Ignoring the elements we replaced with 0.
            if(nums[i] < 1){ continue; }
            if(min > nums[i]){
                min = nums[i];
                element = i;
            }
        }
        nums[element] = 0;
        return min;
    }
}
