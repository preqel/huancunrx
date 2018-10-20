package com.preqel.huncunrx;

import com.preqel.mockito.IDataHelper;
import com.preqel.mockito.IEnvironmentHelper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MeeUnitTest {

    FastSort fastSort;

    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void subition_isCorrect() throws Exception {
        int[] arra = new int[]{5, 1, 10, 23, 34, 2};
      //  fastSort.doFastSort(); //todo 完成快速排序
       // int result = SearchUtil.binarySearch(arra, 6, 23);
        assertEquals(3, 3);
    }

    @Test
    public void testOne(){
        List list = mock(List.class);
        when(list.get(0)).thenReturn("11");
        assertEquals(1,1);
        System.out.println(list.get(0  ));
        System.out.println(list.get(1));

        list.add("1");
        list.add("2");
        System.out.println(list.get(0  ));
        System.out.println(list.get(1));
        System.out.println(list.size());
        verify(list, times(1)).get(0);
    }

    @Test
    public void testVerify(){
        List list = new LinkedList<String>();
        List spy = spy(list);
        spy.add("hello");
        when(spy.get(0)).thenReturn("hello world");
        System.out.print(spy.get(0));
    }

    @Test
    public void testFastSortTemp() {
       FastSort fastSort = new FastSort();
       fastSort.doFastSort( );
       fastSort.pirntResult();
    }

}