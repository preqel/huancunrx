package com.preqel.huncunrx;

/**
 * Created by preqel on 2018/10/2.
 */

public class SearchUtil {

    static int binarySearch(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;
        //说明array是排号序的,那么他们在哪里排序，在insert的时候排的
        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final int midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
    }

}
