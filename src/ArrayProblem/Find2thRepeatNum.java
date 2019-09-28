package ArrayProblem;

import java.util.*;

public class Find2thRepeatNum {
    //找出数组中第二多重复的元素
    public int findSecond(int[] nums) {
        Map map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int val = (int) map.get(nums[i]);
                map.put(nums[i], val + 1);
            }
        }
        map = sortByValue(map);
        Set<Integer> keys = map.keySet();
        int index = 0;
        for (Iterator it = keys.iterator(); it.hasNext(); index++) {
            if (index == 1){
                Integer s = (Integer) it.next();
                return (int)map.get(s);
            }
        }
        return -1;
    }

    public Map sortByValue(Map map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {
            // 将链表按照值 从小到大进行排序
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
            }
        });
        Map result = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
