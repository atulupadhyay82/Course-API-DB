package org.example.dao;


import org.example.entity.Topic;
import org.springframework.data.repository.CrudRepository;

/**
 *  if you are just doing standard CRUD operations on the entity class, you don't need to implement data layer class. You just use CrudRepository which comes with Spring JPA.
 *
 * No need to implement these methods here as Spring JPA teams has provided these methods here with this interface
 //getAllTopics()
 //getTopic(String id)
 //updateTopic(String id, Topic topic)
 //deleteTopic(String id)
 * Only for customized data operations, you need to do the implementation like if you need to search a Topic which contains some particular text in the description.
 */
public interface TopicRepository extends CrudRepository<Topic, String> {
}
