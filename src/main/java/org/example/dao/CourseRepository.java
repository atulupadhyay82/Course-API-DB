package org.example.dao;


import org.example.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

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
public interface CourseRepository extends CrudRepository<Course, String> {

    /**
     * Custom method which is not comes with CrudRespository and filter course by courseName.
     * 1st follow method Convention for other field filter like for existing ID field, we have findById in CrudRepository
     * But there is no implementation required as Spring DATA JPA is going to split the methodName and check if last string "Description"
     * is matching to any of Course entity column name;
     */
    public List<Course> findByName(String topicName);

    /**
     * To filter out the description
     */
    public List<Course> findByDescription(String topicDescription);

    /**
     * Here I am filtering the courses by Topic. So Spring JPA split this method, first it gets Topic and second it gets id for Topic
     */
    public List<Course> findByTopicId(String topicId);
}
