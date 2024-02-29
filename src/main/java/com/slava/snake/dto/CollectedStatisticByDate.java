package com.slava.snake.dto;

import com.slava.snake.collection.StatDate;
import lombok.Getter;

@Getter
public class CollectedStatisticByDate {

    CollectedStatisticSalesByDate sales = new CollectedStatisticSalesByDate();

    CollectedStatisticTrafficByDate traffic = new CollectedStatisticTrafficByDate();

    private long count;


    public void amount(StatDate stat) {
        this.sales.amount(stat.getSalesByDate());
        this.traffic.amount(stat.getTrafficByDate());
        count++;
    }


    public void average() {
        this.sales.average(count);
        this.traffic.average(count);
    }

}
