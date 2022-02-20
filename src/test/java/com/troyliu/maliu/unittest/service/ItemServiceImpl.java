package com.troyliu.maliu.unittest.service;

import com.troyliu.maliu.unittest.Item;
import com.troyliu.maliu.unittest.dao.IItemDao;

public class ItemServiceImpl implements IItemService {

    private IItemDao dao ;

    public ItemServiceImpl(IItemDao dao) {
        this.dao = dao ;
    }

    @Override
    public int save(Item item) {
        return dao.save(item) ;
    }

    @Override
    public int update(Item item) {
        return 0;
    }

}
