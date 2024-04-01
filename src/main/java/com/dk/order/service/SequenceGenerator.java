package com.dk.order.service;

import com.dk.order.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGenerator {
    @Autowired
    public MongoOperations mongoOperations;

    public int generateNextOrderId(){
        Sequence counter=mongoOperations.findAndModify(
                query(where("_id").is("sequence")),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                Sequence.class
        );
        return counter.getSeq();

    }

}
