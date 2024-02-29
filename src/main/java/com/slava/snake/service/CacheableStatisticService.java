package com.slava.snake.service;

import com.slava.snake.collection.ReportCollection;
import com.slava.snake.collection.StatAsin;
import com.slava.snake.collection.StatDate;
import com.slava.snake.dto.CollectedStatisticByAsin;
import com.slava.snake.dto.CollectedStatisticByDate;
import com.slava.snake.repository.DemoAARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CacheableStatisticService {

    @Autowired
    DemoAARepository repo;

    public static ReportCollection coll;


    @Cacheable(value = "byDate", key = "#date")
    StatDate getStatbyDate(String date) {
        log.warn("------Cache miss on call \"getStatbyDate({})\"", date);
        return coll.getSalesAndTrafficByDate().stream()
                    .parallel()
                    .filter(s -> s.getDate().equals(date))
                    .findAny().get();
    }
    
    
    @Cacheable("alldates")
    public CollectedStatisticByDate getByAllDates() {
        log.warn("-----Cache miss on call \"getByAllDates\"");
        CollectedStatisticByDate result = new CollectedStatisticByDate();
        coll.getSalesAndTrafficByDate().stream().forEach(result::amount);
        result.average();
        return result;
    }
    
    
    @Cacheable("allasins")
    public CollectedStatisticByAsin getByAllAsins() {
        log.warn("-----Cache miss on call \"getByAllAsins\"");
        CollectedStatisticByAsin result = new CollectedStatisticByAsin();
        coll.getSalesAndTrafficByAsin().stream().forEach(result::amount);
        result.average();
        return result;
    }
    
    
    @Cacheable(value = "byAsin", key = "#asin")
    StatAsin getStatByAsin(String asin) {
        log.warn("-----Cache miss on call \"getStatByAsin({})\"", asin);
        return coll.getSalesAndTrafficByAsin().stream()
                    .parallel()
                    .filter(s -> s.getParentAsin().equals(asin))
                    .findAny().get();
    }

}
