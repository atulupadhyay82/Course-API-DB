package org.example.service;

import org.example.dao.TopicRepository;
import org.example.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Commented out code is hard coded list and current code use embedded H2 db for Data storage.
 */
@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    /**
     * It is iterable so we need to convert this into List.
     * So here it is performing all the operation automatically-- connecting to the db, returning all the rows and converting each of those rows into
     * the Topic instances and getting it back.
     * @return
     */
    public List<Topic> getAllTopics(){
        List<Topic> topics=new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    /**
     * Retrieves an entity by its id.
     *
     * Params:
     * id – must not be null.
     * Returns:
     * the entity with the given id or Optional#empty() if none found
     * Throws:
     * IllegalArgumentException – if id is null.
     * @param id
     * @return
     */
    public Optional<Topic> getTopic(String id){
       return topicRepository.findById(id);
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic){
        topicRepository.save(topic);

    }

    public void deleteTopic(String id){
       topicRepository.deleteById(id);
    }
}
