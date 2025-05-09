package com.example.Joblisting.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.example.Joblisting.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class SearchRepositoryImpl implements SearchRepository {
    
    @Autowired
    MongoClient client;
    
    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text) {
        final List<Post> posts = new ArrayList<>();

        // 1. Connect to the database and collection
        MongoDatabase database = client.getDatabase("joblisting");
        MongoCollection<Document> collection = database.getCollection("JobPost"); // <-- specify collection name

        // 2. Build the aggregation pipeline
        List<Document> pipeline = Arrays.asList(
            new Document("$search",
                new Document("index", "default")
                    .append("text", new Document("query", text)
                        .append("path", Arrays.asList("techs", "desc", "profile")))),
            new Document("$sort", new Document("exp", 1L)),
            new Document("$limit", 2L)
        );

        // 3. Execute aggregation and convert results
        AggregateIterable<Document> result = collection.aggregate(pipeline);
        result.forEach(doc -> posts.add(converter.read(Post.class, doc)));

        return posts;
    }
}
