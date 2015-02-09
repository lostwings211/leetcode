public class Solution {
    public double findMeidanSortedArrays(int A[], int B[]) {
        double result;
        int a_length = (A != null) ? A.length : 0;
        int b_length = (B != null) ? B.length : 0;
        int total_length = a_length + b_length;
        if (total_length == 0)
            return 0.0;
        int[] combined = new int[total_length];
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < a_length || j < b_length) {
            if (i == a_length) {
                while (j < b_length) {
                    combined[index++] = B[j++];
                }
                break;
            }
            if (j == b_length) {
                while (i < a_length) {
                    combined[index++] = A[i++];
                }
                break;
            }
            if (A[i] < B[j]) {
                combined[index] = A[i];
                i++;
            } else {
                combined[index] = B[j];
                j++;
            }
            index++;
        }

        if (total_length % 2 == 1) {
            result = combined[total_length / 2];
        } else {
            result = (combined[total_length / 2 - 1] + combined[total_length / 2]) / 2.0;
        }
        return result;
    }
}
