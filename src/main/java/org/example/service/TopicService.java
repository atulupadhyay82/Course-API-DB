package org.example.service;


import org.example.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class TopicService {


    private List<Topic> topics= new ArrayList<>(Arrays.asList(
            new Topic("spring","Spring Framework","Spring Framework Description"),
            new Topic("java","Core Java","Core Java Description"),
             new Topic("javascript","Java Script","Java Script Description")
    ));


    public List<Topic> getAllTopics(){
       return topics;
    }


    public Topic getTopic(String id){
        return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();

    }

    public void addTopic(Topic topic){
        topics.add(topic);

    }

    public void updateTopic(String id, Topic topic){
        for(int i=0; i<topics.size(); i++){
            Topic temp= topics.get(i);
            if(temp.getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }
    }

    public void deleteTopic(String id){
        topics.removeIf(t-> t.getId().equals(id));
    }
}
