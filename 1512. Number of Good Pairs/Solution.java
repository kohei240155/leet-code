import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * nums の中で「good pair」の数を返す。
     * good pair = (i, j) で i < j かつ nums[i] == nums[j]
     *
     * @param nums 入力配列
     * @return good pair の総数
     */
    public int numIdenticalPairs(int[] nums) {
        // 各値のこれまでの出現回数を記録するマップ
        Map<Integer, Integer> countMap = new HashMap<>();
        int goodPairs = 0;

        for (int num : nums) {
            // もしこの num をこれまでに見た回数が k 回なら、
            // 新たに出現するたびに k 個の good pair が作れる
            goodPairs += countMap.getOrDefault(num, 0);

            // 出現回数を増やす
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        return goodPairs;
    }
}
