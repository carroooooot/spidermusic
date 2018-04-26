package com.minxuan.controller;

import com.google.common.collect.Lists;
import com.minxuan.dao.DemandRecoedESDao;
import com.minxuan.entity.CP;
import com.minxuan.entity.DemandRecord;
import com.minxuan.service.ICpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@EnableAutoConfiguration
@RequestMapping("/testspringboot/")
public class TestSpringBootController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    ICpService cpService;

    @Autowired
    DemandRecoedESDao demandRecoedESDao;

    @RequestMapping("getCp")
    public CP getCp(){
        CP cp = cpService.getCp(1);
        return  cp;

    }

    @RequestMapping("getDemandRecord")
    public List<DemandRecord> getDemandRecode(){
        Iterable<DemandRecord> all = demandRecoedESDao.findAll(new Sort(Sort.Direction.DESC,"times"));
        List<DemandRecord> demandRecords = Lists.newArrayList(all);
        return demandRecords;
    }


}
