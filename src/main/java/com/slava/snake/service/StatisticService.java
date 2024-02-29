package com.slava.snake.service;

import com.slava.snake.collection.ReportCollection;
import com.slava.snake.dto.CollectedStatisticByAsin;
import com.slava.snake.dto.CollectedStatisticByDate;
import com.slava.snake.repository.DemoAARepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {

    ReportCollection coll;
    
    CacheableStatisticService service;
    
    RefreshService refreshService;
    
    DemoAARepository repo;
    
    
    @Autowired
    public StatisticService(DemoAARepository repo, RefreshService refreshService,
            CacheableStatisticService service) {
        this.repo = repo;
        this.service = service;
        this.refreshService = refreshService;
    }

   
    ReportCollection getColl() {
        if (!RefreshService.freshed) {
            while (RefreshService.id == null && !RefreshService.freshed) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            CacheableStatisticService.coll = repo.findById(RefreshService.id.toString()).get();
            RefreshService.freshed = true;
        }
        return CacheableStatisticService.coll;
    }
    
    
    public CollectedStatisticByDate getByDate(String date1, String date2) {
        CollectedStatisticByDate result = new CollectedStatisticByDate();
        getColl().getSalesAndTrafficByDate().stream()
                .parallel()
                .filter(s -> {
                            String d = s.getDate();
                            return d.compareTo(date1) >= 0 && d.compareTo(date2) <= 0;
                        })
                .forEach(s -> result.amount(service.getStatbyDate(s.getDate())));
        result.average();
        return result;
    }

    
    public CollectedStatisticByAsin getByAsin(final List<String> asins) {
        CollectedStatisticByAsin result = new CollectedStatisticByAsin();
        getColl().getSalesAndTrafficByAsin().stream()
                .filter(s -> asins.contains(s.getParentAsin()))
                .forEach(s -> result.amount(service.getStatByAsin(s.getParentAsin())));
        result.average();
        return result;
    }


    public CollectedStatisticByDate getByAllDates() {
        getColl();
        return service.getByAllDates();
    }


    public CollectedStatisticByAsin getByAllAsins() {
        getColl();
        return service.getByAllAsins();
    }

}
