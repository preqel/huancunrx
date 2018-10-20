package com.preqel.huncunrx;

import android.view.animation.AnimationUtils;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void subition_isCorrect() throws Exception {
        int[] arra = new int[]{5, 1, 10, 23, 34, 2};
        int result = SearchUtil.binarySearch(arra, 6, 23);
        assertEquals(3, result);
    }

    @Test
    public void testTete() throws Exception{
        int[] sy= new int[]{23,21,2,34};
        assertEquals(sy[0],23);
    }

    @Test
    public void testWak() throws  Exception{
        HashMap<Zebra,String> hashMap = new HashMap<>();
        Zebra animal = new Zebra("234");
        Zebra animal2= new Zebra("234");
        if(animal.equals(animal2)){
            System.out.println("preqel");
        }
        hashMap.put(animal,"1");
        hashMap.put(animal2,"1");
        System.out.print(hashMap.size());
        assertEquals(1,1);
    }
}