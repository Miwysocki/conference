package com.example.conference.Lecture;


import org.springframework.stereotype.Service;

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
        int subId = 0;
        for(int i =1; i <= 9;i++){
            Lecture lecture = new Lecture(i-1,subId,"name"+i,"subjectName"+subId,time,0);
            schedule.add(lecture);
            subId++;
            if(i == 3 || i == 6){
                time  = time.plusHours(2);
                subId =0;
            }
        }
    }


    public List<Lecture> getSchedule() {
        return schedule;
    }
    public int getReservations(int lectureId){
        return  schedule.get(lectureId).getReservations();
    }

    public Lecture getLecture(int lectureId){
        return  schedule.get(lectureId);
    }

    public void addReservation(int lectureId){
        schedule.get(lectureId).reservations += 1;
    }

}
