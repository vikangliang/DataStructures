package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Greedy {
    public static void main(String args[]) {
        HashMap<String, HashSet<String>> hashMap = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("1");
        hashSet1.add("2");
        hashSet1.add("3");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet1.add("4");
        hashSet1.add("1");
        hashSet1.add("5");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet1.add("6");
        hashSet1.add("2");
        hashSet1.add("7");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet1.add("2");
        hashSet1.add("3");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet1.add("7");
        hashSet1.add("8");

        hashMap.put("k1", hashSet1);
        hashMap.put("k2", hashSet2);
        hashMap.put("k3", hashSet3);
        hashMap.put("k4", hashSet4);
        hashMap.put("k5", hashSet5);

//        存放所有地区
        HashSet<String> all = new HashSet<>();
        all.add("1");
        all.add("2");
        all.add("3");
        all.add("4");
        all.add("5");
        all.add("6");
        all.add("7");
        all.add("8");

//        存放选择的电台
        ArrayList<String> arrayList = new ArrayList<>();
        HashSet<String> temp = new HashSet<>();
        String maxkey = null;
        while (all.size() != 0) {
            maxkey = null;
            for (String key : all) {
                temp.clear();
                HashSet<String> areas = new HashSet<>();
                temp.addAll(areas);
                temp.retainAll(all);
                if (temp.size() > 0 && (maxkey == null || temp.size() > hashMap.get(maxkey).size())) {
                    maxkey = key;
                }
            }
            if (maxkey != null) {
                arrayList.add(maxkey);
                all.retainAll(hashMap.get(maxkey));
            }
        }
    }
}
