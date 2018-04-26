package com.minxuan.dao;

import com.minxuan.entity.DemandRecord;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface DemandRecoedESDao extends ElasticsearchRepository<DemandRecord,String> {

}
