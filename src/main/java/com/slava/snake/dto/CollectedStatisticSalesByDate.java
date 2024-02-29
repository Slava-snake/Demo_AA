package com.slava.snake.dto;

import com.slava.snake.collection.SalesByDate;
import lombok.Getter;

@Getter
public class CollectedStatisticSalesByDate {

    long unitsOrdered;

    long unitsOrderedB2B;

    long totalOrderItems;

    long totalOrderItemsB2B;

    long unitsRefunded;

    long claimsGranted;

    long unitsShipped;

    long ordersShipped;


    public void amount(SalesByDate sales) {
        this.unitsOrdered += sales.getUnitsOrdered();
        this.unitsOrderedB2B += sales.getUnitsOrderedB2B();
        this.totalOrderItems += sales.getTotalOrderItems();
        this.totalOrderItemsB2B += sales.getTotalOrderItemsB2B();
        this.unitsRefunded += sales.getUnitsRefunded();
        this.claimsGranted += sales.getClaimsGranted();
        this.unitsShipped += sales.getUnitsShipped();
        this.ordersShipped += sales.getOrdersShipped();
    }


    public void average(long count) {
        // certain fields divide by count
    }

}
