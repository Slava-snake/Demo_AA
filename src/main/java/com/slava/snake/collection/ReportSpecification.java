package com.slava.snake.collection;

import lombok.Data;

@Data
public class ReportSpecification {

    String reportType;

    ReportOptions reportOptions;

    String dataStartTime;

    String dataEndTime;

    String[] marketplaceIds;

}
