package com.troyliu.maliu.unittest;

import com.troyliu.maliu.unittest.dao.IItemDao;
import com.troyliu.maliu.unittest.service.IItemService;
import com.troyliu.maliu.unittest.service.ItemServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ItemServiceTest {

    private IItemDao mockDao;
    private IItemService service ;

    @Before
    public void setup() {
        mockDao = mock(IItemDao.class) ;

        service = new ItemServiceImpl(mockDao) ;
    }

    @Test
    public void test_save() {
        service.save(any()) ;
        verify(mockDao).save(any()) ;
    }

    @Test
    public void test_save_with_return_1() {
        when(service.save(any())).thenReturn(1) ;
        Assert.assertEquals(1, service.save(any()));
    }

}
