package ru.sbt.jschool.session1;

import java.util.*;

public class Problem7 {
    public static long[] intersection(long[] arr1, long[] arr2) {
        Set<Long> set1 = new HashSet<>();
        for (long l : arr1) set1.add(l);
        Set<Long> result = new LinkedHashSet<>();
        for (long l : arr2) {
            if (set1.contains(l)) result.add(l);
        }
        long[] res = new long[result.size()];
        int idx = 0;
        for (long l : result) res[idx++] = l;
        return res;
    }
}
