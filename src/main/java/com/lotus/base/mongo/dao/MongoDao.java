package com.lotus.base.mongo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MongoDao {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoDao (MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }


}
