package com.slava.snake.collection;

import lombok.Data;

@Data
public class SalesByDate {

    AmountValue orderedProductSales;

    AmountValue orderedProductSalesB2B;

    long unitsOrdered;

    long unitsOrderedB2B;

    long totalOrderItems;

    long totalOrderItemsB2B;

    AmountValue averageSalesPerOrderItem;

    AmountValue averageSalesPerOrderItemB2B;

    double averageUnitsPerOrderItem;

    double averageUnitsPerOrderItemB2B;

    AmountValue averageSellingPrice;

    AmountValue averageSellingPriceB2B;

    long unitsRefunded;

    double refundRate;

    long claimsGranted;

    AmountValue claimsAmount;

    AmountValue shippedProductSales;

    long unitsShipped;

    long ordersShipped;

}
