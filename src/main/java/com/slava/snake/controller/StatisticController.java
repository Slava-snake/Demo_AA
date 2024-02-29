package com.slava.snake.controller;

import com.slava.snake.dto.CollectedStatisticByAsin;
import com.slava.snake.dto.CollectedStatisticByDate;
import com.slava.snake.service.StatisticService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/stat")
public class StatisticController {

    @Autowired
    StatisticService statisticService;


    @GetMapping("/date")
    public ResponseEntity<CollectedStatisticByDate> getByDate(@RequestParam String date1,
            @RequestParam(required = false) String date2) {
        return ResponseEntity.ok(statisticService.getByDate(date1, date2 == null ? date1 : date2));
    }


    @GetMapping("/alldates")
    public ResponseEntity<CollectedStatisticByDate> getByAllDates() {
        return ResponseEntity.ok(statisticService.getByAllDates());
    }


    @GetMapping("/asin")
    public ResponseEntity<CollectedStatisticByAsin> getByAsin(@RequestParam List<String> asins) {
        return ResponseEntity.ok(statisticService.getByAsin(asins));
    }


    @GetMapping("/allasins")
    public ResponseEntity<CollectedStatisticByAsin> getByAllAsins() {
        return ResponseEntity.ok(statisticService.getByAllAsins());
    }

}
