package com.example.conference.Lecture;


import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LectureService {

    List<Lecture> schedule;

    public LectureService() {
        schedule = new ArrayList<>();
        createSchedule();

    }
    private void createSchedule() {
        LocalTime time =  LocalTime.of(10,0);
        for(int i =1; i <= 9;i++){
            Lecture lecture = new Lecture(i,i%3,"name"+i,"subjectName"+(i%3),time);
            schedule.add(lecture);
            if(i == 3 || i == 6){
                time  = time.plusHours(2);
            }
        }
    }


    public List<Lecture> getSchedule() {

        return schedule;
    }
}
