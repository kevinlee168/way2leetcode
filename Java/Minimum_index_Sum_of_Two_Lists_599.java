package leetcode.Java;

import java.util.ArrayList;
import java.util.HashMap;

public class Minimum_index_Sum_of_Two_Lists_599 {
    /*
     思路：利用哈希表 Hashtable 解决问题
     首先，遍历第一个数组，将每个元素映射到 hashtable 中。
     然后，遍历第二个数组，查询在 hashtable 是否存在该元素
     */

    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null) return null;

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            hashMap.put(list1[i], i);
        }

        ArrayList<String> resList = new ArrayList<>();
        //用来寻找共同元素的最小sum的索引
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (hashMap.containsKey(list2[i])) {
                int indexSum = i + hashMap.get(list2[i]);
                if (sum > indexSum ) {
                    sum = indexSum;
                    //找到比当前sum更小的共同元素索引之和，应该清空结果数组，重新添加更小index的元素
                    resList.clear();
                    resList.add(list2[i]);
                } else if (sum == indexSum) {
                    resList.add(list2[i]);
                }
            }
        }

        return resList.toArray(String[]::new);
    }

}
