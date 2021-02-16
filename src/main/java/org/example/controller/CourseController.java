package org.example.controller;

import org.example.entity.Course;
import org.example.entity.Topic;
import org.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllTopics(@PathVariable String topicId){
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getTopic(@PathVariable String id){
        return courseService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addTopic(@RequestBody Course course,@PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addTopic(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateTopic(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateTopic(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteTopic(@PathVariable String id){
        courseService.deleteTopic(id);
    }
}
