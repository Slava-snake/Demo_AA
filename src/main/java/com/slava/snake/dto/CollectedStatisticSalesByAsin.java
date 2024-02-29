package com.slava.snake.dto;

import com.slava.snake.collection.SalesByAsin;
import lombok.Getter;

@Getter
public class CollectedStatisticSalesByAsin {

    long unitsOrdered;

    long unitsOrderedB2B;

    long totalOrderItems;

    long totalOrderItemsB2B;


    public void amount(SalesByAsin sales) {
        this.unitsOrdered += sales.getUnitsOrdered();
        this.unitsOrderedB2B += sales.getUnitsOrderedB2B();
        this.totalOrderItems += sales.getTotalOrderItems();
        this.totalOrderItemsB2B += sales.getTotalOrderItemsB2B();
    }


    public void average(long count) {
        // certain fields divide by count
    }

}
