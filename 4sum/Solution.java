import java.util.*;
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        MyQuickSort qs = new MyQuickSort();
        qs.sort(num);
        int[] sorted_num = qs.array;

        int index_1 = 0;
        while(index_1 < sorted_num.length) {
            int index_2 = index_1 + 1;
            while(index_2 < sorted_num.length) {
                int curr_val = sorted_num[index_1] + sorted_num[index_2];
                int curr_target =  target - curr_val;
                int i = index_2 + 1;
                int j = sorted_num.length -1;

                while(i<j) {
                    if(sorted_num[i] + sorted_num[j] == curr_target) {
                        List<Integer> curr_quadruplet = new ArrayList<Integer>();
                        curr_quadruplet.add(sorted_num[index_1]);
                        curr_quadruplet.add(sorted_num[index_2]);
                        curr_quadruplet.add(sorted_num[i]);
                        curr_quadruplet.add(sorted_num[j]);
                        results.add(curr_quadruplet);

                        i++;
                        while(i < j -1 && sorted_num[i] == sorted_num[i-1]) {
                            i++;
                        }
                        j--;
                        while (j > i + 1 && sorted_num[j] == sorted_num[j+1]) {
                            j--;
                        }
                    }
                    else if (sorted_num[i] + sorted_num[j] < curr_target) {
                        i++;
                        while(i < j -1 && sorted_num[i] == sorted_num[i-1]) {
                            i++;
                        }
                    }
                    else {
                        j--;
                        while (j  > i + 1 && sorted_num[j] == sorted_num[j+1]) {
                            j--;
                        }
                    }
                }
                
                index_2++;
                while(index_2 < sorted_num.length - 1 && sorted_num[index_2 - 1] == sorted_num[index_2]) {
                    index_2++;
                }
            }

            index_1++;
            while(index_1 < sorted_num.length - 1 && sorted_num[index_1] == sorted_num[index_1 -1]) {
                index_1++;
            }
        }
        return results;
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
