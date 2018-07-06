package com.lotus.mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDbSBTest {

    @Autowired
    private MongoDbFactory mongoDbFactory;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void createDB(){
        String dbName = "db2";
        MongoDatabase mongoDatabase = mongoDbFactory.getDb(dbName);
        String collectionName = "work";
        MongoCollection<Document> mcd = mongoDatabase.getCollection(collectionName);
        if (mcd == null) {
            mongoDatabase.createCollection(collectionName);
            mcd = mongoDatabase.getCollection(collectionName);
        }
        Document document = new Document();
        document.append("id",1).append("name","name1");
        mcd.insertOne(document);
        FindIterable<Document> fid  =  mcd.find();
        MongoCursor<Document> mcr =  fid.iterator();
        while (mcr.hasNext()){
            System.out.println(mcr.next());
        }
    }

    @Test
    public void selectTable(){
        System.out.println("CollectionNames:"+mongoTemplate.getCollectionNames());
        String collectionName = "work";
        List<Work> works = mongoTemplate.findAll(Work.class,collectionName);
        System.out.println("works:"+works);
    }


    @Test
    public void saveValues(){
        List<Work> works = new ArrayList<Work>();
        String collectionName = "work";
        for (int i = 0; i <5 ; i++) {
            Work work = new Work();
            work.setId(i);
            work.setName("name" + i);
            mongoTemplate.save(work,collectionName);
        }
        //mongoTemplate.insert(works,Work.class);

        List<Work> result = mongoTemplate.findAll(Work.class,collectionName);
        System.out.println("result:"+result);
    }

    @Test
    public void update(){
        String collectionName = "work";
        Query query = new Query();
        Update update = new Update();

        UpdateResult result = mongoTemplate.updateMulti(query,update,Work.class);
        System.out.println("result:"+result);

    }


}

@org.springframework.data.mongodb.core.mapping.Document(collection = "work")
class Work{
    @Field(value = "id")
    private Integer id;
    @Field(value = "name")
    private String name;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
