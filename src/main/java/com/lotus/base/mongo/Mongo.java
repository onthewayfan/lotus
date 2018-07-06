package com.lotus.base.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;

import javax.annotation.Resource;

@Resource
public class Mongo {

    private final MongoDbFactory mongoDbFactory;

    @Autowired
    public Mongo(MongoDbFactory mongoDbFactory){
        this.mongoDbFactory = mongoDbFactory;
    }




}
