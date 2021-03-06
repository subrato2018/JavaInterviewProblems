/**
 * [ Goo 12_C ] [ Find top k most frequent Number in Array ]
 * ____________________________________________________________________________________________________________________
 arr :  1, 5, 2, 1, 3, 2, 1 , 1, 5, 5,5, 5,5, 5,5
 o/p: [5, 1, 2]


 */

package GooPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _Goo_12_c_Top_K_Most_Frequent_Number {

    public static void mostPopularNumberUsingBucketSort(int [] nums, int k){

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        System.out.println(res);
    }

    public static void main (String[] args) {
        int arr[] = {1, 5, 2, 1, 3, 2, 1 , 1, 5, 5,5, 5,5, 5,5};
        int topK = 3;
        mostPopularNumberUsingBucketSort(arr, topK);
    }
}
