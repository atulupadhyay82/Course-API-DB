package org.example.service;

import org.example.dao.CourseRepository;
import org.example.entity.Course;
import org.example.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Commented out code is hard coded list and current code use embedded H2 db for Data storage.
 */
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /**
     * It is iterable so we need to convert this into List.
     * So here it is performing all the operation automatically-- connecting to the db, returning all the rows and converting each of those rows into
     * the Topic instances and getting it back.
     * @return
     * @param topicId
     */
    public List<Course> getAllCourses(String topicId){
        List<Course> courses=new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
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
    public Optional<Course> getTopic(String id){
       return courseRepository.findById(id);
    }

    public void addTopic(Course course){
        courseRepository.save(course);
    }

    public void updateTopic(Course course){
        courseRepository.save(course);

    }

    public void deleteTopic(String id){
        courseRepository.deleteById(id);
    }
}
