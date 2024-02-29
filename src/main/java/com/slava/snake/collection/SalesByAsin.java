package com.slava.snake.collection;

import lombok.Data;

@Data
public class SalesByAsin {

    long unitsOrdered;
    
    long unitsOrderedB2B;
    
    AmountValue orderedProductSales;
    
    AmountValue orderedProductSalesB2B;
    
    long totalOrderItems;
    
    long totalOrderItemsB2B;
    
}
