package com.slava.snake.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slava.snake.collection.ReportCollection;
import com.slava.snake.repository.DemoAARepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Component
@EnableScheduling
@Slf4j
public class RefreshService {

    @Value("${init_db}")
    private String refreshFileName;

    @Value("${db_collection}")
    private String collectionName;

    public static ObjectId id;

    @Autowired
    DemoAARepository repo;

    @Autowired
    CacheManager cacheManager;
    
    public static boolean freshed = false;

    
    @Scheduled(fixedDelayString = "${refreshTime}")
    @Caching(evict = {@CacheEvict(cacheNames = {"byDate"}, allEntries=true),
                     @CacheEvict(cacheNames = {"byAsin"}, allEntries=true),
                     @CacheEvict(cacheNames = {"alldates"}, allEntries=true),
                     @CacheEvict(cacheNames = {"allasins"}, allEntries=true)})
    public void refresh() {
        log.info(" +++ Refresh collection");
        try {
            String json = new String(Files.readAllBytes(Paths.get(refreshFileName)));
            ReportCollection coll = new ObjectMapper().readValue(json, ReportCollection.class);
            if (id != null)
                coll.set_id(id);
            coll = repo.save(coll);
            id = coll.get_id();
            freshed = false;
            log.info("id={} , freshed={}", id, freshed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
