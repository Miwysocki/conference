package com.example.conference.Lecture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LectureController {


    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }
    @PostConstruct
    @GetMapping("/schedule")
    public List<Lecture> getSchedule(){
        return lectureService.getSchedule();
    }
}
