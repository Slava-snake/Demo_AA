package com.slava.snake.collection;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "test_report")
@Data
public class ReportCollection {

    @Id
    ObjectId _id;

    ReportSpecification reportSpecification;

    List<StatDate> salesAndTrafficByDate;

    List<StatAsin> salesAndTrafficByAsin;

}
