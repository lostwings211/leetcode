import java.util.*;
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int result = 0;
        if( num == null) {
            return result;
        }

        if (num.length < 3) {
            for(int i = 0; i < num.length; i++) {
                result += num[i];
            }
            return result;
        }
        
        int min_gap = (num[0] + num[1] + num[2] -target > 0) ? num[0] + num[1] + num[2] -target : target - (num[0] + num[1] + num[2]);
        int curr_gap = 0;

        MyQuickSort qs = new MyQuickSort();
        qs.sort(num);
        int[] sorted_num = qs.array;
       
        for(int index = 0; index < sorted_num.length; index++) { 
            int i = index + 1;
            int j = sorted_num.length -1;
            while(i<j) {
                int curr_val = sorted_num[index] + sorted_num[i] + sorted_num[j];
                if(curr_val == target) {
                    return curr_val;
                }
                else if (curr_val < target) {
                    i++;
                    curr_gap = target - curr_val;
                }
                else {
                    j--;
                    curr_gap = curr_val - target;
                }
                if (curr_gap <= min_gap) {
                    min_gap = curr_gap;
                    result =  curr_val;
                }
            }
        }
        return result;
    }
    
    public class MyQuickSort {
        public int array[];
        public int length;

        public void sort(int[] inputArr) {
            this.array = inputArr;
            if (inputArr == null || inputArr.length == 0) {
                return;
            }
            //this.array = inputArr;
            length = inputArr.length;
            quickSort(0, length - 1);
        }

        private void quickSort(int lowerIndex, int higherIndex) {
            int i = lowerIndex;
            int j = higherIndex;
            // calculate pivot number, I am taking pivot as middle index number
            int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
            // Divide into two arrays
            while (i <= j) {
                while (array[i] < pivot) {
                    i++;
                }
                while (array[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    exchangeNumbers(i, j);
                    //move index to next position on both sides
                    i++;
                    j--;
                }
            }
            // call quickSort() method recursively
            if (lowerIndex < j)
                quickSort(lowerIndex, j);
            if (i < higherIndex)
                quickSort(i, higherIndex);
        }

        private void exchangeNumbers(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}

