package com.preqel.huncunrx;

import org.junit.Test;

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
}