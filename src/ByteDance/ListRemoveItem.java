package ByteDance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListRemoveItem {
    // 正确方法
    public static void remove1(List<String> list, String target) {
        for (int i = list.size() - 1; i >= 0; i--) {
            String item = list.get(i);
            if (target.equals(item)) {
                list.remove(item);
            }
        }
        print(list);
    }

    public static void remove32(List<String> list, String target){
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String item = iter.next();
            if (item.equals(target)) {
                iter.remove();
            }
        }
        print(list);
    }


    // 错误方法   先算size 再传入会出现数组越界的情况，后算会出现没删干净的情况
    public static void remove2(List<String> list, String target) {
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            if (target.equals(item)) {
                list.remove(item);
            }
        }
        print(list);
    }

    private static void print(List<String> list){
        for (String item : list) {
            System.out.println("元素值：" + item);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("beijing");
        list.add("shanghai");
        list.add("shanghai");
        list.add("guangzhou");
        list.add("shenzhen");
        list.add("hangzhou");
        remove2(list, "shanghai");
    }

}
