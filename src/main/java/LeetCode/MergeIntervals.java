package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {

    public static void main(String args[]) {
        LinkedList<int[]> input = new LinkedList<>();
        input.add(new int[]{1, 3});
        input.add(new int[]{2, 6});
        input.add(new int[]{8, 10});
        input.add(new int[]{15, 18});
        int[][] result = merge(input.toArray(new int[input.size()][]));
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int[][] merge(int[][] intervals) {
//        Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    private static class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {

            return o1[0] < o2[0] ? -1 : o1[0] == o2[0] ? 0 : 1;
        }
    }
}
