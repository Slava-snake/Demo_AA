package com.slava.snake.collection;

import org.springframework.data.mongodb.core.index.Indexed;
import lombok.Data;

@Data
public class StatAsin {

    @Indexed
    String parentAsin;
    
    SalesByAsin salesByAsin;
    
    TrafficByAsin trafficByAsin;
    
}
