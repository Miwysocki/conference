package com.example.conference.Lecture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
public class Lecture {
    int id;
    int subjectId;
    String name;
    String subject;
    LocalTime startingTime;
    int reservations;
}
