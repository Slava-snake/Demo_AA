package com.slava.snake.collection;

import org.springframework.data.mongodb.core.index.Indexed;
import lombok.Data;


@Data
public class StatDate {

    @Indexed
    String date;

    SalesByDate salesByDate;

    TrafficByDate trafficByDate;

}
