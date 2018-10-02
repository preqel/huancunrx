package com.preqel.huncunrx;

import android.util.Log;

/**
 * Created by preqel on 2018/9/13.
 */

public class FastSort {

    int[] list = {5,3,1,2,5,9};

    public void doFastSort(){
        fastSort(list,0,list.length);
    }

    public void  fastSort(int[] number,int start,int end){
        int middle = findMiddle(list);
       // fastSort(list, 0, middle);
      //  fastSort(list, middle, list.length-1);
    }

    public void pirntResult(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.length;i++){
            sb.append(list[i]+" ");
        }
        Log.d("TAG","fastsort "+sb.toString());
    }

    private int findMiddle(int[] list) {
        int temp = list[0];
        int low = 0;
        int hign = list.length-1;
        while(low < hign){

            for(int i=low;i<hign;i++){
                if(list[low]>= list[i]){
                    list[low]= list[i];
                    list[i] = temp;
                }
                low ++;
            }

            for(int j = hign ;j>low;j--){
                if (list[hign] > list[j]) {
                    list[hign] = list[j];
                    list[hign] = temp;
                }
                hign--;
            }
        }
        return hign;
    }
}
