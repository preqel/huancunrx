package com.preqel.huncunrx;

import android.util.Log;

/**
 * Created by preqel on 2018/9/13.
 */

public class FastSort {

    int[] list = {5, 3, 1, 2, 4, 9};

    public void doFastSort() {
        fastSort(list, 0, list.length-1);
    }

    public void fastSort(int[] number, int start, int end) {
        if(start< end) {
            int middle = findMiddle(list, start, end);
            fastSort(list, start, middle - 1);
            fastSort(list, middle + 1, end);
        }
    }

    public void pirntResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            sb.append(list[i] + " ");
        }
        System.out.println("快速排序result"+ sb.toString());
    }

    private int findMiddle(int[] list,int low,int hign) {

        int temp = list[low];

        while (low < hign) {

            while (low < hign && list[hign] > temp) {
                    hign--;
            }
            list[low] = list[hign];

            while (low < hign && list[low] < temp) {
                    low++;
            }
            list[hign] = list[low];

        }
        list[low] = temp;
        return hign;
    }
}
