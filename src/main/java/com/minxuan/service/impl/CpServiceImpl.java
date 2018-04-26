package com.minxuan.service.impl;

import com.minxuan.dao.CpDao;
import com.minxuan.entity.CP;
import com.minxuan.service.ICpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service()
public class CpServiceImpl implements ICpService {

    @Autowired
    CpDao cpDao;

    @Override
    @Cacheable(value = "cp",key = "#id.toString()")
    public CP getCp(Integer id) {
        return cpDao.getCp(id);
    }
}
