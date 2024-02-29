package com.slava.snake.repository;

import com.slava.snake.collection.ReportCollection;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DemoAARepository extends MongoRepository <ReportCollection, String> {

}
