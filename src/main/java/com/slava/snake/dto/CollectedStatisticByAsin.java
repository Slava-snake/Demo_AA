package com.slava.snake.dto;

import com.slava.snake.collection.StatAsin;
import lombok.Getter;

@Getter
public class CollectedStatisticByAsin {

    CollectedStatisticSalesByAsin sales = new CollectedStatisticSalesByAsin();

    CollectedStatisticTrafficByAsin traffic = new CollectedStatisticTrafficByAsin();

    private long count;


    public void amount(StatAsin stat) {
        this.sales.amount(stat.getSalesByAsin());
        this.traffic.amount(stat.getTrafficByAsin());
        count++;
    }


    public void average() {
        this.sales.average(count);
        this.traffic.average(count);
    }

}
